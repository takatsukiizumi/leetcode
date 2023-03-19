package redis.redission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */

@Slf4j
@SpringBootApplication
@EnableScheduling
@ComponentScan({"redis.*"})
public class ApplicationStart extends SpringBootServletInitializer {
    //声明一个protected方法，方法名为configure，返回类型为SpringApplicationBuilder。
    //方法中有一个参数SpringApplicationBuilder，该参数表示当前应用程序的构建器。
    //在方法体中，调用了参数application的sources方法，将当前应用程序类ApplicationStart作为参数传递。
    //最终返回一个SpringApplicationBuilder对象，用于构建Spring Boot应用程序。
    //此方法的作用是为Spring Boot应用程序配置源。在Web应用程序中，它将设置一个配置类，以便Spring能够扫描和加载相关的组件。
    // 此外，该方法还可以配置应用程序的请求、响应、拦截器等。
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStart.class);
    }
    public static void main(String[] args)  {
        //这段代码是一个 Spring Boot 应用程序的入口。它通过调用 SpringApplication 类的静态方法 run() 来启动应用程序，传入当前的类 ApplicationStart.class 和命令行参数 args 。
        // 它返回一个 ConfigurableApplicationContext 对象，可以用来访问应用程序的上下文信息并进行配置。
        //SpringApplication 类会自动配置应用程序，包括加载默认属性、扫描类路径下的 @Component 注解的类、注册 ApplicationContextInitializer 和 ApplicationListener 等。
        // 如果需要增加或修改默认配置，可以通过传入一个 SpringApplication 对象来进行自定义配置，该对象可以调用 set 方法来设置不同的属性。
        ConfigurableApplicationContext application = SpringApplication.run(ApplicationStart.class, args);
        System.out.println("******************启动成功********************");

    }
}
