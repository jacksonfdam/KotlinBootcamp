import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// sampleStart
// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld3()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld3() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}
// sampleEnd
