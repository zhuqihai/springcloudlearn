package com.zhu.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.zhu.springcloud.feign.service")

@SpringBootApplication(scanBasePackages = "com.zhu.springcloud",exclude= {DataSourceAutoConfiguration.class}) //,exclude= {DataSourceAutoConfiguration.class}
public class ConsumerFeignApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplicaton.class,args);
    }

}
