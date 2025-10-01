package ru.tinkoff.kora.example

import ru.tinkoff.kora.common.Component
import ru.tinkoff.kora.common.annotation.Root

//TODO remove this class
@Root
@Component
class SomeService {

    fun getSome(): String = "1"
}