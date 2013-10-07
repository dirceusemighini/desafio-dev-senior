package controllers

import play.api.libs.json.Json
import play.api.mvc._
import br.com.semighini.component.RouteTotalsCalc
import generated.Address
import br.com.semighini.model.{RouteTotalsResult, RouteStopPointsRouteType}


import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.joda.time.Period
import com.wordnik.swagger.annotations._
import javax.ws.rs.{FormParam, PathParam, Produces}
import com.wordnik.swagger.core.util.RestResourceUtil
import br.com.semighini.model.RouteStopPointsRouteType
import br.com.semighini.enums.RouteType
import br.com.semighini.exception.WebServiceException

@Produces(Array("application/json"))
@Api(value = "/routeDetails", listingPath = "/api-docs.json/routeDetails", description = "Operacoes sobre detalhes de rotas")
object RouteDetailsCalcApi extends BaseApi  with RestResourceUtil{

  implicit lazy val addressListRouteType = br.com.semighini.mapper.addressListRouteTypeMapper
  implicit lazy val routeTotalResultWriter =  br.com.semighini.mapper.routeTotalResultWriter

  @ApiOperation(value = "Lista detalhes das rotas", notes = "Retorna os detalhes de uma rota",
    responseClass = "br.com.semighini.model.RouteTotalsResult", httpMethod = "POST")
  @ApiErrors(Array(
    new ApiError(code = 400, reason = "Endereco invalido."),
    new ApiError(code = 400, reason = "Apenas um endereco na lista, sao necessarios mais de um endereco na lita para executar este metodo"),
    new ApiError(code = 400, reason = "Tipo de rota invalido, os valores aceitos sao 0 ou 23"),
    new ApiError(code = 404, reason = "Endereco nao encontrado"),
    new ApiError(code = 500, reason = "Erro interno no servidor, tente mais tarde")
  ))
  @ApiParamsImplicit(Array(
    new ApiParamImplicit(name = "AddressListRouteType", dataType = "br.com.semighini.model.RouteStopPointsRouteType",
      paramType = "body", value = "Lista de paradas e tipo de rota", required = true)))
  def routeTotalCostsAndTime = Action(parse.json) {
    implicit request =>
      request.body.validate[RouteStopPointsRouteType].map {
        addressListRouteType =>
          try{
            val routeTotals = RouteTotalsCalc.getRouteTotalCostsAndTime(addressListRouteType.addresses, RouteType(addressListRouteType.routeType))

            Ok(Json.toJson(routeTotals)).as(JSON)
          } catch {
            case e:WebServiceException => jsonResponse(e.getMessage,BAD_REQUEST)
            case e: Exception =>                                                jsonResponse(e.getMessage,INTERNAL_SERVER_ERROR
            )
          }
      }.recoverTotal {
        e =>
          jsonResponse(JsError.toFlatJson(e),BAD_REQUEST)
      }
  }
}