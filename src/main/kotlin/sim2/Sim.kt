package sim2

import kotlin.random.Random

data class Hero(
    var happiness: Int = 100
)

data class LuckConfig(
    val movies: Double = 0.9,
    val bunny: Double = 0.999,
    val movieFactor: Int = 5
)

fun main() {
    val hero = Hero()
    val random = Random(42)
    val luck = LuckConfig()
    accurateLifeSimulator(hero, random, luck)
}

fun accurateLifeSimulator(hero: Hero, random: Random, luck: LuckConfig) {
    repeat(365) {
        anotherDay(hero, random, luck)
        hero.happiness -= 1
    }
}

fun anotherDay(hero: Hero, random: Random, luck: LuckConfig) {
    // coffee, work, lunch, work, ...

    if (random.nextDouble() > luck.movies) {
        watchMovies(hero, random, luck)
    } else {
        goRunning(hero, random, luck)
    }
}

fun watchMovies(hero: Hero, random: Random, luck: LuckConfig) {
    hero.happiness += random.nextInt(-luck.movieFactor, luck.movieFactor)
}

fun goRunning(hero: Hero, random: Random, luck: LuckConfig) {
    if (random.nextDouble() > luck.bunny) { // saw a bunny or squirrel
        hero.happiness += 10000
    } else {
        hero.happiness += 20
    }
}
