fun main(args: Array<String>){
    val h1 = Header("H1")
    val h2 = Header("H2")

    // if the function didn't have the infix keyword, it would be called like: h1.plus(h2)
    val h3 = h1 plus h2
    println(h3.Name)
    // operator overload
    val h4 = h1 + h2
    println(h4.Name)
}

class Header (var Name: String) {}

infix operator fun Header.plus(other:Header): Header{
    return Header(this.Name + other.Name)
}