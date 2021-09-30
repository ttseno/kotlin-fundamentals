fun main(args: Array<String>){
    val boolList = arrayOf(false, true, false)
    val binaryString = boolList.map{if (it) 1 else 0}.toString()
    print(binaryString)
    val number = Integer.parseInt(binaryString, 2)
    print(number)
}