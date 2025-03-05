package ru.tinkoff.kora.kotlin

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.testcontainers.containers.Network.SHARED
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

@Disabled("example of black box testing against default /metric endpoint")
class BlackBoxTests {

    companion object {

        private val container: AppContainer = AppContainer.build().withNetwork(SHARED)

        private val httpClient: HttpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(1))
            .build()

        @JvmStatic
        @BeforeAll
        fun setup() = container.start()

        @JvmStatic
        @AfterAll
        fun cleanup() = container.stop()
    }

    @Test
    fun serviceReady() {
        val request = HttpRequest.newBuilder()
            .GET()
            .uri(container.privateUri.resolve("/metrics"))
            .timeout(Duration.ofSeconds(1))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.discarding())
        assertEquals(200, response.statusCode())
    }
}
