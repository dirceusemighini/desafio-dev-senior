package br.com.semighini.request

import generated.{Point, RouteStop, Address, City}
import org.specs2.mutable.Specification
import br.com.semighini.enums.RouteType

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class TestRouteRequest extends Specification{

  "Routes" should {
    "Call getNultiRouteRequest successfully " in {
      val firstStop = RouteStop(Some("Avenida Paulista, 1000"),Point(-46.6520066,-23.5650127))
      val secondStop = RouteStop(Some("Av Pres Juscelino Kubitschek, 1000"),Point(-46.679055,-23.589735))
      val thirdStop = RouteStop(Some("Avenida Paulista, 1000"),Point(
       -46.6520066,-23.5650127))
      val fourthStop = RouteStop(Some("Av Nove de Julho, 1500"),Point(-46.6513602,-23.5564401))

      val routeStops = List(firstStop,secondStop,thirdStop,fourthStop)

      val routes = RouteRequest.getMultiRoute(routeStops,RouteType.AvoidTraffic)
      routes.isRight must beTrue
    }


  }
}
