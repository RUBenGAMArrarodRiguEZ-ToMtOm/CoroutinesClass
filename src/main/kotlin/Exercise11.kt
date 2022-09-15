import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * The two flows below produce different output. Can you explain why we get the output we do in
 * each case?
 */
fun exercise11() {
    runBlocking {
        val flow = flow {
            for (i in 1..3) {
                println("Producing $i")
                emit(i)
            }
        }

        // Consumer 1:
        flow.collect { value ->
            delay(10)
            println("FirstFlow: Consuming $value")
        }

        println("------- Compare the above output to the following: -----")

        flow.buffer(0).collect { value ->
            delay(10)
            println("SecondFlow: Consuming $value")
        }
    }
}
