package models


import play.api.libs.json.{ JsObject, OWrites }
import play.api.libs.json._
import scala.Predef.StringFormat


/**
  * Created by CHHAI CHIVON
  */
case class User (id: String, username : String, password: String, email: String)

object User {
  implicit val userFormat = Json.format[User]
}