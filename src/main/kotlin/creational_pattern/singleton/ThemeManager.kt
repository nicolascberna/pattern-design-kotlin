package creational_pattern.singleton

class ThemeManager private constructor() {
    //Setting the constructor as private prevents the class from being instantiated directly
    enum class Theme {
        LIGHT,
        DARK
    }

    private var currentTheme: Theme = Theme.LIGHT

    companion object {
        @Volatile
        private  var instance: ThemeManager? = null

        fun getInstance(): ThemeManager {
            return  instance ?: synchronized(this) {
                instance ?: ThemeManager().also { instance = it }
            }
        }
    }

    fun setTheme(theme: Theme) {
        currentTheme = theme
    }

    fun getCurrentTheme() = currentTheme

}

class ThemeManagerTest {

    fun testThemeManager() {
        val themeManager1 = ThemeManager.getInstance()
        val themeManager2 = ThemeManager.getInstance()

        println(themeManager1)
        println(themeManager2)
        if (themeManager1 == themeManager2) println("singleton works fine") else println("something went wrong")
    }
}

fun main() {
    ThemeManagerTest().testThemeManager()
}