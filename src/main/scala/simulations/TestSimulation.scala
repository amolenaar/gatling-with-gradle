package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TestSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8094/gatling-with-gradle")
    .acceptHeader("application/json")

  val testScn = scenario("test")
    .repeat(10) {
        exec(http("hello world").get("/"))
    }

  setUp(testScn.inject(atOnceUsers(1)).protocols(httpProtocol))
}