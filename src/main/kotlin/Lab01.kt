import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
        main2()
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

suspend fun main2() = coroutineScope {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")
        doWorld()
    }
    println("Hello")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
// sampleEnd
