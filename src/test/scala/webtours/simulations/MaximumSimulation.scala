package webtours.simulations

import io.gatling.core.Predef._
import webtours.httpProtocol
import webtours.scenarios.OrderTicketScenario

import scala.concurrent.duration.DurationInt

class MaximumSimulation extends Simulation {

  setUp(OrderTicketScenario().inject(
    rampUsersPerSec(5).to(1000).during(1200)
  )
  )
    .protocols(httpProtocol)
    .maxDuration(1200)

}
