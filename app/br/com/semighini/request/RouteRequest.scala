package br.com.semighini.request

import generated._
import scalaxb.{DispatchHttpClients, SoapClients}
import br.com.semighini.logging.Loggable
import generated.MultiRouteRequest
import generated.RouteStop
import br.com.semighini.enums.RouteType
import br.com.semighini.exception.MultiRouteException

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
object RouteRequest extends HttpClientRequestConfig with Loggable {

  lazy val route = new RouteSoap12Bindings
    with SoapClients
    with DispatchHttpClients {}

  lazy val vehicle = Vehicle(45, 10, 1.69, 60, 2)

  def routeOptions(routeType: RouteType.Value) = {
    val routeDetails = RouteDetails(routeType.id, 1, true)
    RouteOptions(routeDetails = routeDetails, vehicle = vehicle)
  }

  def getMultiRoute(routeStops: List[RouteStop], routeType: RouteType.Value) = {
    logger.debug("getMultiRoute ${routeStops.mkString(\",\")}")
    if (routeStops.size < 2) {
      throw new MultiRouteException("Lista de paradas invalida, devemos ter ao menos duas paradas.")
    }
    val multiRouteRequest = Some(new ArrayOfMultiRouteRequest(generateMultiRouteRequest(routeStops): _*))
    route.service.getMultiRoute(multiRouteRequest, routeOptions(routeType), token)
  }

  private def generateMultiRouteRequest(routeStops: List[RouteStop],
                                        multiRouteRequestList: List[MultiRouteRequest] = List.empty)
  : List[MultiRouteRequest] = {
    if (routeStops.isEmpty || routeStops.size == 1) {
      multiRouteRequestList.reverse
    } else {
      generateMultiRouteRequest(routeStops.tail,
        MultiRouteRequest(routeStops.head, routeStops.tail.head) :: multiRouteRequestList)
    }
  }
}
