
fun main() {
    with(Magic) {
        magicTrick()
    }
}

object Magic

fun magicTrick() {
    showHat()
}

fun showHat() {
    println("The hat is EMPTY!")
}
















































context(Magic)
fun showHat() {
    println("There is a FLUFFY BUNNY!")
}
