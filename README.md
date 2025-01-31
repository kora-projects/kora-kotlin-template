[![GitHub Action](https://github.com/kora-projects/kora-kotlin-template/workflows/Build%20Master/badge.svg)](https://github.com/kora-projects/kora-kotlin-template/actions?query=workflow%3A%22Build%20Master%22++)

# Шаблон приложения Kora Kotlin

Шаблон для быстрого старта нового проекта на Kotlin и Kora.

## Build

```shell
./gradlew classes
```

Собрать артефакт:

```shell
./gradlew distTar
```

### Image

Собрать образ приложения:
```shell
docker build -t kora-kotlin-template .
```

## Run

Перед запуском локально требуется запустить базу Postgres и накатить миграции.

Запустить локально:
```shell
./gradlew run
```

## Run Docker-Compose

Требуется сначала собрать артефакт.

Запустить как docker-compose:
```shell
docker-compose up
```

## Test

Тесты используют [Testcontainers](https://java.testcontainers.org/), требуется [Docker](https://docs.docker.com/engine/install/) окружение для запуска тестов или аналогичные контейнерные окружения ([colima](https://github.com/abiosoft/colima) / итп)

Протестировать локально:
```shell
./gradlew test
```
