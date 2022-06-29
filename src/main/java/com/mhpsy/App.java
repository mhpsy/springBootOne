package com.mhpsy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication内部包含很多个注解其中就有@ComponentScan
 * 默认的扫包范围就是当前启动类同级包或者子包下面
 *
 * @ComponentScan(
 *     excludeFilters = {@Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {TypeExcludeFilter.class}
 * )
 */
@SpringBootApplication
@MapperScan("com.mhpsy.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
