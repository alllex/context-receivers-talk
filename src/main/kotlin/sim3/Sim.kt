package sim3

import kotlin.random.Random

data class Hero(
    var happiness: Int = 100
)

data class LuckConfig(
    val movies: Double = 0.9,
    val bunny: Double = 0.999,
    val movieFactor: Int = 5
)

class Logger {
    fun log(msg: String) = println(msg)
}

fun main() {
    val hero = Hero()
    val random = Random(42)
    val luck = LuckConfig()

    val gameContext = GameContext(luck, random)
    val loggingContext = LoggingContext(Logger())

    with(gameContext) {
        with(loggingContext) {
            accurateLifeSimulator(hero)
        }
    }
}

data class GameContext(
    val luck: LuckConfig,
    val random: Random,
)

data class LoggingContext(
    val logger: Logger
)

context(GameContext, LoggingContext)
fun accurateLifeSimulator(hero: Hero) {
    repeat(365) {
        anotherDay(hero)
        hero.happiness -= 1
    }
}

context(GameContext, LoggingContext)
fun anotherDay(hero: Hero) {
    if (random.nextDouble() > luck.movies) {
        watchMovies(hero)
    } else {
        goRunning(hero)
    }
}

context(GameContext)
fun watchMovies(hero: Hero) {
    hero.happiness += random.nextInt(-luck.movieFactor, luck.movieFactor)
}

context(GameContext, LoggingContext)
fun goRunning(hero: Hero) {
    if (random.nextDouble() > luck.bunny) { // saw a bunny or squirrel
        logger.log("Got a bunny!")
        hero.happiness += 10000
    } else {
        hero.happiness += 20
    }
}
