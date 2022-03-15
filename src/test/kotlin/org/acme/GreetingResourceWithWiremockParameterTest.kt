package org.acme

import com.github.tomakehurst.wiremock.WireMockServer
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@QuarkusTest
@ExtendWith(WiremockedRemoteApis::class)
class GreetingResourceWithWiremockParameterTest {

    @Test
    fun testHelloEndpoint(wireMockServer: WireMockServer) {
        given()
          .`when`().get("/hello")
          .then()
             .statusCode(200)
             .body(`is`("Hello RESTEasy"))
    }

}