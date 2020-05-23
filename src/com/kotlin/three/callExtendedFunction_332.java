package com.kotlin.three;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import strings.JoinKt;

// 3.3.2  자바에서 확장함수 호출
public class callExtendedFunction_332 {
    static char c = JoinKt.lastChar("Java");

    public static void main(String[] args) {
        System.out.println(c);
    }
}
