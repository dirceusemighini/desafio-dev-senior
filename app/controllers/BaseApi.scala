package controllers

import java.io.StringWriter
import play.api.mvc.{Controller, ResponseHeader, SimpleResult}
import com.wordnik.swagger.core.util.JsonUtil

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 07/10/13
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */

object BaseApiController {
  val mapper = JsonUtil.getJsonMapper
}

trait BaseApi extends Controller {
protected def jsonResponse(data: Object) = {
val w = new StringWriter()

BaseApiController.mapper.writeValue(w, data)

val jsonValue: String = w.toString()
new SimpleResult(header = ResponseHeader(200), body = play.api.libs.iteratee.Enumerator(jsonValue.getBytes())).as("application/json")
.withHeaders(
("Access-Control-Allow-Origin", "*"),
("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"),
("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization"))
}

protected def jsonResponse(data: Object, code: Int) = {
val w = new StringWriter()

BaseApiController.mapper.writeValue(w, data)

val jsonValue: String = w.toString()
new SimpleResult(header = ResponseHeader(code), body = play.api.libs.iteratee.Enumerator(jsonValue.getBytes())).as("application/json")
.withHeaders(
("Access-Control-Allow-Origin", "*"),
("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"),
("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization"))
}
}