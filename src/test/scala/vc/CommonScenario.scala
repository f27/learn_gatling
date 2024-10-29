package vc

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = scenario("Otus load 29.10.2024")
    .exec(Actions.getMain)
    .pause(1000.milliseconds)
    .randomSwitch(
      20.0 -> exec(Actions.getDiscovery),
      80.0 -> exec(Actions.getCourses)
    )
    .repeat(3, "i")(
      exec(Actions.getPopular)
    )

}
