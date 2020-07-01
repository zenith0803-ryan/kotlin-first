package com.kotlin.six

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

import FileContentProcessor
import java.io.File
import DataParser
import com.kotlin.five.Person

//list 6.21
fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()  //널이 될수 있는 Int값으로 이뤄진 리스트를 만든다.
    for(line in reader.lineSequence()){
        try{
            val number = line.toInt()
            result.add(number)  //정수(널이아닌값)를 리스트에 추가
        }catch (e: NumberFormatException){
            result.add(null) // 현재줄을 파싱할수 없으므로 리스트에 널을 추가한다.
        }
    }
    return result
}

// list 6.22 널이 될수 있는 값으로 이뤄진 컬렉션 다루기
fun addValidNumbers(numbers: List<Int?>){
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for ( number in numbers){  //리스트에서 널이 될수 있는 값을 읽는다.
        if(number != null) {  //널체크
            sumOfValidNumbers += number
        }else{
            invalidNumbers++
        }
    }
    println("Sum of vaild numbers = $sumOfValidNumbers")
    println("Invalid numbers = $invalidNumbers")
}

//list 6.23 filterNotNull를 널이 될수 있는 값으로 이뤄진 컬렉션에 대해 사용하기
fun addValidNumbers_rfc1(numbers: List<Int?>){
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers = ${numbers.size - validNumbers.size}")
}

// list 6.24 읽기전용과 변경 가능한 컬렉션 인터페이스
fun<T> copyElements(source: Collection<T>, target: MutableCollection<T>){
    for(item in source){
        target.add(item)
    }
}

//list 6.26
class FileIndexer: FileContentProcessor{
    override fun processContents(path: File , binaryContents: ByteArray?, textContents:  List<String>? ) {

    }
}

//list 6.28
class PersonParser: DataParser<Person>{
    override fun parseData(input: String , output: MutableList<Person> , errors: MutableList<String?> ) {
        TODO("Not yet implemented")
    }
}



fun main(args: Array<String>) {
    val reader=BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

    addValidNumbers_rfc1(numbers)


    //6.24 test
    val source: Collection<Int> = arrayListOf(3,5,7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)

    //6.30
    val letters = Array<String>(26) { i -> ('a'+i).toString()}
    println(letters.joinToString { "_" })

    //6.31
    val strings = listOf("a","b","c")
    println("%s/%s/%s".format(*strings.toTypedArray())) // vararg인자를 넘기기 위해 스프레드 연산자(*) 를 써야 한다.
    //toTypedArray : 컬렉션을 배열로 만듬


    //원시타입의 배열을 만드는 방법
    val fiveZeroes = IntArray(5)
    val fiveZerosToo = intArrayOf(0,0,0)

    //람다를 인자로 받는 생성자를 사용하는 방법
    val squares = IntArray(5){ i -> (i+1) * (i+1)}
    println(squares.joinToString())

    //6.32 배열에 forEachIndexed 사용하기
    args.forEachIndexed { index, element ->
        println("Argument $index is:  $element")
    }
}