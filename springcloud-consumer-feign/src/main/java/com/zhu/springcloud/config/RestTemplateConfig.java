package com.zhu.springcloud.config;/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@Configuration
public class RestTemplateConfig {


    /*
    * 配置负载均衡实现RestTemplate
    * IRule：
    *   AvailabilityFilteringRule ： 先过滤崩溃(跳闸)的服务 访问故障服务，对剩下的进行轮询
    *   RoundRobinRule 轮询
    *   RandomRule
    *   RetryRule 先轮询服务，有服务获取失败会在指定时间重试
    *
    *
    *
    * */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule getIRule(){
        //可已自定义负载均衡规则
        return new RandomRule();
    }
}
