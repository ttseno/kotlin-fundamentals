interface A {
    // methods can have a default implementation
    fun doSomething(param: String) = println(param)
}
interface B {
    fun doSomething()
}

class InterfaceImplementation : A, B {
    // Classes have to explicitly override the interface methods
    override fun doSomething() {
        super<A>.doSomething("Overwritten B method calling default implementation from A")
    }

    override fun doSomething(param: String) {
        println("From inside the custom implementation. $param")
        privateFunction()
    }

    private fun privateFunction(){
        println("This private function can only be called from inside the class.")
    }
}

// In Kotlin classes are public and final by default, meaning they can't be inherited
// Open classes can be inherited
open class OpenClass {
    // methods are also final by default
    open fun openFunction(){
        println("Inside open class")
    }
    fun finalFunction(){
        println("This class can't be overwritten")
    }
}

class InhetingClass : OpenClass() {
    override fun openFunction() {
        println("Overwritten open function")
        super.openFunction()
    }
}

abstract class AbstractClass {
    fun finalFunction(){
        println("Final function that can't be overwritten inside abstract class.")
    }
    abstract fun abstractMethod()
}

class ImplementingAbstraction : AbstractClass(){
    override fun abstractMethod() {
        println("This method needs to be implemented on the classes that derives from the abstract class")
    }
}

// Kotlin has a internal keyword to define that the class can only be accessed inside that specific module
// Kotlin also has private and protected but not private packages

// When specifying a sealed class you can define what specific classes can derive from it
sealed class PersonEvent{
    class Awake : PersonEvent()
    class Asleep : PersonEvent()
    class Eating(val food: String) : PersonEvent()
}

fun handlePersonEvent(event: PersonEvent){
    when(event){
        is PersonEvent.Awake -> println("Awake")
        is PersonEvent.Asleep -> println("Asleep")
        is PersonEvent.Eating -> println("Is eating ${event.food}")
    }
}


// data classes provide equal, hashCode and toString methods and they're immutable
data class StudentData(val id: Int, val name: String){}
open class Student(val id: Int, val name: String){

    fun enrole(courseName: String){
        var couse = Courses.allCourses.filter{ it.title == courseName }.firstOrNull()
    }

    // objects can be created inside a class so the scope is limited within it
    // companion objects can help create static methods inside kotlin and factory methods
    // They can also implement interfaces and derive from other classes
    companion object : DummyInterface {

        fun createUndergraduate(name:String) : Undergraduate{
            return Undergraduate(name)
        }
        fun createPostgraduate(name:String) : Postgraduate{
            return Postgraduate(name)
        }

        // By adding this notation, these methods can be called directly from a Java class
        @JvmStatic
        override fun printSomething() {
            println("Overwritten method inside companion object")
        }

    }
}

class Undergraduate(firstName: String) : Student(1, firstName){}
class Postgraduate(firstName: String) : Student(1, firstName){}

class Course(val id: Int, val title: String)
// when using the object keyword in the class definition, an instance is created as soon as the object type is declared
// they can contain properties and methods, but they can have a constructor, since they can't be initialized
object Courses {
    var allCourses = arrayListOf<Course>()
}

fun main(args: Array<String>){
    val interfaceImplementation = InterfaceImplementation()
    interfaceImplementation.doSomething()
    interfaceImplementation.doSomething("doing something")

    val inhetingClass = InhetingClass()
    inhetingClass.openFunction()
    inhetingClass.finalFunction()

    val abstraction = ImplementingAbstraction()
    abstraction.abstractMethod()
    abstraction.finalFunction()

    val awakeEvent = PersonEvent.Awake()
    handlePersonEvent(awakeEvent)
    val asleepEvent = PersonEvent.Asleep()
    handlePersonEvent(asleepEvent)
    val eatingEvent = PersonEvent.Eating("apple")
    handlePersonEvent(eatingEvent)


    var tiemy = StudentData(1, "Tiemy")
    var seno = StudentData(1, "Tiemy")

    var st1 = Student(1, "Tiemy")
    var st2 = Student(1, "Tiemy")

    // In regular classes, the object pointer is compared when comparing two instances
    if(st1 == st2) println("Equals") else println("Not equal")
    // But with data classes, the actual data is compared
    if(tiemy == seno) println("Equals") else println("Not equal")

    // When printing data classes, kotlin calls the .toString() method
    println(tiemy)
    // In regular classes, the instance memory address is printed
    println(st1)

    // data classes also have a built in copy function to copy the data to a new instance
    val newTiemy = tiemy.copy(id=2)
    println(newTiemy)

    // The companion objects can be called as static methods of the class
    Student.createPostgraduate("Tiemy")
    Student.createUndergraduate("Tiemy")
    Student.printSomething()
}

interface DummyInterface {
    fun printSomething()
}