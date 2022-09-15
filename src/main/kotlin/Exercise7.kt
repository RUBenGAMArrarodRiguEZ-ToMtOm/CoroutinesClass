import kotlinx.coroutines.*
import kotlin.random.Random

/**
 * We are currently waiting for each image to finish loading before we load the next. Modify
 * this function to load these images in parallel so that we can speed up the loading process.
 *
 * Note: There are two different coroutine builders you can use to accomplish this, but one is
 * more correct than the other. Do you know which to use and why?
 */
fun exercise7() {
    val urls = listOf("first url", "second url", "third url", "fourth url")

    runBlocking {
        urls.forEach { loadUrl(it) }
    }
}

private suspend fun loadUrl(url: String) {
    println("Beginning to load $url")

    // Imagine loading images takes some amount of time up to 5 seconds
    delay(Random.nextLong(5000))

    println("Finished loading $url")
}