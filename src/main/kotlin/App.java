public class App {
    public static void main(String[] args){
        // If the annotation is removed
        // FunctionsKt.display("Calling kotlin class from Java");
        KotlinFunctions.display("Calling kotlin class from Java");
        KotlinFunctions.display();
        Student.printSomething();
    }

}
