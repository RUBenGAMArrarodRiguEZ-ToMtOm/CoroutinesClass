import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


/**
 * Run the following function and take a look at the output. Can you explain what is happening?
 */
fun exercise12() {
    val fastEmitter = flow {
        for (i in 0..100) {
            emit(i)
        }
    }

    runBlocking {
        val consumer1 = fastEmitter.conflate().buffer(100).onEach { delay(5) }.toList()
        val consumer2 = fastEmitter.conflate().map { it }.buffer(100).onEach { delay(5) }.toList()

        println("Size of first list is: ${consumer1.size}")
        println("Size of second list is: ${consumer2.size}")
    }
}