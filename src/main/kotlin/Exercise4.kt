import kotlinx.coroutines.*

/**
 * Two ComputerScience parents want to announce the name of their child in the nerdiest way possible.
 * Use the CoroutineContext to find out what they've named their kid!
 */
fun exercise4() {
    runBlocking(babyNameContext) {
        // Print the coroutine's name to find out what the parents will name their baby
        val babyName = TODO()
        println("The baby's name is: $babyName")
    }
}

