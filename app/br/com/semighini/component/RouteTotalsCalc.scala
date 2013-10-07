package br.com.semighini.component


import br.com.semighini.logging.Loggable
import br.com.semighini.enums.RouteType
import generated.{MultiRoute, RouteStop, Address}
import br.com.semighini.request.{RouteRequest, AddressFinderRequest}
import br.com.semighini.exception.{WebServiceErrorMessageExtractor, MultiRouteException, AddressFindException}
import br.com.semighini.model.{RouteTotalsResult, FindGeoCodingFromAddressResult}
import org.joda.time.{Interval, Duration, Period, DateTime}
import org.joda.time.format.ISOPeriodFormat

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
object RouteTotalsCalc extends Loggable {
  def getRouteTotalCostsAndTime(addresses: List[Address], routeType: RouteType.Value) = {

    if (routeType != RouteType.AvoidTraffic && routeType != RouteType.Fastest) {
      throw new IllegalArgumentException("Tipo Invalido de tipo rota, os tipos válidos são: \n 0 Para rota padrão mais rápida \n 23 Rota evitando o trânsito.")
    }

    logger.debug("Start processing the list of addresses")
    val routeStops = getRouteStopsFromAddresses(addresses)

    val result = RouteRequest.getMultiRoute(routeStops, routeType)
    result match {
      case Left(l) => {
        throw new MultiRouteException(l)
      }
      case Right(r) => {
        calculateRouteTotalsFromMultiRoute(r)
      }
    }
  }

  def calculateRouteTotalsFromMultiRoute(multiRoute: MultiRoute) = {
    val singleRouteTotalsSeq = multiRoute.singleRouteTotals.map(f =>
      f.SingleRouteTotals.map(_.routeTotals)).getOrElse(Seq.empty)

    singleRouteTotalsSeq.foldLeft(new RouteTotalsResult()) {
      (a, b) =>
        val totalTime = b.totalTime.map(time =>
          Period.parse(time, ISOPeriodFormat.standard())).getOrElse(new Period(0l))
        RouteTotalsResult(a.totalDistance + b.totalDistance, a.totalfuelCost + b.totalfuelCost,
          a.totalCost + b.totalCost, a.totalTime.plus(totalTime))
    }
  }

  def getRouteStopsFromAddresses(addresses: List[Address]) = {
    val results = addresses.map(addr => FindGeoCodingFromAddressResult(addr, AddressFinderRequest.findGeoCodingFromAddress(addr)))
    if (results.forall(_.result.isRight)) {
      results.map(res => RouteStop(res.name, res.result.right.get))
    } else {
      val message = results.filter(_.result.isLeft).map(_.result.left.get.original.toString).mkString("\n")

      logger.error(s"Os seguintes erros aconteceram ao buscar enderecos: \n  ${WebServiceErrorMessageExtractor.extractMessage(message)}")
      throw new AddressFindException(message)
    }
  }

}

