package br.com.semighini.logging

;

import org.slf4j.{Logger => SLF4JLogger, LoggerFactory}

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
final class Logger(private val logger: SLF4JLogger) {
  @inline def name = logger.getName

  @inline def isErrorEnabled = logger.isErrorEnabled

  @inline def isWarnEnabled = logger.isWarnEnabled

  @inline def isInfoEnabled = logger.isInfoEnabled

  @inline def isDebugEnabled = logger.isDebugEnabled

  @inline def isTraceEnabled = logger.isTraceEnabled

  @inline def error(message: String): Unit = if (isErrorEnabled) logger.error(message)

  @inline def error(message: String, params: Any*): Unit = if (isErrorEnabled) logger.error(message, params)

  @inline def error(message: String, t: Throwable): Unit = if (isErrorEnabled) logger.error(message, t)

  @inline def warn(message: String): Unit = if (isWarnEnabled) logger.warn(message)

  @inline def warn(message: String, params: Any*): Unit = if (isWarnEnabled) logger.warn(message, params)

  @inline def warn(message: String, t: Throwable): Unit = if (isWarnEnabled) logger.warn(message, t)

  @inline def info(message: String): Unit = if (isInfoEnabled) logger.info(message)

  @inline def info(message: String, params: Any*): Unit = if (isInfoEnabled) logger.info(message, params)

  @inline def info(message: String, t: Throwable): Unit = if (isInfoEnabled) logger.info(message, t)

  @inline def debug(message: String): Unit = if (isDebugEnabled) logger.debug(message)

  @inline def debug(message: String, params: Any*): Unit = if (isDebugEnabled) logger.debug(message, params)

  @inline def debug(message: String, t: Throwable): Unit = if (isDebugEnabled) logger.debug(message, t)

  @inline def trace(message: String): Unit = if (isTraceEnabled) logger.trace(message)

  @inline def trace(message: String, params: Any*): Unit = if (isTraceEnabled) logger.trace(message, params)

  @inline def trace(message: String, t: Throwable): Unit = if (isTraceEnabled) logger.trace(message, t)

}

object Logger {
  private lazy val rootLoggerName = SLF4JLogger.ROOT_LOGGER_NAME

  def apply(logger: SLF4JLogger): Logger = new Logger(logger)

  def apply(name: String): Logger = apply(LoggerFactory.getLogger(name))

  def apply(clazz: Class[_]): Logger = apply(clazz.getName)

  def rootLooger: Logger = apply(rootLoggerName)
}
