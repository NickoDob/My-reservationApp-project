package models

import play.api.libs.functional.syntax.{toFunctionalBuilderOps, unlift}
import play.api.libs.json.{JsPath, Reads, Writes}

case class Item(id: Long, address: String, heating: String, square: BigDecimal, price: BigDecimal)

object Item {
  implicit val ItemReads: Reads[Item] = (
    (JsPath \ "id").read[Long] and
        (JsPath \ "address").read[String] and
          (JsPath \ "heating").read[String] and
            (JsPath \ "square").read[BigDecimal] and
              (JsPath \ "price").read[BigDecimal]
    )(Item.apply _)

  implicit val ItemWrites: Writes[Item] = (
    (JsPath \ "id").write[Long] and
        (JsPath \ "address").write[String] and
          (JsPath \ "heating").write[String] and
            (JsPath \ "square").write[BigDecimal] and
              (JsPath \ "price").write[BigDecimal]
    )(unlift(Item.unapply))
}
