package br.com.semighini.request

import org.specs2.mutable.Specification
import generated.{City, Address}
import soapenvelope12.XMLProtocol
import soapenvelope12.`package`._
/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
class TestAddressFinderRequest extends Specification{

  "AddressFinder" should {
    "Call findGeoCodingFromAddress successfully " in {

      val city = new City(Some("Sao Paulo"),Some("SP"))
      val address = new Address(Some("Av Paulista"),Some("237"),None,None,city)
      val result = AddressFinderRequest.findGeoCodingFromAddress(address)
      result.isRight must beTrue
      val point = result.right.get
      point.x must be_!=(0d)
      point.y must be_!=(0d)
    }

    "Call should fail in findGeoCodingFromAddress invalid request " in {
      val city = new City(Some("Sao Paulo"),Some("Sao Paulo"))
      val address = new Address(Some("Av Paulista"),Some("237"),None,None,city)
      val result = AddressFinderRequest.findGeoCodingFromAddress(address)
      result.isLeft must beTrue
    }
  }


}
