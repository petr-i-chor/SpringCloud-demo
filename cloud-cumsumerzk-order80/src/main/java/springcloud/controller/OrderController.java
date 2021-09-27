package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.utils.Result;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/cumsumer")
public class OrderController {

    private static final String INVOKE_URL = "http://localhost:8003";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String getInfo(){

        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }

}
