package ru.tinkoff.kora.kotlin

import org.slf4j.LoggerFactory
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.images.builder.ImageFromDockerfile
import org.testcontainers.utility.DockerImageName
import java.net.URI
import java.nio.file.Paths
import java.time.Duration
import java.util.concurrent.Future

class AppContainer : GenericContainer<AppContainer> {

    constructor(dockerImageName: DockerImageName) : super(dockerImageName)

    constructor(image: Future<String>) : super(image)

    companion object {

        fun build(): AppContainer {
            val appImage = System.getenv("IMAGE_KORA_KOTLIN")
            return if (appImage != null && appImage.isNotBlank())
                AppContainer(DockerImageName.parse(appImage))
            else
                AppContainer(
                    ImageFromDockerfile("kora-kotlin", true)
                        .withDockerfile(Paths.get("Dockerfile").toAbsolutePath())
                )
        }
    }

    override fun configure() {
        super.configure()
        withExposedPorts(8085)
        withStartupTimeout(Duration.ofSeconds(120))
        withLogConsumer(Slf4jLogConsumer(LoggerFactory.getLogger(AppContainer::class.java)))
        waitingFor(Wait.forHttp("/system/readiness").forPort(8085).forStatusCode(200))
    }

    val privatePort: Int get() = getMappedPort(8085)

    val privateUri: URI get() = URI.create("http://$host:$privatePort")
}

