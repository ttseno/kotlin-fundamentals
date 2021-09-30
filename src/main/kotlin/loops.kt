import java.util.*

fun main(args: Array<String>) {
    val answerToEverything = "42"
    // when statement works like the switch statement from other languages
    when (answerToEverything){
        "42" -> println("Answer is correct")
        else -> println("Not the correct answer")
    }

    // Kotlin has also the while(stmt){} and do{}while(stmt) loops that work in the same way as Java
    // Kotlin doesn't have the incremental for loop like Java: for(int i; i < 10; i++), instead it works
    // with the concept of range
    // there can also be range of strings like 'a'..'z'

    // Full range - they include the starting and ending values of the range
    println("1 in range 10")
    for (i in 1..10){
        println(i)
    }
    // Half-closed range - doesn't include the last value
    println("1 until 10")
    for(i in 1 until 10){
        println(i)
    }
    println("1 in range 10 stepping 2 at a time")
    for (i in 1..10 step 2) { // steps two in each iteration
        println(i)
    }
    println("10 down to 1")
    for (i in 10 downTo 1){
        println(i)
    }

    // For loop can also iterate over the items of a list
    var numbers = listOf(1,2,3,4,5)
    for (i in numbers){
        println(i)
    }
    // Iterating over list index
    for((index, element) in numbers.withIndex()){
        println("Value \"$element\" at index $index")
    }

    // Iterating over maps
    var ages = TreeMap<String, Int>()
    ages["Sam"] = 23
    ages["Kevin"] = 31
    ages["Alex"] = 26
    for ((name, age) in ages){
        println("$name is $age")
    }
}
