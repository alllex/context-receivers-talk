
// Where can we use the contexts and how do they work under the hood?

data class ChainContext(val chainValue: String)

fun main() {
    with(ChainContext("hello")) {
        topLevel1()
    }
}

context(ChainContext)
fun topLevel1() {
    repeat(2) {
        topLevel2()
    }
}

context(ChainContext)
fun topLevel2() {
    ChainElement().run()
}

context(ChainContext)
class ChainElement {
    fun run() {
        // Let's also peek under the hood!
        ChainLogic().run()
    }
}

class ChainLogic {
    context(ChainContext)
    fun run() {
        println(ChainProp().member)
    }
}

class ChainProp {
    context(ChainContext)
    val member: String
        get() = "$chainValue context!"
}

//region fail-fast example

fun topLevel4() {
//    failFast()
}

context(ChainContext)
fun failFast() {
    println(chainValue)
}

//endregion