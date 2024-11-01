package webtours

import io.gatling.core.Predef._
import webtours.scenarios.OrderTicketScenario

class Debug extends Simulation {

  setUp(
    OrderTicketScenario().inject(atOnceUsers(1))
  )
    .protocols(httpProtocol)

}
