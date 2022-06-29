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

## 日志 
一般情况下要手动添加日志
```java
private static Logger log =Logger.getLogger(User.class);
```
但是lombok中的`@Slf4j`注解可以自动生成一个这个日志对象
lombok是编译的时候才会生成getset方法
1. 使用log4j
2. 使用aop或者elk统一输出配置文件



## 配置文件
1. application.yml
2. bootstrap.yml

说明：bootstrap是优先加载的,应用于更加早期配置信息的读取。可以理解成系统界
别的一些参数配置
这些参数一般是不会变动的。一般bootstrap.yml被加载，则内容不会被覆盖
application.yml是用来定义应用级别的，应用程序特有的配置信息，用来配置后续
各个模块中所需要的公共参数等。
---
### 配置文件增加便利
类中使用配置文件：
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
接下来就可以在xml中点到类中使用的变量那里去了

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mhpsy")
//批量的读取xml文件赋值给同名的元素
```
### 占位符
在application.yml配置文件内可以直接使用占位符来进行配置的相互引用，如下所示：
```java
system:
    name: ${spring.application.name}
spring:
    application:
        name: project-sample
```
在上面的配置中，name配置直接引用了spring.application.name的配置值，
这样我们在系统中通过`@Value("${name}")`或者通过`@ConfigurationProperties`
方式使用时，得到的值都为project-sample。

```java
// @Value方式
@Value("${system.name}")
private String name;
```

```java
// @ConfigurationProperties方式
@Data
@Configuration
@ConfigurationProperties(prefix = "system")
static class LoadConfig {
    private String name;
```

这样方式极大地减少了相同的配置出现，
让我们在配置文件中也可以实现类似于常量的定义。

[具体可以参考此链接](https://juejin.cn/post/6844904100404936718)

> 对于配置的注入还是推荐使用`@ConfigurationProperties`，
> 完全遵循`OOP`设计方式，在应用程序启动时进行赋值，
> 就算是引用的配置为`NULL`没有默认值，也不会出现启动异常的问题。

spring boot中还有提供一些其他的占位符比如随机值之类的

## 定时任务
Spring Boot 默认已经实现了定时任务，只需要添加相应的注解即可完成。

### pom.xml 文件配置

pom.xml 不需要添加其他依赖，只需要加入 
Spring Boot 依赖即可，这里添加一个 `web` 和 `test`的依赖：

在启动类上面加上 `@EnableScheduling`注解即可开启定时任务

编写定时任务：

除了这些还支持 cron 表达式：

启动 Spring Boot 项目在控制台就会看到任务定时执行。

### Cron表达式

Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域。每一个域代表一个含义

`corn从左到右(用空格隔开)：秒 分 小时 月份中的日期 月份 星期中的日期 年份`

[cron 表达式在线生成工具](https://qqe2.com/cron)

## 异步

- mq异步

## 捕获错误
也就是如果遇到错误就返回对用户友好的一个页面