// Notation to give custom names to the compiled kotlin class
// Notation to give custom names to the compiled kotlin class
@file:JvmName("KotlinFunctions")

// the main function is the entry point in Kotlin too
fun main(args: Array<String>){
    // Functions are created with the "fun" keyword
    // They can have default parameter and named parameters and can extend types
    // Unlike Java, Kotlin support stand alone functions, meaning that they don't need to be inside a class
    // but the compiler creates a class under the hood so the functions can be used from a Java program.
    // By default the compiler creates a class with the file name + Kt, in this case FunctionsKt

    display("Hello world!")
    display()
    // you can use named parameters when calling a function so you don't need to respect the order
    display(times=3, message="Named parameters")
    // it is useful when you don't want to pass all the parameters
    display(times=2)

    println(max(1,2))

    // Extension functions can be used to add functions to a class we do not own
    // Kotlin generates static functions and we don't need to create utility classes
    // Makes code easier to read

    val text = "String     with      multiple     spaces    between    words."
    println(text)
    // the function is called like it was a function in the kotlin String class
    println(text.replaceMultipleWhiteSpace())

    // Tail recursive functions: teilrec keyworld
    // the compiler optimize recursive functions to optimize the code and avoid stackoverflow exceptions

}

// A regular function with a parameter, a default value and a typed return value
// But Java doesn't support default values, so we can add a notation to take care of that
@JvmOverloads
fun display(message: String = "Default message", times: Int = 1) : Boolean {
    for (i in 1..times)
        println(message)
    return true
}

// function expression
fun max(a: Int, b: Int): Int = if (a > b) a else b

// Declaring a extension function to add a method to the String class
fun String.replaceMultipleWhiteSpace() : String {
    var regex = Regex("\\s+")
    return regex.replace(this, " ")
}
