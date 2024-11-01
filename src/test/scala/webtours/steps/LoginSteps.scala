package webtours.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object LoginSteps {

  val postLogin: HttpRequestBuilder = http("POST_/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "#{username}")
    .formParam("password", "#{password}")
    .formParam("login.x", "55")
    .formParam("login.y", "18")
    .formParam("JSFormSubmit", "off")
    .check(status.is(200))
    .check(headerRegex("Set-cookie", "username&([^&]*)&").is("#{username}"))

  val getNav: HttpRequestBuilder = http("GET_/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "home")
    .check(status.is(200))

  val getLogin: HttpRequestBuilder = http("GET_/cgi-bin/login.pl")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status.is(200))
    .check(css("blockquote b").is("#{username}"))

}
