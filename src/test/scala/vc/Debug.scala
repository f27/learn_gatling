package vc

import io.gatling.core.Predef._

class Debug extends Simulation {

//  setUp(
//    CommonScenario().inject(atOnceUsers(1))
//      .protocols(httpProtocol)
//  )
//    .assertions(global.responseTime.max.lt(500))
//    .assertions(details("login" / "login").responseTime.max.lt(500))

  setUp(
    CommonScenario().inject(
//      incrementUsersPerSec(5)
//        .times(2)
//        .eachLevelLasting(5)
//        .separatedByRampsLasting(2)
//        .startingFrom(0)
      // разгон
      rampUsersPerSec(5) to 5 during 5,
      // стабильный участок
      constantUsersPerSec(5) during 6
    )
  )
    .protocols(httpProtocol)
    .maxDuration(10000)
}
