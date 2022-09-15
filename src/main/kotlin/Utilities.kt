import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun Dispatchers.FakeMain() = Dispatchers.Default

val babyNameContext = Dispatchers.Default + CoroutineName("Little Droid Jr.")
