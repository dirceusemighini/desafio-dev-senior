package br.com.semighini.exception

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 07/10/13
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
object WebServiceErrorMessageExtractor {
  def extractMessage(message: String): String = {
    ("(?<=Reasontext\\().+?(?=\\))".r findFirstIn message).getOrElse("")
  }
}
