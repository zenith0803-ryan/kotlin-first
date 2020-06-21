package com.kotlin.five

import javax.naming.Context

fun alphabet(): String{
    val result = StringBuilder()
    for(letter in 'A'..'Z')
        result.append(letter)
    result.append("\nNow I know the alphabet")
    return result.toString()
}
fun alphabet_with(): String{
    val stringBuilder = StringBuilder()
    return with(stringBuilder){
        for(letter in 'A'..'Z')
            this.append(letter)
        append("\nNow I know the alphabet")  //"this"를 생략하고 메소드를 호출한다.
        this.toString()
    }
}
fun alphabetWithAll() = with(StringBuilder()){
    for(letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet")  //"this"를 생략하고 메소드를 호출한다.
    toString()
}
fun alphabetApply() = StringBuilder().apply{
    for(letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet by Apply")
}.toString()

fun alphabet521() = buildString {
    for( letter in 'A'..'Z')
        append(letter)

    append("\nNow I know the alphabet by buildString")
}
fun main(args : Array<String>){
    //println(alphabet())
    //println(alphabet_with())
    //println(alphabetApply())
    println(alphabet521())
}