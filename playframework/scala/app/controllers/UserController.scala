package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by CHHAI CHIVON
  */
class UserController extends Controller{
  def index = Action{
    Ok(views.html.user("User"))
  }
}
