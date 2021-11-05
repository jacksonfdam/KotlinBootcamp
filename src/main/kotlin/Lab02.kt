import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// sampleStart
fun main() = runBlocking {
    doWorld2()
}

suspend fun doWorld2() = coroutineScope { // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
// sampleEnd
