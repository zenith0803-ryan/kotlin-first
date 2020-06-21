package com.kotlin.three

//3.5.2 정규식과 3중 따옴표로 묶은 문자열

//파일의 전체경로명을 디렉토리,파일이름,확장자로 구분하는것을 해보자
// "/Users/yole/kotlin-book/chapter.adoc"

// 그림 3.4

//3.9 String확장함수를 사용해 경로파싱하기
fun parsePath(path: String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

//3.10 경로파싱에 정규식 사용하기
fun parsePath_2(path: String){
    val regex = """(.+)/(.+)\.(.+)/(.+)""".toRegex()
    //            디렉토리/ 파일이름 . 확장자
    // 3중 따옴표 문자열을 사용해 정규식 사용
    // 3중 따옴표 문자열에서는 역슬래시(\)를 포함한 어떤 문자도 이스케이프할 필요가 없다.
    //  문자열을 사용해 정규식을 작성하는 경우 마침표 기호는  \\.  라고 써야하지만
    //  3중문자열에서는  \.
    val matchResult = regex.matchEntire(path)
    if( matchResult != null){
        val(directory, filename, extension, test) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension, test: $test")
    }

}

fun main(args: Array<String>){
    //parsePath("/Users/yole/kotlin-book/chapter.adoc")

    parsePath_2("/Users/yole/kotlin-book/chapter.adoc/abcde")
}