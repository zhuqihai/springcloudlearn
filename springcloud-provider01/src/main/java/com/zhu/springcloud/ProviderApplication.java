package com.zhu.springcloud; /**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;


/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@MapperScan("com.zhu.springcloud.mapper")
@SpringBootApplication(scanBasePackages = "com.zhu.springcloud")
@EnableDiscoveryClient
@EnableEurekaClient //开启注册到eureka
@EnableCircuitBreaker //开启熔断支持
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }

    //添加Servlet
    @Bean
    public ServletRegistrationBean getBean(){
        ServletRegistrationBean reg=   new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        reg.addUrlMappings("/actuator/hystrix.stream");
        return reg;
    }

}
