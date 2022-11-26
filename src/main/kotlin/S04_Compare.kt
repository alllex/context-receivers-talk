
sealed class Temperature {
    abstract fun toCelsiusValue(): Double

    data class Celsius(val value: Double) : Temperature() {
        override fun toCelsiusValue() = value
    }

    data class Fahrenheit(val value: Double) : Temperature() {
        override fun toCelsiusValue() = (value - 32) * 5 / 9
    }
}

context(Comparator<T>)
infix operator fun <T> T.compareTo(other: T) = compare(this, other)

object TemperatureComparator : Comparator<Temperature> {
    override fun compare(o1: Temperature, o2: Temperature): Int =
        o1.toCelsiusValue().compareTo(o2.toCelsiusValue())
}

fun main() {
    val t1 = Temperature.Celsius(0.0)
    val t2 = Temperature.Fahrenheit(32.0)
    val colder = t1.toCelsiusValue() < t2.toCelsiusValue()
    println("Is $t1 colder than $t2? $colder")

    with(TemperatureComparator) {
        val warmer = t1 > t2
        println("Is $t1 warmer than $t2? $warmer")
    }
}