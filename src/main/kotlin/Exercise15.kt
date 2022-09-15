import kotlinx.coroutines.*

/**
 * The code below is the same as Exercise 14. Update it to run in a Supervisor context instead of a standard Job and
 * then once again introduce a crash into Child 1. How does the output change now?
 */
fun exercise15() = runBlocking {
    launch {
        launch {
            delay(1000)
            println("Child 1 all done!")
        }

        launch {
            delay(2000)
            println("Child 2 all done!")
        }

        delay(3000)
        println("Parent is complete")
    }.join()
}