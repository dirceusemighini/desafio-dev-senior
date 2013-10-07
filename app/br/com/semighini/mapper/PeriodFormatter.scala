package br.com.semighini.mapper

import play.api.libs.json._
import br.com.semighini.enums.RouteType
import play.api.libs.json.JsSuccess
import org.joda.time.Period
import org.joda.time.format.ISOPeriodFormat

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 05/10/13
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
object PeriodFormatter extends Format[Period] {
  def reads(json: JsValue): JsResult[Period] = {
    JsSuccess(Period.parse(json.as[String], ISOPeriodFormat.standard()))
  }

  def writes(period: Period): JsValue = {
    Json.toJson(period.toString(ISOPeriodFormat.standard()))
  }
}