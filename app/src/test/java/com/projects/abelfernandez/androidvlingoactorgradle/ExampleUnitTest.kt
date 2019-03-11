package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Actor
import io.vlingo.actors.Logger
import io.vlingo.actors.ProxyGenerator
import io.vlingo.actors.Stoppable
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_proxyGenerator() {
        ProxyGenerator.forMain(false, WorkLogger).use { generator ->
            val result = generator.generateFor("com.projects.abelfernandez.androidvlingoactorgradle.IPrueba")
            print(result)
            assertNotNull(result)
        }
    }

    object WorkLogger : Logger {

        private
        var enabled = true

        override fun name(): String =
            "actor-proxy-generator-work"

        override fun close() {
            enabled = false
        }

        override fun isEnabled(): Boolean =
            enabled

        override fun log(message: String) {
            println(message)
        }

        override fun log(message: String, throwable: Throwable) {
            log(message)
            throwable.printStackTrace(System.out)
        }
    }




}
