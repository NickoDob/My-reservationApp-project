package models

import play.api.libs.functional.syntax.{toFunctionalBuilderOps, unlift}
import play.api.libs.json.{JsObject, JsPath, JsValue, Json, Reads, Writes}
import slick.jdbc.GetResult

import java.time.LocalDate
import java.util.UUID

case class Event(id: Long, startDateTime: LocalDate, endDateTime: LocalDate, orgUserId: UUID, members: Option[JsValue], itemId: Long, description: Option[String])

object Event {
  implicit val EventReads: Reads[Event] = (
    (JsPath \ "id").read[Long] and
      (JsPath \ "startDateTime").read[LocalDate] and
      (JsPath \ "endDateTime").read[LocalDate] and
      (JsPath \ "orgUserId").read[UUID] and
      (JsPath \ "members").readNullable[JsValue] and
      (JsPath \ "itemId").read[Long] and
      (JsPath \ "description").readNullable[String]
    )(Event.apply _)

  implicit val EventWrites: Writes[Event] = (
    (JsPath \ "id").write[Long] and
      (JsPath \ "startDateTime").write[LocalDate] and
      (JsPath \ "endDateTime").write[LocalDate] and
      (JsPath \ "orgUserId").write[UUID] and
      (JsPath \ "members").writeNullable[JsValue] and
      (JsPath \ "itemId").write[Long] and
      (JsPath \ "description").writeNullable[String]
    )(unlift(Event.unapply))

  implicit val getR: GetResult[Event] = GetResult(r => Event(r.nextLong(), r.nextDate().toLocalDate, r.nextDate().toLocalDate, UUID.fromString(r.nextString()), Json.parse(r.nextString()).asOpt[JsValue], r.nextLong(), r.nextStringOption()))
}