package webtours.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object FindFlightsSteps {

  val postReservationsOneWay: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{depart}")
    .formParam("departDate", "#{departDate}")
    .formParam("arrive", "#{arrive}")
    .formParam("returnDate", "#{returnDate}")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "63")
    .formParam("findFlights.y", "4")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status.is(200))
    .check(css("input[name=outboundFlight]", "value").findRandom.saveAs("outboundFlight"))

  val postReservationsRoundTrip: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{depart}")
    .formParam("departDate", "#{departDate}")
    .formParam("arrive", "#{arrive}")
    .formParam("returnDate", "#{returnDate}")
    .formParam("numPassengers", "1")
    .formParam("roundtrip", "on")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "63")
    .formParam("findFlights.y", "4")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status.is(200))
    .check(css("input[name=outboundFlight]", "value").findRandom.saveAs("outboundFlight"))
    .check(css("input[name=returnFlight]", "value").findRandom.saveAs("returnFlight"))
}
