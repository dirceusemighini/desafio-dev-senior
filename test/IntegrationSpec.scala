import controllers.RouteDetailsCalcApi
import generated.{City, Address}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._
                          import concurrent.ExecutionContext.Implicits.global
/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {


  "Application" should {

    "work from within two addresses" in new WithBrowser {
        val json = Json.parse("{\n  \"routeType\": 23,\n  \"addresses\": [\n    {\n      \"zip\": \"05502010\",\n      \"street\": \"Rua Engenheiro Bianor\",\n      \"houseNumber\": \"154\",\n      \"district\": \"Butanta\",\n      \"city\": {\n        \"name\": \"Sao Paulo\",\n        \"state\": \"SP\"\n      }\n    },\n {\n      \"zip\": \"05351005\",\n      \"street\": \"Rua Dr Jose Benedito Viana de Moraes\",\n      \"houseNumber\": \"265\",\n      \"district\": \"Rio Pequeno\",\n      \"city\": {\n        \"name\": \"Sao Paulo\",\n        \"state\": \"SP\"\n      }\n    }\n  ]\n}")

       val request =  FakeRequest().withJsonBody(json)
       val result = RouteDetailsCalcApi.routeTotalCostsAndTime()(request)
      result.map(f => f.header.status must equalTo(OK))

    }

    "fail for one address" in new WithBrowser {
      val json = Json.parse("{\n  \"routeType\": 23,\n  \"addresses\": [\n    {\n      \"zip\": \"05502010\",\n      \"street\": \"Rua Engenheiro Bianor\",\n      \"houseNumber\": \"154\",\n      \"district\": \"Butanta\",\n      \"city\": {\n        \"name\": \"Sao Paulo\",\n        \"state\": \"SP\"\n      }\n    }]\n}")

      val request =  FakeRequest().withJsonBody(json)
      val result = RouteDetailsCalcApi.routeTotalCostsAndTime()(request)
      result.map(f => f.header.status must equalTo(BAD_REQUEST))

    }
  }
}
