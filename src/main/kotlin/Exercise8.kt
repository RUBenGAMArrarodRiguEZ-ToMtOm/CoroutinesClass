import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * This is an example that shows how flows won't produce any items until collected, just like Observables.
 *
 * You don't need to make any modifications to this code, but can run it to prove to yourself
 * that the flow behavior is behaving as you'd expect.
 */
fun exercise8() {
    val myFlow = flowOf(1,2,3).onEach { println("Flow is emitting $it") }

    println("Nothing has been printed yet")

    runBlocking {
        myFlow.collect()
    }

    println("All done processing the collection!")
}