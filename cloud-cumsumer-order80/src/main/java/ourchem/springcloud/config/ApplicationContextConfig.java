package ourchem.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启负载轮询(同一个服务名集群了多个服务，服务名相同，通过服务名调用接口会不知道找哪个服务，开启服务轮询可以解决这个问题)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
