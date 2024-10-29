package vc

import io.gatling.core.Predef._

class Debug extends Simulation {

  setUp(
    CommonScenario().inject(atOnceUsers(1))
      .protocols(httpProtocol)
  )
}
