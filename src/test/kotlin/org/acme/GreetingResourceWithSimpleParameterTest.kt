package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@QuarkusTest
@ExtendWith(SimpleParameterResolver::class)
class GreetingResourceWithSimpleParameterTest {

    @Test
    fun testHelloEndpoint(foo: Foo) {
        System.err.println(foo)
        RestAssured.given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`("Hello RESTEasy"))
    }

}