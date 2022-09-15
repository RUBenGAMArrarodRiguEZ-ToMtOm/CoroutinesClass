import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * This is an example that shows how SharedFlows can emit whether someone is listening or not.
 *
 * Take a look at the last print statement, can you explain the behavior?
 */
fun exercise9() {
    val mutableSharedFlow = MutableSharedFlow<Int>()

    runBlocking {
        launch { produceValues(mutableSharedFlow) }

        delay(4000)
        println("Now I will subscribe!")

        launch { collectValues(mutableSharedFlow) }
    }

    println("All done!") // <-- What do you notice about this line? Why is that happening?
}

private suspend fun produceValues(sharedFlow: MutableSharedFlow<Int>) {
    for (i in 0..10) {
        delay(1000)
        println("I am emitting item $i")
        sharedFlow.emit(i)
    }
}

private suspend fun collectValues(sharedFlow: MutableSharedFlow<Int>) {
    sharedFlow.collect {
        println("Subscriber has received item $it")
    }
}