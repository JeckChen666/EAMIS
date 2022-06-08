package com.jeckchen.eamis;

import com.jeckchen.eamis.View.Start;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jeckchen"})
public class EamisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamisApplication.class, args);
        Start.run();
        // 如果报java.awt.HeadlessException，请在VM options中追加 -Djava.awt.headless=false
        // https://blog.csdn.net/yhj_911/article/details/104097594
    }

}
