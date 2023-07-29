package creational_pattern.singleton


object NetworkDriver {

    init {
        println("Initializing: $this")
    }

    fun log(): NetworkDriver = apply { println("Network driver: $this") }
}

class SingletonTest {

    fun testSingleton() {
        println("Start")
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()

        if (networkDriver1 == NetworkDriver && networkDriver2 == NetworkDriver) println("singleton works fine")
    }
}

fun main() {
    SingletonTest().testSingleton()
}