package creational_pattern.factory_method

sealed class Country {
    object Canada: Country()
    object Spain: Country()
    data class USA(val someProperty: String): Country()
    class Greece(val someProperty: String): Country()
}

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when(country) {
            Country.Canada -> Currency("CAD")
            Country.Spain -> Currency("EUR")
            is Country.Greece -> Currency("EUR")
            is Country.USA -> Currency("USD")
        }
}

fun main() {
    val currency = CurrencyFactory.currencyForCountry(Country.Canada).code
    println(currency)
}