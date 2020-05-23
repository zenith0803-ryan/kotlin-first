package com.kotlin.three

import kotlin.IllegalArgumentException

// 3.6 코드다듬기 : 로컬함수의 확장
// 코틀린에서는 함수에서 추출한 함수를 원함수 내부에 중첩시킬수 있다. --> 깔끔하다.

//3.11 코드중복을 보여주는 예제
class User(val id: Int, val name: String, val address: String)

fun saveUser(user:User){
    if(user.name.isEmpty())
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")

    if( user.address.isEmpty())
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    // filed 검증이 중복된다.

    // user를 디비에 저장
}

//3.12 로컬 함수를 사용해 코드중복 줄이기

fun saveUser2(user: User){
    fun validate(user:User, value: String, fieldName: String){
        if(value.isEmpty()){
            throw  IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")  //로컬함수를 호출해서 각 필드를 저장한다.
    //user를 디비에 저장
}

// 3.13 로컬함수에서 바깥함수의 파라미터 접근하기
fun saveUser3(user: User){
    fun validate( value: String, fieldName: String){  //saveUser함수의 user파라미터를 중복사용하지 않는다.
        if(value.isEmpty()){
            throw  IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")  //바깥함수의 파라미터에 직접접근할수 있다.
        }
    }
    validate(  user.name, "Name")
    validate(  user.address, "Address")  //로컬함수를 호출해서 각 필드를 저장한다.
    //user를 디비에 저장
}

//3.14 검증로직을 확장함수로 추출하기
// - 한객체만을 다루면서 객체의 비공개 데이터를 다룰 필요는 없는 함수는 이렇게 확장함수로 만들면 객체.멤버처럼 수신객체를 지정하지 않고도
// 공개개된 멤버프로퍼티나 메소드에 접근할수 있다.
// User.validateBeforeSave를 saveUser내부에 로컬함수로 넣을수도있다.
fun User.validateBeforeSave(){
    fun validate( value: String, fieldName: String){
        if(value.isEmpty()){
            throw  IllegalArgumentException("Can't save user $id: empty $fieldName")  //user 프로퍼티를 직접사용할수있다.
        }
    }
    validate(  name, "Name")
    validate(  address, "Address")  //로컬함수를 호출해서 각 필드를 저장한다.
}
fun saveUser4(user: User){
    user.validateBeforeSave()

    // save user
}

fun main(args: Array<String>){
 //   saveUser(User(1,"",""))
    //saveUser2(User(2,"",""))
    saveUser4(User(3,"",""))
}