package controllers

import play.api.mvc.{Action, Controller}


import scala.concurrent.Await

/**
  * Created by CHHAI CHIVON
  */
class UserController extends Controller{
  def index = Action{
    Ok(views.html.user("User"))
  }
/*  def findAll(sort: String, page: Int, limit: Int) = Action {
    val sortData = new FilterData(sort)
    val getCount = Await.result(hospitalService.getTotalHospital(), 10 seconds)
    val pagination = new Pagination(page, limit, getCount)
    hospitalService.list(pagination, sortData).flatMap(hospital => ok(hospital))
  }*/
}
