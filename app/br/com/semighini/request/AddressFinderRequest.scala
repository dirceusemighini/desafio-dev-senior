package br.com.semighini.request

import br.com.semighini.logging.Loggable

import scalaxb.{DispatchHttpClients, SoapClients}
import generated._
import scala.concurrent.Future
import soapenvelope12.{Faultreason, Reasontext, Detail}

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
object AddressFinderRequest extends HttpClientRequestConfig with Loggable {

  lazy val addressFinder = new AddressFinderSoap12Bindings
    with SoapClients
    with DispatchHttpClients {}

  def findGeoCodingFromAddress(address: Address): Either[scalaxb.Fault[Any], generated.Point] = {
    addressFinder.service.getXY(address, token)
  }
}