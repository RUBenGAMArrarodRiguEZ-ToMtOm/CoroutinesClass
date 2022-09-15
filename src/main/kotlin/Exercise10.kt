import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Using the provided consume methods, write a coroutine that subscribes two consumers:
 * 1. The first one after 4 seconds
 * 2. The second after 8 seconds
 *
 * When the consumers subscribe to the flow, they should receive the three most recently emitted values
 */
fun exercise10() {
    val sharedFlow = MutableSharedFlow<Int>()

    runBlocking {
        val jobs = mutableListOf<Job>()

        jobs += launch { produceValues(sharedFlow)}



        // TODO: Insert your code here



        // Manually clean up the endless jobs so the program can quit
        delay(10_000)
        jobs.forEach { it.cancel() }
    }
}

/**
 * This producer produces a never ending stream of numbers.
 */
private suspend fun produceValues(sharedFlow: MutableSharedFlow<Int>) {
    var counter = 0
    while (true) {
        delay(1000)

        println("Emitting item $counter")
        sharedFlow.emit(counter)

        counter++
    }
}

private suspend fun consumeValues(subscriberNumber: Int, sharedFlow: MutableSharedFlow<Int>) {
    sharedFlow.collect {
        println("......Subscriber #$subscriberNumber is consuming value $it")
    }
}