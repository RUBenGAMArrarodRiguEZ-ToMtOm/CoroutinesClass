import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

/**
 * Convert the following RxStream into it's coroutine equivalent
 */
fun exercise3() {
    Observable.just(resizeImage())
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.io())
        .map { reportImageSizeToNetwork(it) }
        .observeOn(MainThread)
        .subscribe {
            showUI(it)
        }
}

/**
 * The code below this line is not strictly necessary for the example, but you can look at it if
 * you like.
 */

private val MainThread = Schedulers.single() // Mimic Android's Main Thread

/**
 * Pretend this function resizes images locally and returns their new sizes
 */
private fun resizeImage(): List<Int> = listOf(1, 2, 3)

/**
 * Pretend this function reports the new image sizes to the backend and returns true if the request
 * was successful and false if not
 */
private fun reportImageSizeToNetwork(numbers: List<Int>): Boolean {
    // Pretend that network request was made and was successful
    return Random.nextBoolean()
}

/**
 * Pretend this function displays the result of the request in the UI.
 */
private fun showUI(wasSuccessful: Boolean) {
    if (wasSuccessful) {
        println("🙌🎉🥳")
    } else {
        println("😢💔😩")
    }
}
