package br.com.semighini.component

import org.specs2.mutable.Specification
import generated.{Address, City}
import br.com.semighini.request.AddressFinderRequest
import br.com.semighini.enums.RouteType
import scala.compat.Platform
import br.com.semighini.exception.{MultiRouteException, AddressFindException}

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
class TestRouteTotalsCalc extends Specification {

  "RouteTotalsCalc" should {
    "Success when calculate the route from right addresses " in {
      val birigui = new City(Some("Birigui"), Some("SP"))
      val city = new City(Some("Sao Paulo"), Some("SP"))
      val address1 = new Address(Some("Av Paulista"), Some("2004"), None, None, city)
      val address2 = new Address(Some("Av Reboucas"), Some("450"), None, None, city)
      val address3 = new Address(Some("Rua Funchal"), Some("570"), None, None, city)
      val address4 = new Address(Some("Av Santo Amaro"), Some("423"), None, None, city)
      val address5 = new Address(Some("av rio branco"), Some("220"), None, None, birigui)
      val addresses = List(address1, address2, address3, address4, address5)
      val requestResult = RouteTotalsCalc.getRouteTotalCostsAndTime(addresses, RouteType.AvoidTraffic)
      requestResult.totalCost must beGreaterThan(BigDecimal(0))
      requestResult.totalDistance must beGreaterThan(BigDecimal(0))
   }

    "Fail when calculate the route using wrong addresses " in {
      val birigui = new City(Some("Birigui"), Some("Sao Paulo"))
      val city = new City(Some("Sao Paulo"), Some("SP"))
      val address1 = new Address(Some("Av Paulista"), Some("200"), None, None, city)
      val address2 = new Address(Some("Av Reboucas"), Some("560"), None, None, city)
      val address3 = new Address(Some("Rua Funchal"), Some("120"), None, None, city)
      val address4 = new Address(Some("Av Santo Amaro"), Some("2040"), None, None, city)
      val address5 = new Address(Some("av rio branco"), Some("430"), None, None, birigui)
      val addresses = List(address1, address2, address3, address4, address5)
      RouteTotalsCalc.getRouteTotalCostsAndTime(addresses, RouteType.AvoidTraffic) must throwA[AddressFindException]

    }


    "Fail when try to use only one address " in {
      val city = new City(Some("Sao Paulo"), Some("SP"))
      val address1 = new Address(Some("Av Paulista"), Some("2003"), None, None, city)
      val addresses = List(address1)
      RouteTotalsCalc.getRouteTotalCostsAndTime(addresses, RouteType.AvoidTraffic) must throwA[MultiRouteException]

    }
  }

}
