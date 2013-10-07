package br.com.semighini.exception

import scalaxb.Fault


/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 07/10/13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
class MultiRouteException(message:String) extends WebServiceException(message){
  def this(fault:Fault[Any]) = this(WebServiceErrorMessageExtractor.extractMessage(fault.original.toString))
}
