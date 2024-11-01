package webtours

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import webtours.steps.{ChoseTicketsSteps, FindFlightsSteps, FlightsSteps, LoginSteps, MainSteps, PaySteps}

import scala.util.Random


object Actions {

  val openMainPage: ChainBuilder = group("Open main page") {
    exec(MainSteps.getMain)
      .exec(MainSteps.getHeader)
      .exec(MainSteps.getWelcome)
      .exec(MainSteps.getNav)
      .exec(MainSteps.getHome)
  }

  val login: ChainBuilder = group("Login") {
    exec(LoginSteps.postLogin)
      .exec(LoginSteps.getNav)
      .exec(LoginSteps.getLogin)
  }

  val openFlights: ChainBuilder = group("Open flights") {
    exec(FlightsSteps.getWelcome)
      .exec(FlightsSteps.getNav)
      .exec(FlightsSteps.getReservations)
  }

  val findOneWayTickets: ChainBuilder = group("Find one way tickets") {
    exec(FindFlightsSteps.postReservationsOneWay)
  }

  val findRoundtripTickets: ChainBuilder = group("Find roundtrip tickets") {
    exec(FindFlightsSteps.postReservationsRoundTrip)
  }

  val choseOneWayTicket: ChainBuilder = group("Chose one way ticket") {
    exec(ChoseTicketsSteps.postReservationsOneWay)
  }

  val choseRoundTripTickets: ChainBuilder = group("Chose roundtrip tickets") {
    exec(ChoseTicketsSteps.postReservationsRoundtrip)
  }

  val payForOneWayTicket: ChainBuilder = group("Pay for one way ticket") {
    exec(PaySteps.postReservationsOneWay)
  }

  val payForRoundTripTickets: ChainBuilder = group("Pay for roundtrip tickets") {
    exec(PaySteps.postReservationsRoundTrip)
  }

}
