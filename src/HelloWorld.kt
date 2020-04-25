fun main(args : Array<String>){
     if(args.size > 0)
        print("${args[0]}")
    //println("Hello World" + max2(2,3))
    //println(yearsToCompute)
}

fun max(a: Int, b: Int): Int{
    return if( a > b) a else b
}

fun max2(a: Int, b: Int) : Int{
    return max(a,b)
}

fun max3(a : Int, b : Int) : Int = if (a > b) a else b

val question = "삶, 우주 그리고 생명"

val x = 3
val y : Int = 4
val yearsToCompute = 7.5e6