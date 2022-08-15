package models.daos

import com.google.inject.Inject
import models.Event
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import slick.jdbc.PostgresProfile.api._

import java.sql.Date
import java.time.LocalDate
import scala.concurrent.{ExecutionContext, Future}

class EventDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends DatabaseDAO {

  /**
   * Извлекает событие по дате начала и дате окончания
   *
   * @param startDateTime Дата и время начала события
   * @param endDateTime Дата и время окончанния события
   * @param itemID ID склада
   * @return
   */

  def getByDateTimeAndItemID(startDateTime: LocalDate, endDateTime: LocalDate, itemID: Long): Future[Option[Event]] = {
    db.run(events.filter(_.itemId === itemID)
      .filter(time => time.startDateTime <= startDateTime && time.endDateTime >= startDateTime || time.startDateTime <= endDateTime && time.endDateTime >= endDateTime || time.startDateTime >= startDateTime && time.endDateTime <= endDateTime)
      .result.headOption)
  }

  /**
   * Извлекает событие по его ID
   *
   * @param eventID ID события
   * @return
   */
  def getByID(eventID: Long): Future[Option[Event]] = {
    db.run(events.filter(_.id === eventID).result.headOption)
  }

  /**
   * Получение всех событий
   *
   * @return Список всех событий
   */
  def getAll: Future[Seq[Event]] = {
    db.run(events.result)
  }

  /**
   * Добавление нового события
   *
   * @param event Событие для добавления
   * @return
   */
  def add(event: Event): Future[Event] = {
    db.run(events +=
        Event(event.id, event.startDateTime, event.endDateTime, event.orgUserId, event.members, event.itemId, event.description))
      .map(_ => event)
  }

  /**
   * Обновляет данные события
   *
   * @param event Объект для обновления
   * @return
   */
  def update(event: Event): Future[Event] =
    db.run(events.filter(_.id === event.id)
      .map(evt => (evt.startDateTime, evt.endDateTime, evt.orgUserId, evt.members, evt.itemId, evt.description))
      .update((event.startDateTime, event.endDateTime, event.orgUserId, Some(Json.toJson(event.members)), event.itemId, event.description)).map(_ => event))

  /**
   * Удаляет данные события
   *
   * @param eventID ID события
   * @return
   */
  def delete(eventID: Long): Future[Boolean] =
    db.run(events.filter(_.id === eventID).delete).map(_ > 0)
}
