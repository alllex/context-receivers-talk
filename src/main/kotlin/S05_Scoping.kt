@file:Suppress("unused")

object Unsafe

class FineGrainedApi {

    fun simple() {}

    context(Unsafe)
    fun complex() {}
}

fun main() {
    val api = FineGrainedApi()

    api.simple()

    with(Unsafe) {
        api.complex()
    }
}

