package com.jeckchen.eamis.view;

import com.jeckchen.eamis.common.SpringContextUtils;

import java.awt.*;

/**
 * @author chenj
 * @version 1.0.0
 * @className Start.java
 * @description jc
 * @date 2022年06月08日 14:44
 */
public class Start {
    public static void run() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取LoginPage界面实例并显示
                    SpringContextUtils.getBean(Login.class).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
