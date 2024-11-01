package webtours.steps

object PaySteps {

  import io.gatling.core.Predef._
  import io.gatling.http.Predef._
  import io.gatling.http.request.builder.HttpRequestBuilder

  val postReservationsRoundTrip: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "#{firstName}")
    .formParam("lastName", "#{lastName}")
    .formParam("address1", "#{address1}")
    .formParam("address2", "#{address2}")
    .formParam("pass1", "#{pass1}")
    .formParam("creditCard", "#{creditCard}")
    .formParam("expDate", "#{expDate}")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "#{returnFlight}")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "73")
    .formParam("buyFlights.y", "15")
    .formParam(".cgifields", "saveCC")
    .check(status.is(200))
    .check(css("small b").is("Thank you for booking through Web Tours."))

  val postReservationsOneWay: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "#{firstName}")
    .formParam("lastName", "#{lastName}")
    .formParam("address1", "#{address1}")
    .formParam("address2", "#{address2}")
    .formParam("pass1", "#{pass1}")
    .formParam("creditCard", "#{creditCard}")
    .formParam("expDate", "#{expDate}")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "73")
    .formParam("buyFlights.y", "15")
    .formParam(".cgifields", "saveCC")
    .check(status.is(200))
    .check(css("small b").is("Thank you for booking through Web Tours."))

}
