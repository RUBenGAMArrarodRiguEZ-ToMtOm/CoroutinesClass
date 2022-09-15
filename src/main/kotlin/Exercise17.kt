import kotlinx.coroutines.*

/**
 * There is a bug in this code. Can you see what it is before running the code? How about after you
 * see the output?
 */
fun exercise17() = runBlocking {
    val job = GlobalScope.launch(Dispatchers.Default) {
        repeat(7) { i ->
            try {
                // print a message twice a second
                println("Emitting item $i ...")
                delay(500)
            } catch (e: Exception) {
                // log the exception
                println(e.message)
            }
        }
    }
    delay(1500)
    println("Parent is cancelling the child")
    job.cancelAndJoin()
}