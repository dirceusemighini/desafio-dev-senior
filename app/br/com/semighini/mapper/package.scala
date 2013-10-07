package br.com.semighini

import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.joda.time.{LocalDate, Period}
import br.com.semighini.model.{RouteStopPointsRouteType, RouteTotalsResult}
import generated.{City, Address}
import br.com.semighini.enums.RouteType

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 05/10/13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
package object mapper {

  implicit lazy val routeTypeMapper = RouteTypeMapper

  implicit lazy val cityFormatter = Json.format[City]

  implicit lazy val addressFormatter = Json.format[Address]

  implicit lazy val periodMapper = PeriodFormatter

  implicit lazy val routeTotalResultWriter = Json.writes[RouteTotalsResult]

  implicit lazy val addressListRouteTypeMapper = Json.format[RouteStopPointsRouteType]

}
