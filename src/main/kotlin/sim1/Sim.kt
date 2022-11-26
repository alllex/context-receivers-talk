package sim1

import kotlin.random.Random

data class Hero(
    var happiness: Int = 100
)

fun main() {
    val hero = Hero()
    accurateLifeSimulator(hero)
}

fun accurateLifeSimulator(hero: Hero) {
    repeat(365) {
        anotherDay(hero)
        hero.happiness -= 1
    }
}

fun anotherDay(hero: Hero) {
    // coffee, work, lunch, work...

    if (Random.nextDouble() > 0.9) {
        watchMovies(hero)
    } else {
        goRunning(hero)
    }
}

fun watchMovies(hero: Hero) {
    hero.happiness += Random.nextInt(-5, 5)
}

fun goRunning(hero: Hero) {
    if (Random.nextDouble() > 0.999) { // saw a bunny or squirrel
        hero.happiness += 10000
    } else {
        hero.happiness += 5
    }
}
