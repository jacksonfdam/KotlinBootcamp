import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/*
https://developer.android.com/codelabs/basic-android-kotlin-training-introduction-coroutines#3
 */
val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }

suspend fun getValue(): Double {
    println("entering getValue() at ${time()}")
    delay(3000)
    println("leaving getValue() at ${time()}")
    return Math.random()
}

fun main() {
    repeat(3) {
        GlobalScope.launch {
            println("Hi from ${Thread.currentThread()}")
        }
    }

    runBlocking {
        val num1 = getValue()
        val num2 = getValue()
        println("result of num1 + num2 is ${num1 + num2}")
    }

    // _main()
    _mainCR()
}

fun _main() {
    runBlocking {
        val num1 = async { getValue() }
        val num2 = async { getValue() }
        println("_main result of num1 + num2 is ${num1.await() + num2.await()}")
    }
}

fun _mainThread() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        Thread {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                Thread.sleep(50)
            }
        }.start()
    }
}
fun _mainCR() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        GlobalScope.launch {
            println("_mainCR - ${Thread.currentThread()} has started")
            for (i in states) {
                println("_mainCR - ${Thread.currentThread()} - $i")
                delay(5000)
            }
        }
    }
}