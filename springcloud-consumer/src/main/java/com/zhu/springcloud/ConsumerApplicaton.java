package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.zhu.springcloud",exclude= {DataSourceAutoConfiguration.class}) //,exclude= {DataSourceAutoConfiguration.class}
public class ConsumerApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicaton.class,args);
    }

}
