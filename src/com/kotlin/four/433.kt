package com.kotlin.four

//4.3.3 클래스 위임: by 키워드 사용
//데코레이터 패턴 : 상속을 허용하지 않는 클래스(기존 클래스) 대신 사용할수 있는 새로운 클래스(데코레이터)를 만들되
// 기존 클래스와 같은 인터페이스를 데코레이터가 제공하게 만들고,
// 기존 클래스를 데코레이터 내부 필드로 유지하는것!!!
// 새로 정의해야하는 기능은 데코레이터 메소드에 새로 정의하고 기존 기능이 그대로 필요한 부분은 데코레이터의 메소드가 기존클래스의 메소드에게
//요청을 전달한다.


class DelegatingCollection<T> : Collection<T>{
    private val innerList = arrayListOf<T>()

    override val size : Int   = innerList.size

    override fun isEmpty() : Boolean =innerList.isEmpty()

    override fun contains(element : T) : Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements : Collection<T>) : Boolean = innerList.containsAll(elements)
}

class DelegatingCollection2<T>(
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList


//list 4.22 클래스 위임 사용하기
class CountingSet<T>( val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet{
    //MutableCollection의 구현을 innerSet에게 위임한다
    var objectsAdded = 0
    // 아래 두 메소드는 위임하지 않고 새로운 구현을 제공한다.
    override fun add(element : T) : Boolean{
        objectsAdded ++
        return  innerSet.add(element)
    }

    override fun addAll(elements : Collection<T>) : Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }

}

fun main(args : Array<String>){
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}