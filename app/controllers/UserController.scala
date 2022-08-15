package controllers

import com.mohiva.play.silhouette.api.Silhouette
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.util.PasswordInfo
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import forms.UserRoleForm
import forms.UserForm
import com.mohiva.play.silhouette.api.util.{Credentials, PasswordHasherRegistry, PasswordInfo}
import forms.ChangePasswordForm
import models.UserRoles
import models.User
import models.services._
import play.api.libs.json.Json
import play.api.mvc._
import utils.auth.{HasSignUpMethod, JWTEnvironment}

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

/**
 * Контроллер для работы с пользователями
 *
 * @param silhouette           Стек Silhouette
 * @param controllerComponents Экземпляр трейта `ControllerComponents`
 * @param userService          Сервис для работы с пользователями
 * @param credentialsProvider  Провайдер аутентификации по логину/паролю (Silhouette)
 * @param authInfoRepository   Репозиторий информации об авторизации (Silhouette)
 * @param hasSignUpMethod      Вспомогательная утилита для проверки наличия метода аутентификации
 * @param ex                   Контекст выполнения
 */
class UserController @Inject()(silhouette: Silhouette[JWTEnvironment],
                               controllerComponents: ControllerComponents,
                               userService: UserService,
                               credentialsProvider: CredentialsProvider,
                               authInfoRepository: AuthInfoRepository,
                               hasSignUpMethod: HasSignUpMethod)
                              (implicit ex: ExecutionContext) extends AbstractController(controllerComponents) {

  /**
   * Выводит список всех пользователей
   *
   * @return
   */
  def listAll(): Action[AnyContent] = silhouette.SecuredAction.async { implicit request: Request[AnyContent] =>
    userService.retrieveAll.flatMap { users =>
      Future.successful(Ok(Json.toJson(users)).withHeaders("X-Total-Count" -> users.size.toString))
    }
  }

  /**
   * Получает данные пользователя
   *
   * @param userID ID пользователя
   * @return
   */
  def getUserByID(userID: UUID): Action[AnyContent] = silhouette.SecuredAction.async {
    implicit request: Request[AnyContent] =>
      userService.retrieveByID(userID).flatMap {
        case Some(user) => Future.successful(Ok(Json.toJson(user)))
        case None => Future.successful(NotFound(Json.toJson(Json.obj("status" -> "error", "code" -> NOT_FOUND, "message" -> "Пользователь не найден!"))))
      }
  }

  /**
   * Изменяет роль пользователя
   *
   * @param userID ID пользователя
   * @return
   */
  def changeUserRole(userID: UUID): Action[AnyContent] = silhouette.SecuredAction(hasSignUpMethod[JWTEnvironment#A](CredentialsProvider.ID)).async {
    implicit request: SecuredRequest[JWTEnvironment, AnyContent] =>

      UserRoleForm.form.bindFromRequest().fold(
        _ => Future.successful(BadRequest),
        roleId =>
          request.identity.role match {
            case Some("Admin") =>
              userService.changeUserRole(userID, UserRoles.toHumanReadable(roleId)).flatMap(updResult =>
                if (updResult) Future.successful(Ok(Json.toJson(Json.obj("status" -> "success", "message" -> "Роль пользователя успешно обновлена!"))))
                else Future.successful(BadRequest(Json.toJson(Json.obj("status" -> "error", "code" -> INTERNAL_SERVER_ERROR, "message" -> "Произошла ошибка при изменении роли пользователя!")))))
            case _ => Future.successful(Forbidden(Json.toJson(Json.obj("status" -> "error", "code" -> FORBIDDEN, "message" -> "Недостаточно прав для выполнения операции!"))))
          }
      )
  }

  /**
   * Обрабатывает удаление данных пользователя
   *
   * @return Результат выполнения операции
   */
  def delete(userID: UUID): Action[AnyContent] = silhouette.SecuredAction(hasSignUpMethod[JWTEnvironment#A](CredentialsProvider.ID)).async {
    implicit request: SecuredRequest[JWTEnvironment, AnyContent] =>

      request.identity.role match {
        case Some("Admin") =>
          userService.retrieveUserLoginInfo(userID, credentialsProvider.id).flatMap {
            case Some((user, loginInfo)) =>
              authInfoRepository.remove[PasswordInfo](loginInfo)
              userService.delete(userID, user.email).flatMap {
                delResult =>
                  if (delResult) Future.successful(Ok(Json.toJson(Json.obj("status" -> "success", "message" -> "Пользователь успешно удален!"))))
                  else Future.successful(BadRequest(Json.toJson(Json.obj("status" -> "error", "message" -> "Произошла ошибка при удалении пользователя!"))))
              }
            case None => Future.successful(NotFound(Json.toJson(Json.obj("status" -> "error", "code" -> NOT_FOUND, "message" -> "Пользователь не найден!"))))
          }
        case _ => Future.successful(Forbidden(Json.toJson(Json.obj("status" -> "error", "code" -> FORBIDDEN, "message" -> "Недостаточно прав для выполнения операции!"))))
      }
  }
}
