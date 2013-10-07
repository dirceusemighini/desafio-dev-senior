package br.com.semighini.config

import com.typesafe.config.ConfigFactory

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
object WebServiceConfig {
  @transient
  lazy val config = ConfigUtil.getSubConfig(ConfigFactory.load(), "moip.webservice")
  lazy val token = config.getString("token")
  lazy val addressURL = config.getString("request.url")
  lazy val routeURL = config.getString("route.url")
}
