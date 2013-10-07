package br.com.semighini.exception

import scalaxb.Fault


/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
class AddressFindException(message:String) extends WebServiceException(message){

  def this(fault:Fault[Any]) = this(WebServiceErrorMessageExtractor.extractMessage(fault.original.toString))
}