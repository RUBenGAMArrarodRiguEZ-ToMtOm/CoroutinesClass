import kotlinx.coroutines.*

/*
Exercise 2: We would like to do some work on the main thread, and some work on a background thread. Fix the code
below so that it is running the work in the correct location.
 */
fun exercise2() {
    runBlocking {
        val isMainThreadWork = mainThreadWork()
        val isBackgroundWork = backgroundWork()
        println("Is the work running in the right place? ${isMainThreadWork && isBackgroundWork}")
    }
}

private suspend fun mainThreadWork(): Boolean {
    println("I want this work to happen on the main thread")
    delay(1000)
    return Thread.currentThread().name == "main"
}

private suspend fun backgroundWork(): Boolean {
    println("I want this work to happen off the main thread")
    delay(1000)
    return Thread.currentThread().name != "main"
}
