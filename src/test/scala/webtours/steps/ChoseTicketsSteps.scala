package webtours.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ChoseTicketsSteps {

  val postReservationsOneWay: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "49")
    .formParam("reserveFlights.y", "9")
    .check(status.is(200))
    .check(css("input[name=firstName]", "value").transform(v => v.trim).saveAs("firstName"))
    .check(css("input[name=lastName]", "value").transform(v => v.trim).saveAs("lastName"))
    .check(css("input[name=address1]", "value").transform(v => v.trim).saveAs("address1"))
    .check(css("input[name=address2]", "value").transform(v => v.trim).saveAs("address2"))
    .check(css("input[name=pass1]", "value").transform(v => v.trim).saveAs("pass1"))

  val postReservationsRoundtrip: HttpRequestBuilder = http("POST_/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("returnFlight", "#{returnFlight}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "49")
    .formParam("reserveFlights.y", "9")
    .check(status.is(200))
    .check(css("input[name=firstName]", "value").transform(v => v.trim).saveAs("firstName"))
    .check(css("input[name=lastName]", "value").transform(v => v.trim).saveAs("lastName"))
    .check(css("input[name=address1]", "value").transform(v => v.trim).saveAs("address1"))
    .check(css("input[name=address2]", "value").transform(v => v.trim).saveAs("address2"))
    .check(css("input[name=pass1]", "value").transform(v => v.trim).saveAs("pass1"))

}
