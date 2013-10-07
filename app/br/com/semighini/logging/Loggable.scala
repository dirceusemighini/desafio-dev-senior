package br.com.semighini.logging

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */

trait Loggable {

  @transient
  protected lazy val logger: Logger = Logger(getClass)
}
