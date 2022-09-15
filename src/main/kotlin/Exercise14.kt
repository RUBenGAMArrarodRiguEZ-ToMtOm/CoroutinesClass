import kotlinx.coroutines.*

/**
 * Run this program as is and observe the output. Then add an error into Child 1. How does the output change
 * and why?
 */
fun exercise14() = runBlocking {
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
    }
}