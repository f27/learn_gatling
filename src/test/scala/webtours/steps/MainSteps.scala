package webtours.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object MainSteps {

  val getMain: HttpRequestBuilder = http("GET_/webtours/")
    .get("/webtours/")
    .check(status.is(200))

  val getHeader: HttpRequestBuilder = http("GET_/webtours/header.html")
    .get("/webtours/header.html")
    .check(status.is(200))

  val getWelcome: HttpRequestBuilder = http("GET_/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status.is(200))
    .check(headerRegex("Set-cookie", "MSO=SID&(\\d+)").exists)

  val getNav: HttpRequestBuilder = http("GET_/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status.is(200))
    .check(css("input[name=userSession]", "value").not("0AA").saveAs("userSession"))

  val getHome: HttpRequestBuilder = http("GET_/webtours/home.html")
    .get("/webtours/home.html")
    .check(status.is(200))
}
