import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * For each of the points below, mark down your answer and then run the function to see if you were correct.
 */
fun exercise5() {
    runBlocking(Dispatchers.IO + CoroutineName("Name 1")) {
        withContext(CoroutineName("Name 2")) {
            // What Dispatcher and name will be used here?
            println(coroutineContext)
        }

        withContext(Dispatchers.Default) {
            // What Dispatcher and name will be used here?
            println(coroutineContext)
        }

        // What Dispatcher and name will be used here?
        println(coroutineContext)
    }
}
