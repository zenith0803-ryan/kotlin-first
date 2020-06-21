import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MyService{
    fun performAction() : String = "foo"
}
class MyTest{
    private var myService : MyService? = null // null로 초기화 하기위해 널이 될수 있는 타입인 프로퍼티를 선언한다.
    @Before
    fun setUp(){
        myService = MyService()  //setup메소드안에서 진짜 초깃값을 지정한다.
    }
    @Test
    fun testAction(){
        Assert.assertEquals("foo", myService!!.performAction()) //!!나 ?을 꼭 써야 한다.
    }


}