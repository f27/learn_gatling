package webtours.simulations

import io.gatling.core.Predef._
import webtours.httpProtocol
import webtours.scenarios.OrderTicketScenario

import scala.concurrent.duration.DurationInt

class MaxPerformance extends Simulation {

  setUp(OrderTicketScenario().inject(
    incrementUsersPerSec(0.32)
      .times(10)
      .eachLevelLasting(90.seconds)
      .separatedByRampsLasting(30.seconds)
      .startingFrom(0)
  )
  )
    .protocols(httpProtocol)
    .maxDuration(1.hour)
    .assertions(global.responseTime.max.lt(5000))
    .assertions(global.failedRequests.percent.lt(3))

}
