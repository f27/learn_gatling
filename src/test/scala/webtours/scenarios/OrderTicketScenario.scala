package webtours.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import webtours.{Actions, Feeders}

object OrderTicketScenario {
  def apply(): ScenarioBuilder = new OrderTicketScenario().scn
}

class OrderTicketScenario {

  val scn: ScenarioBuilder = scenario("Order ticket")
    .feed(Feeders.users)
    .exec(Actions.openMainPage)
    .exec(Actions.login)
    .exec(Actions.openFlights)
    .randomSwitch(
      50.0 -> exec(Actions.findOneWayTickets).exec(Actions.choseOneWayTicket).exec(Actions.payForOneWayTicket),
      50.0 -> exec(Actions.findRoundtripTickets).exec(Actions.choseRoundTripTickets).exec(Actions.payForRoundTripTickets)
    )
    .exec(Actions.openMainPage)
}
