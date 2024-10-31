package vc

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val getMain: HttpRequestBuilder = http("GET_/")
    .get("/")
    .check(status.not(500))

  val getDiscovery: HttpRequestBuilder = http("GET_/discovery")
    .get("/discovery")
    .check(status is 200)

  val getCourses: HttpRequestBuilder = http("GET_/courses")
    .get("/courses")
    .check(regex("""(\d+) курсов""").is("527"))
    .check(regex("""(\d+) курсов""").saveAs("coursesCount"))

  val getPopular: HttpRequestBuilder = http("GET_/popular - #{coursesCount} - #{i}")
    .get("/popular")
    .check(css(".sidebar-item__text").exists)
    .check(css(".sidebar-item__text").is("Популярное"))
    .check(regex("Популярное").exists)

  val search: HttpRequestBuilder = http("GET_/discovery - #{searchQuery}")
    .get("/discovery")
    .queryParam("q", "#{searchQuery}")

  val login: HttpRequestBuilder = http("login")
    .post("https://api.vc.ru/v3.4/auth/email/login")
    .formParam("email", "#{email}")
    .formParam("password", "#{password}")
    .check(jsonPath("$.message").is("logined"))
    .check(jsonPath("$.data.accessToken").saveAs("accessToken"))

  val me: HttpRequestBuilder = http("me")
    .get("https://api.vc.ru/v2.1/subsite/me")
    .header("JWTAuthorization", "Bearer #{accessToken}")
    .check(jsonPath("$.result.id").exists)
}
