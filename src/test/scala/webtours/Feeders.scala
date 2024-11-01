package webtours

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder

object Feeders {

  val users: BatchableFeederBuilder[String] = csv("feeders/users.csv").circular

}
