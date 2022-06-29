# springBootOne
## 建造项目

这个parent标签要写在pom.xml文件上面一些的地方

```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.0.RELEASE</version>
  </parent>
```

* spring-boot-starter-parent内部就默认包含了SpringMVC框架
* SpringBoot是通过整合Maven依赖的方式来实现的
* controller和service的区别就是如果只是服务就是service，controller应该是有一个视图层

---

## 注解

关于[注解](https://www.hxstrive.com/subject/spring_boot.htm?id=336#:~:text=%40EnableAutoConfiguration%20%E6%B3%A8%E8%A7%A3%E8%A1%A8%E7%A4%BA%E5%BC%80%E5%90%AF%E8%87%AA%E5%8A%A8,%E6%9D%A5%E5%BA%94%E7%94%A8%E8%87%AA%E5%8A%A8%E9%85%8D%E7%BD%AE%E7%B1%BB%E3%80%82)里面很详细的内容（基本所有的注解都有解释）

---

## YML

## 分层

1. com.mhpsy.controlloer-->视图层
2. com.mhpsy.service-->业务逻辑层
3. com.mhpsy.dao-->数据库访问层

## 模板引擎

* [Thymeleaf简介](https://www.cainiaojc.com/springboot/springboot-thymeleaf-view.html)和[具体使用](http://c.biancheng.net/spring_boot/thymeleaf.html)
* [FreeMarker](https://freemarker.apache.org/docs/ref_directive_if.html)
* Velocity
* Groovy
* Mustache

## JDBC Template
配置datasource
```
  datasource:
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver
```
## 整合mybatis
1. 跟jdbcTemplate一样也要配置datasource 
2. 使用注解的操作数据库
