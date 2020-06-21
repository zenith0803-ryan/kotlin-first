package com.kotlin.two.two

class Person2 (
    val name : String,  //읽기전용 프로퍼티 코틀린은 비공개필드와 필드를 읽는 단순한 공개게터를 만듬
    var isMarried : Boolean //쓸수있는 프로퍼티 게터,세터를 만듬
)