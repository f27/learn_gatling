package webtours

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import webtours.steps._


object Actions {

  val openMainPage: ChainBuilder = group("Open main page") {
    exec(MainSteps.getMain)
      .exec(MainSteps.getHeader)
      .exec(MainSteps.getWelcome)
      .exitHereIfFailed
      .exec(MainSteps.getNav)
      .exitHereIfFailed
      .exec(MainSteps.getHome)
  }

  val login: ChainBuilder = group("Login") {
    exec(LoginSteps.postLogin)
      .exitHereIfFailed
      .exec(LoginSteps.getNav)
      .exec(LoginSteps.getLogin)
  }

  val openFlights: ChainBuilder = group("Open flights") {
    exec(FlightsSteps.getWelcome)
      .exec(FlightsSteps.getNav)
      .exec(FlightsSteps.getReservations)
      .exitHereIfFailed
  }

  val findOneWayTickets: ChainBuilder = group("Find one way tickets") {
    exec(FindFlightsSteps.postReservationsOneWay)
      .exitHereIfFailed
  }

  val findRoundtripTickets: ChainBuilder = group("Find roundtrip tickets") {
    exec(FindFlightsSteps.postReservationsRoundTrip)
      .exitHereIfFailed
  }

  val choseOneWayTicket: ChainBuilder = group("Chose one way ticket") {
    exec(ChoseTicketsSteps.postReservationsOneWay)
      .exitHereIfFailed
  }

  val choseRoundTripTickets: ChainBuilder = group("Chose roundtrip tickets") {
    exec(ChoseTicketsSteps.postReservationsRoundtrip)
      .exitHereIfFailed
  }

  val payForOneWayTicket: ChainBuilder = group("Pay for one way ticket") {
    exec(PaySteps.postReservationsOneWay)
      .exitHereIfFailed
  }

  val payForRoundTripTickets: ChainBuilder = group("Pay for roundtrip tickets") {
    exec(PaySteps.postReservationsRoundTrip)
      .exitHereIfFailed
  }

}
