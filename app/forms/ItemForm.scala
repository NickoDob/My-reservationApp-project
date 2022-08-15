package forms

import models.Item
import play.api.data.Form
import play.api.data.Forms._

object ItemForm {

  /**
   * Форма Play Framework.
   */
  val form: Form[Item] = Form(
    mapping(
      "id" -> ignored(-1L),
      "address" -> text,
      "heating" -> text,
      "square" -> bigDecimal,
      "price" -> bigDecimal,
    )(Item.apply)(Item.unapply)
  )
}
