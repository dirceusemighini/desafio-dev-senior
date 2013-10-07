package br.com.semighini.model

import generated.{Point, Address}
import scalaxb.Fault

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
case class FindGeoCodingFromAddressResult(private val address: Address, result: Either[Fault[Any], Point]) {
  val name = Some(s" ${address.street}, ${address.houseNumber}")
}
