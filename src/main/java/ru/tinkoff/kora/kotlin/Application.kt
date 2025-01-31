package ru.tinkoff.kora.kotlin

import ru.tinkoff.kora.application.graph.KoraApplication
import ru.tinkoff.kora.common.KoraApp
import ru.tinkoff.kora.config.hocon.HoconConfigModule
import ru.tinkoff.kora.http.server.undertow.UndertowModule
import ru.tinkoff.kora.logging.logback.LogbackModule
import ru.tinkoff.kora.micrometer.module.MetricsModule


@KoraApp
interface Application : HoconConfigModule, MetricsModule, UndertowModule, LogbackModule

fun main() {
    KoraApplication.run { ApplicationGraph.graph() }
}
