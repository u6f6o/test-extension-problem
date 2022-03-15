package org.acme

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import java.util.concurrent.atomic.AtomicLong

class SimpleParameterResolver: ParameterResolver {

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext?): Boolean {
        return parameterContext.parameter.type == Foo::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        return Foo()
    }
}

class Foo(


    val bar: AtomicLong = AtomicLong(1L)
) {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}