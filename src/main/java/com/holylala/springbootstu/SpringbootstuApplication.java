package com.holylala.springbootstu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan(basePackages = {"com.holylala.springbootstu"})
//有多少个配置文件就写多少个
@PropertySource(value= {"classpath:jdbc.properties","classpath:application.properties"}
        , name="prop"
        , encoding="utf-8"
        ,ignoreResourceNotFound=true)
public class SpringbootstuApplication {

    /**
     *  @ComponentScan(basePackages = {"com.holylala.springbootstu"},excludeFilters = {@ComponentScan.Filter(classes = Service.class)})
     *  lazyInit = true 可把bean配置成延迟加载
     *  除了Service注解的类 都依赖注入
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootstuApplication.class, args);
    }

}
