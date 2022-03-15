package org.acme

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.extension.*

class WiremockedRemoteApis: ParameterResolver, BeforeAllCallback, AfterAllCallback {

    val wireMockServer = WireMockServer(WireMockConfiguration.options().port(8082))

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext?): Boolean {
        return parameterContext.parameter.type == WireMockServer::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext?): Any {
        return wireMockServer
    }


    override fun beforeAll(ctx: ExtensionContext) {
        wireMockServer.start()
    }

    override fun afterAll(context: ExtensionContext) {
        wireMockServer.stop()
    }
}