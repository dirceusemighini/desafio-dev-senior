package controllers

import play.api.Play._
import play.api.mvc.{Controller, Action}


/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 06/10/13
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
object SwaggerController extends Controller{

  def index = Action {
    Ok(views.html.swagger("http://localhost:9000"))
  }
}
