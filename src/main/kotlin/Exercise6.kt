import kotlinx.coroutines.*

/**
 * This program will run indefinitely. Modify the code below to quit after 5 seconds instead.
 */
fun exercise6() {
    runBlocking {
        var counter = 1
        while (true) {
            println("I am doing work: ${counter++}")
            delay(1000)
        }
    }
}