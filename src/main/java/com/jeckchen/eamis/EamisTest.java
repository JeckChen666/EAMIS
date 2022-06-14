package com.jeckchen.eamis;

import com.jeckchen.eamis.view.Start;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jeckchen.eamis.common","com.jeckchen.eamis.entity","com.jeckchen.eamis.mapper","com.jeckchen.eamis.mapper.xml","com.jeckchen.eamis.service"})
public class EamisTest {

    public static void main(String[] args) {
        SpringApplication.run(EamisTest.class, args);
//        Start.run();
        // 如果报java.awt.HeadlessException，请在VM options中追加 -Djava.awt.headless=false
        // https://blog.csdn.net/yhj_911/article/details/104097594
    }

}
