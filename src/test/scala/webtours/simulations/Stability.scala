package webtours.simulations

import io.gatling.core.Predef._
import webtours.httpProtocol
import webtours.scenarios.OrderTicketScenario

import scala.concurrent.duration.DurationInt

class Stability extends Simulation {

  setUp(OrderTicketScenario().inject(
    rampUsersPerSec(0) to (3.2 * 0.8) during 10.minutes,
    constantUsersPerSec(3.2 * 0.8) during 50.minutes
  )
  )
    .protocols(httpProtocol)
    .maxDuration(1.hour)
    .assertions(global.responseTime.max.lt(5000))
    .assertions(global.failedRequests.percent.lt(3))

}
