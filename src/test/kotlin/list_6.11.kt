import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MyService2{
    fun performAction() : String = "foo"
}
class MyTest2{
    private lateinit var myService : MyService //초기화하기않고 널이 될수 없는 프로퍼티를 선언한다.
    @Before
    fun setUp(){
        myService = MyService()  //setup메소드안에서 진짜 초깃값을 지정한다.
    }
    @Test
    fun testAction(){
        Assert.assertEquals("foo", myService.performAction()) // 널검사를 수행하지 않고 프로퍼티를 사용한다.
    }


}