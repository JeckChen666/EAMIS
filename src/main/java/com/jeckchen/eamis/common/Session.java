package com.jeckchen.eamis.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenj
 * @version 1.0.0
 * @className Session.java
 * @description jc
 * @date 2022年06月06日 20:33
 */
@Component
public class Session {
    //使用Map集合模拟Session缓存
    private static Map<String, Object> session = new HashMap<>();

    public static Map<String, Object> getSession(){
        return session;
    }
}
