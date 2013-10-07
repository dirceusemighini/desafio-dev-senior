package br.com.semighini.exception

import scala.util.control.NoStackTrace
import scalaxb.Fault

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 07/10/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
class WebServiceException(message:String) extends
RuntimeException(message) with NoStackTrace {
  def this(fault:Fault[Any]) = this(WebServiceErrorMessageExtractor.extractMessage(fault.original.toString))
}
