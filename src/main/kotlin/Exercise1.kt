import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Exercise 1: Builders
fun exercise1() {
    println("Exercise 1 Started")

    // Run this code and notice that the coroutine block doesn't print.
    // Update the coroutine builder to make sure it executes
     GlobalScope.launch {
        println("Started delay")
        delay(5000)
        println("Delay complete!")
    }


    println("Exercise 1 Complete")
}
