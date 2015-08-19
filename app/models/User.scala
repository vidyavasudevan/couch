package models

import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * Created by vidya.v on 4/26/15.
 */
class User(
    val id: String,
    val fullname: String,
    val email: String,
    val username: String,
    val password: String,
    val location: String
   )
object User {

  implicit val userReader = (
     (__ \ "name").read[String] and
      (__ \ "email").read[String] and
      (__ \"username").read[String] and
      (__ \ "password").read[String] and
      (__ \"location").format[String]
    )(User.apply _)

   implicit val userWrites = (
    (__ \ "id").write[String] and
    (__ \ "name").write[String] and
    (__ \ "email").write[String] and
    (__ \"username").write[String] and
    (__ \"location").write[String]
  ) (User.unapply _)

  def apply(name: String, email: String, userName: String, password: String, location: String) = {
      new User(id,name, email, userName, password, location)
  }

  def unapply(u: User) = {
    (u.id, u.fullname, u.email, u.username, u.location)
  }
  def id = java.util.UUID.randomUUID.toString


}