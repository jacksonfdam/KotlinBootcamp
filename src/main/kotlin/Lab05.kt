import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// https://github.com/Kotlin/kotlinx.coroutines/blob/master/docs/topics/coroutines-basics.md

// sampleStart
fun main() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".\n")
        }
    }
}
// sampleEnd
