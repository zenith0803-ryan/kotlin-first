package com.kotlin.four

//4.15 세터에서 뒷받침하는 필드 접근하기
class User6(val name:String){
    var address : String = "unspecified"
        set(value: String){
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())  //뒷받침하는 필드값 읽기
            field = value  //뒷받침하는 필드값 변경하기
        }

}
fun main(args: Array<String>){
    val user = User6("Alice")
    user.address = "수지구 손곡로 82 104동"

}