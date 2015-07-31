package controllers

import models.{Story, User}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
 * Created by vidya.v on 7/10/15.
 */
object APIController extends Controller {

  def addUser() = Action {
    request =>
      val reqJson = request.body
      val userModel = reqJson.asJson.get.as[User]

      val add = Barista.addUser(userModel)
      play.Logger.info(s"Add Result = $add")
      Ok(Json.toJson(userModel))
  }
  
  def addStory() = Action {
     request =>
       val story = request.body.asJson.get.as[Story]
       val add = Barista.addStory(story)
       play.Logger.info(s"AddStory result = $add")
       Ok(Json.toJson(userModel))
  }
}