package controllers

import play.api.mvc._
import views._


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}