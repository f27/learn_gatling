package vc

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val loginGroup: ChainBuilder = group("login"){
    exec(Actions.login)
      .exec(Actions.me)
  }

  val scn: ScenarioBuilder = scenario("Otus load 29.10.2024")
    .feed(Feeders.myFeed)
    .feed(Feeders.users)
    .exec(Actions.getMain)
    .pause(1000.milliseconds)
    .randomSwitch(
      20.0 -> exec(Actions.getDiscovery),
      80.0 -> exec(Actions.getCourses)
    )
    .repeat(3, "i")(
      exec(Actions.getPopular)
    )
    .exec(Actions.search)
    .exec {
      session => session.set("TEST", "PARAM")
    }
    .exec {
      session => println(session)
        session
    }
    .exec(loginGroup)

}
