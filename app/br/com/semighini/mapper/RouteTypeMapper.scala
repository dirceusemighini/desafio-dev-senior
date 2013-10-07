package br.com.semighini.mapper

import play.api.libs.json._
import play.api.libs.json.JsSuccess
import br.com.semighini.enums.RouteType

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 05/10/13
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
object RouteTypeMapper extends Format[RouteType.Value] {
  def reads(json: JsValue): JsResult[RouteType.Value] = {
    JsSuccess(RouteType(json.as[Int]))
  }

  def writes(o: RouteType.Enum): JsValue = {
    Json.toJson(o.id)
  }
}