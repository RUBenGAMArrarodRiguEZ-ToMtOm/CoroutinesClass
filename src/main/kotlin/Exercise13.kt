import kotlinx.coroutines.*

/**
 * This program will run for ~50 seconds as currently written. We don't want it to hang for that long so will
 * cancel it early. Prove to yourself that cancellation is bi-directional by cancelling this
 * long running child both directly and via its parent.
 *
 * Step 1: Cancel the child directly, and see that the parent is also canceled (evidence by the program
 * completing instead of continuing to hang)
 *
 * Step 2: Remove the code you added for step 1 and instead cancel the parent directly. Notice that the
 * child's emissions stop when the parent is cancelled.
 */
fun exercise13() = runBlocking {
    val startTime = System.currentTimeMillis()

    // Parent
    CoroutineScope(Dispatchers.Default).launch {

        // Long Running Child
        launch {
            repeat(1000) { i ->
                println("Doing work $i ...")
                delay(50)
            }
        }

    }.join()

    println("Spent ${System.currentTimeMillis() - startTime}ms in method")
}