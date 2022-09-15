import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/**
 * Try creating a custom logging context element of your own! I have provided a base implementation to get
 * started.
 *
 * Step 1: Add functionality to the implementation
 *
 * Step 2: Utilize the CustomElement in order to invoke the logic.
 */

fun exercise18() = runBlocking {

    launch {
        // TODO: Utilize your custom functionality
    }.join()
}

private class CustomElement() : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<CustomElement>

    override val key: CoroutineContext.Key<*>
        get() = CustomElement

    // TODO: Add some functionality to this element
}