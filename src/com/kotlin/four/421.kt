package com.kotlin.four

import com.sun.org.apache.xpath.internal.operations.Bool

// 4.2.1 클래스초기화 : 주생성자와 초기화블록

class User(val nickname: String) // val : 파라미터에 상응하는 프로퍼티가 생성된다는 뜻이다.
// 클래스이름뒤에 오는 괄호로 둘러싸인 코드를 주생성자(Primary Constructor)라고 부른다.


//주 생성자는 생성자 파라미터를 지정하고 그 생성자 파라미터에 의해 초기화되는 프로퍼티를 정의하는 두가지 목적
class User2 constructor(_nickname: String){  // 파라미터가 하나만 있는 주 생성자  , constructor : 주생성자나 부생성자 정의를 시작할때 사용 ,
/// 밑줄(_): 프로퍼티와 생성자 파라미터를 구분

    val nickname: String
    init {  //초기화 블록 : 클래스의 객체가 만들어질때 실행될 초기화 코드가 들어간다.
        nickname = _nickname
    }
}

class User3(_nickname : String){  // 파라미터가 하나뿐인 주 생성자
    val nickname = _nickname  // 프로퍼티를 주 생성자의 파라미터로 초기화 한다.
}

//첫번째것이 가장 간결


// 생성자파라미터에도 디폴트값을 정의할수 있다.
class User4(val nickname: String
            , val isSubscribed: Boolean = true)

// 클래스의 인스턴스를 만드려면 new keyword없이 생성자를 호출하면된다.

fun main(args: Array<String>){
    val hyun = User4("현석")
    println(hyun.isSubscribed)

    val gye = User4("계영", false)  //모든 인자를 파라미터 선언 순서대로 지정할수도 있다.
    println(gye.isSubscribed)

    val hey = User4("혜원", isSubscribed = false) //생성자 인자중 일부에 대해 이름을 지정할수도 있다.
    println(hey.isSubscribed)
}

open class User5(val nickname: String)

class TwitterUser(nickname : String): User5(nickname)
//클래스에 기반클래스가 있다면 주 생성자에서 기반 클래스의 생성자를 호출해야할 필요가 있다

open class Button1 // 인자가 없는 디폴트생성자가 만들어진다
class RadioButton : Button1() // Button1생성자는 인자가없지만, 이 클래스를 상속한 하위클래스는 반드시 Button1클래스의 생성자를 호출해야한다.
// 그래서 기반클래스의 이름뒤에 꼭 빈괄호가 들어간다.
// 인터페이스는 생성자가 없기때문에 아무괄호도없다.
// 이름뒤에 괄호가 붙었는지 보면 기반클래스와 인터페이스를 구별할수가 있다.

// 클래스외부에서 인스턴스화하지 못하게 막고싶다면 모든생성자를 private로 만들면된다.
class Secretive private constructor()  // 이 클래스의 유일한 주 생성자는 비공개다.


