package models

import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * Created by vidya.v on 4/26/15.
 */
 class User(
    id:       String,
    fullname: String,
    email: String,
    username: String,
    password: String,
    location: String
   )

object User {
  implicit val userReads: Reads[User] = (
    (JsPath \ "fullName").read[String] and
      (JsPath \ "email").read[String] and
      (JsPath \ "userName").read[String] and
      (JsPath \ "password").read[String] and
      (JsPath \ "location").read[String]
    )(User.apply _)

  implicit val userWrites: Writes[User] = (
       Json.obj(
        "name" -> u.fullname,
        "email" -> u.email,
        "username" -> u.username,
        "location" -> u.location
      )
    )



   def apply(fullName: String, email: String, userName: String, password: String, location: String): User = {
     new User(id, fullName, email, userName, password, location )
  }

  def id = java.util.UUID.randomUUID.toString
}