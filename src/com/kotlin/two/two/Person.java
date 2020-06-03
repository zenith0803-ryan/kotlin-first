package com.kotlin.two.two;

//간단한 JavaBean 클래스
public class Person {
    private final String name;
    //필드가 둘이상 늘어나면 생성자인 Person(String name)의 본문에서 파라미터를 이름이 같은 필드에 대입하는 대입문의 수도 늘어난다.
    //자바에서는 생성자본문에 이같은 코드가 반복적으로 들어가는 경우가 많다.
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
