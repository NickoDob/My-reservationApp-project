package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{Json, OFormat}

import java.time.LocalDate

object EventForm {
  case class EventData( startDateTime: LocalDate, endDateTime: LocalDate, orgUserID: String, members: Option[List[String]], itemID: Long, description: Option[String])

  implicit val EventFormat: OFormat[EventData] = Json.format[EventData]

  /**
   * Форма Play Framework.
   */
  val form: Form[EventData] = Form(
    mapping(
      "startDateTime" -> localDate("yyyy-MM-dd"),
      "endDateTime" -> localDate("yyyy-MM-dd"),
      "orgUserID" -> nonEmptyText,
      "members" -> optional(list(text)),
      "itemID" -> longNumber(1),
      "description" -> optional(text)
    )(EventData.apply)(EventData.unapply)
  )
}
