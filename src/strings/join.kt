package strings

import java.lang.StringBuilder

fun<T> joinToString3(
    collection: Collection<T>,
    separator: String = "| ",  //디폴트값이 지정된 파라미터들
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ( (index, element) in collection.withIndex()){
        if( index > 0 ) result.append(separator)  //첫원소앞에는 구분자를 넣으면 안되요
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/* java */
//package strings;;
//public class JoinKt{
    //public static String joinToString(){}
//}

//static 메소드라 호출하기쉽다.
//JoinKt.joinToString()....