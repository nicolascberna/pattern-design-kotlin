package creational_pattern.factory_method

import kotlin.random.Random

object PlanetFactoryMethod {

    fun getPlanet(planet: Int): Planet {
        return when (planet) {
            1 -> Planet("Mercury")
            2 -> Planet("Venus")
            3 -> Planet("Earth")
            4 -> Planet("Mars")
            5 -> Planet("Jupiter")
            6 -> Planet("Saturn")
            7 -> Planet("Uranus")
            8 -> Planet("Neptune")
            9 -> Planet("Pluto")
            else -> throw IllegalArgumentException("Invalid planet value: $planet")
        }
    }
}

data class Planet(val name: String)

fun main() {
    val random = Random.nextInt(1,9)
    val planetFactoryMethod = PlanetFactoryMethod.getPlanet(random)
    println(planetFactoryMethod.name)
}