package br.com.semighini.config

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */

import com.typesafe.config.{ConfigFactory, Config}
import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object ConfigUtil {

  private lazy val referenceConfig = ConfigFactory.defaultReference

  def getSubConfig(config: Config, path: String): Config = {
    val c = config.withFallback(referenceConfig)
    c.checkValid(referenceConfig, path)
    c.getConfig(path)
  }
}