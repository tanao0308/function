package com.shicaolong.function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
1. @SpringBootConfiguration
	@SpringBootConfiguration 是 @Configuration 的一个特殊形式。它表示一个配置类，等价于基于XML的配置文件。
2. @EnableAutoConfiguration
	@EnableAutoConfiguration 告诉Spring Boot根据类路径中的jar依赖项，为应用程序添加适当的自动配置。
	它会根据项目中存在的依赖自动配置Spring应用上下文。例如，如果你有spring-boot-starter-web在类路径中，它会自动配置一个Spring MVC应用。
3. @ComponentScan
	@ComponentScan 告诉Spring在当前包及其子包中查找组件、配置和服务。这样可以发现并注册被@Component, @Service, @Repository, @Controller等注解标注的类。
 */
@SpringBootApplication
//@ComponentScan("com.shicaolong.function")
public class FunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionApplication.class, args);
	}

}
