package ourchem.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8089 {

    public static void main(String [] args){
        SpringApplication.run(PaymentMain8089.class,args);
    }
}
