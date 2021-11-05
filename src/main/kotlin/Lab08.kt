import kotlinx.coroutines.*

suspend fun fetchDocs() {                             // Dispatchers.Main
    val result = get("https://developer.android.com") // Dispatchers.IO for `get`
    show(result.toString())                                      // Dispatchers.Main
}

suspend fun fetchDoc(number:Int) {                             // Dispatchers.Main
    val result = get("https://developer.android.com") // Dispatchers.IO for `get`
    show(result.toString())                                      // Dispatchers.Main
}

fun show(result: String) {
    print(".\n - result")
}

suspend fun get(url: String) = withContext(Dispatchers.IO) { /* ... */ }

suspend fun fetchTwoDocs() =
    coroutineScope {
        val deferredOne = async { fetchDoc(1) }
        val deferredTwo = async { fetchDoc(2) }
        deferredOne.await()
        deferredTwo.await()
    }

suspend fun fetchTwoDocs2() =        // called on any Dispatcher (any thread, possibly Main)
    coroutineScope {
        val deferreds = listOf(     // fetch two docs at the same time
            async { fetchDoc(1) },  // async returns a result for the first doc
            async { fetchDoc(2) }   // async returns a result for the second doc
        )
        deferreds.awaitAll()        // use awaitAll to wait for both network requests
    }

class ExampleClass {

    // Job and Dispatcher are combined into a CoroutineContext which
    // will be discussed shortly
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun exampleMethod() {
        // Starts a new coroutine within the scope
        scope.launch {
            // New coroutine that can call suspend functions
            fetchDocs()
        }
    }

    fun cleanUp() {
        // Cancel the scope to cancel ongoing coroutines work
        scope.cancel()
    }
}

class ExampleClass2 {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun exampleMethod() {
        // Starts a new coroutine on Dispatchers.Main as it's the scope's default
        val job1 = scope.launch {
            // New coroutine with CoroutineName = "coroutine" (default)
        }

        // Starts a new coroutine on Dispatchers.Default
        val job2 = scope.launch(Dispatchers.Default ) {
            // New coroutine with CoroutineName = "BackgroundCoroutine" (overridden)
        }
    }
}