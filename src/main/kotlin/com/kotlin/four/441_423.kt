package com.kotlin.four

import java.io.File

//리스트 4.23 객체선언을 사용해 Comparator구현하기
// Comparator : 두객체를 인자로 받아 어느객체가 더 큰지 정수를 반환. 데이터저장할필요없고 보통 클래스마다 단 하나씩만 있으면 된다.
object CaseInsensitiveFileComparator : Comparator<File>{
    override fun compare(file1 : File , file2 : File ) : Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}
fun main (args : Array<String>){
    println(CaseInsensitiveFileComparator.compare(
         File("/Users/zenith/Downloads/tnsnames.ora1234567")
        ,File("/Users/zenith/Downloads/tnsnames.ora"))
    );

    // Comparator를 인자로  받는 함수에게 인자로 넘길수 있다.
    val files = listOf(File("/Users/zenith/Downloads/tnsnames.ora1234567")
        , File("/Users/zenith/Downloads/tnsnames.ora"))
    files.sortedWith(CaseInsensitiveFileComparator)
}