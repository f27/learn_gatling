import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

package object vc {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("https://vc.ru")
    .header("Accept-Encoding", "gzip, deflate, br, zstd")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .disableFollowRedirect

}
