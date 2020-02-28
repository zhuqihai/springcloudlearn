package com.zhu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */

@RestController
public class EurekaDiscoveryURL {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/descovery")
    public Object discovery(){
        List <String> services=client.getServices();
        for(String service:services){
            System.out.println("--------"+services);
            List<ServiceInstance> instances= client.getInstances(service);
            for(ServiceInstance instance:instances){
                System.out.println(
                        instance.getHost()+"\t"+
                        instance.getPort()+"\t"+
                        instance.getUri()+"\t"+
                        instance.getServiceId()
                );

            }
        }
        return this.client;
    }
}
