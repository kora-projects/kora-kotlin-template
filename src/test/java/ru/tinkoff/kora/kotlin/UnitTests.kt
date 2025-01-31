package ru.tinkoff.kora.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.tinkoff.kora.test.extension.junit5.KoraAppTest
import ru.tinkoff.kora.test.extension.junit5.TestComponent

@KoraAppTest(Application::class)
class UnitTests(
    @TestComponent val someService: SomeService
) {

    @Test
    fun getSomeSuccess() {
        assertEquals("1", someService.getSome())
    }
}
