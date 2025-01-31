package ru.tinkoff.kora.kotlin

import ru.tinkoff.kora.common.Component
import ru.tinkoff.kora.common.annotation.Root

@Root
@Component
class SomeService {

    fun getSome(): String = "1"
}