import java.lang.Exception
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    // var - mutable variable
    // val - imutable variable

    val q = Question()
    // The Answer property can be changed because it is a var, but if
    // we try to change the value for Question or create assign a new Question instance to q
    // we will get a compiling error because they are declared as val.
    q.Answer = "42"
    // q.Question = "New question"
    // q = Question()

    q.display()
    // The interpolation is bounded to the q instance, not the answer property
    println("Your answer: $q.Answer")
    println("Your answer: ${q.Answer}")

//    var message:String
//
//    if (q.Answer == q.RightAnswer){
//        message = "Your answer is correct :)"
//    } else {
//        message = "Your answer is wrong ):"
//    }

    val message = if (q.Answer == q.CorrectAnswer) "Your answer is correct :)" else "Your answer is wrong ):"

    println(message)

    q.printResult()

    val number:Int? = try {
        Integer.parseInt(q.Answer)
    }catch (e:Exception){
        null
    }

    println("Number is $number")

}

// We don't need to declare the getters and setters, the compiler takes care of that for us and creates them
// under the hood
class Question {
    // In kotlin values can't be null unless you explicitly indicate with ?
    // So the statement: Answer != null will always be true
    var Answer:String = ""
    val CorrectAnswer = "42"
    val Question:String = "What is the answer to life, the universe and everything?"

    fun display(){
        println("Your answer: $Answer")
    }

    fun printResult(){
        // when statement works like the switch statement from other languages
        when (Answer){
            CorrectAnswer -> println("Your answer is correct :)")
            else -> println("Your answer is wrong ):")
        }
    }
}