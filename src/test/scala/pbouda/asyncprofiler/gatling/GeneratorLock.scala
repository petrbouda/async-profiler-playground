package pbouda.asyncprofiler.gatling

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef.{global, scenario, _}
import io.gatling.http.Predef.{http, status, _}

import scala.concurrent.duration.FiniteDuration

class GeneratorLock extends Simulation {

  private val httpConf = http.baseUrl("http://localhost:8080")

  private val invocation = scenario("Generate scenario")
    .exec(http("Generate Call")
      .get("/generate-lock")
      .check(status.is(200))
    )

  setUp(invocation.inject(
    rampUsersPerSec(0) to 1000 during FiniteDuration(60, TimeUnit.SECONDS))
    .protocols(httpConf))
    .assertions(global.successfulRequests.percent.gte(100))
}