/*
https://play.kotlinlang.org/byExample/03_special_classes/04_Object
 */

import java.util.Random

class LuckDispatcher { // 1
    fun getNumber() { // 2
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) { // 1

    val dayRates =
        object { // 2
            var standard: Int = 30 * standardDays
            var festivity: Int = 50 * festivityDays
            var special: Int = 100 * specialDays
        }

    val total = dayRates.standard + dayRates.festivity + dayRates.special // 3

    print("\nTotal price: $$total") // 4
}

object DoAuth { // 1
    fun takeParams(username: String, password: String) { // 2
        println("\ninput Auth parameters = $username:$password")
    }
}

class BigBen { // 1
    companion object Bonger { // 2
        fun getBongs(nTimes: Int) { // 3
            for (i in 1..nTimes) {
                print("\n $i/$nTimes - BONG ")
            }
        }
    }
}

fun main() {
    val d1 = LuckDispatcher() // 3
    val d2 = LuckDispatcher()

    d1.getNumber() // 4
    d2.getNumber()

    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty") // 3

    BigBen.getBongs(12) // 4
}
