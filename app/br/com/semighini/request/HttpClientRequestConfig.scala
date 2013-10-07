package br.com.semighini.request

import br.com.semighini.config.WebServiceConfig
import java.net.URL
import org.apache.commons.httpclient.{MultiThreadedHttpConnectionManager, HttpClient}

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
trait HttpClientRequestConfig {
  protected lazy val token: Option[String] = Some(WebServiceConfig.token)
  private lazy val connectionTimeout = 10000
  private lazy val socketTimeout = 40000
  private lazy val httpClient = {
    val httpCli = new HttpClient()
    httpCli.setHttpConnectionManager(new MultiThreadedHttpConnectionManager())
    httpCli.getHttpConnectionManager.getParams.setConnectionTimeout(connectionTimeout)
    httpCli.getHttpConnectionManager.getParams.setSoTimeout(socketTimeout)
    httpCli
  }
}
