package com.jeckchen.eamis;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author chenj
 * @version 1.0.0
 * @className CommonTest.java
 * @description jc
 * @date 2022年06月13日 17:58
 */
public class CommonTest {
    @Test
    public void testTime(){
        Date beginOfDay = DateUtil.beginOfDay(DateUtil.date());
        Date endOfDay = DateUtil.endOfDay(DateUtil.date());
        System.out.println(beginOfDay);
        System.out.println(endOfDay);
    }
}
