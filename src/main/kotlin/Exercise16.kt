import kotlinx.coroutines.*
import java.io.IOException

/**
 * Run this code and check the output. Notice that the error is handled by the parent and that it is getting
 * cancelled before it hits the second print statement.
 *
 * Update this code to run in a SupervisorScope and then run it again. Where is the error handled now?
 */
@OptIn(DelicateCoroutinesApi::class)
fun exercise16() = runBlocking {
   val parentCEM = CoroutineExceptionHandler { _, e ->
        println("Parent CEM has error $e")
    }

    val childCEM = CoroutineExceptionHandler { _, e ->
        println("Child CEM has error $e")
    }

    val job = GlobalScope.launch(parentCEM) {
        val child = launch(childCEM) {
            delay(2000)
            throw IOException()
        }
        yield()
        child.join()
        yield()
        println("Parent is not cancelled")
    }
    job.join()
}