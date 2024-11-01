package webtours.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object FlightsSteps {

  val getWelcome: HttpRequestBuilder = http("GET_/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status.is(200))

  val getNav: HttpRequestBuilder = http("GET_/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status.is(200))

  val getReservations: HttpRequestBuilder = http("GET_/cgi-bin/reservations.pl")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(status.is(200))
    .check(css("select[name=depart] option","value").findRandom.saveAs("depart"))
    .check(css("select[name=arrive] option:not([value=#{depart}])","value").findRandom.saveAs("arrive"))
    .check(css("input[name=departDate]", "value").saveAs("departDate"))
    .check(css("input[name=returnDate]", "value").saveAs("returnDate"))

}
