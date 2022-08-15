package models.daos

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._

import javax.inject.Inject
import scala.concurrent.ExecutionContext

/**
 * Предоставляет доступ к хранилищу ролей пользователя
 *
 * @param dbConfigProvider Провайдер конфигурации базы данных
 * @param ec Контекст выполнения
 */
class UserRolesDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends TableDefinitions with HasDatabaseConfigProvider[JdbcProfile] {

  /**
   * Получает роль 'Пользователь' из таблицы
   *
   * @return
   */
  def getUserRole: DBIOAction[Int, NoStream, Effect.Read] =
    userRoles.filter(_.name === "User").map(_.id).result.headOption.map{
      case Some(id) => id
      case None => throw new RuntimeException("Роль пользователя отсутсвует в БД")
    }
}
