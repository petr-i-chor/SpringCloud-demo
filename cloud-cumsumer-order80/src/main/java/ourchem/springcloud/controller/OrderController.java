package ourchem.springcloud.controller;

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

    private static final String PAYMENY_URL = "http://localhost:8089";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/add")
    public Result<Payment> add(Payment payment){

        return restTemplate.postForObject(PAYMENY_URL+"/payment",payment,Result.class);
    }

    @GetMapping("/payment/delete/{id}")
    public Result<Payment> delete(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENY_URL+"/payment/"+id,Result.class);

    }

    @GetMapping("/payment/getInfo/{id}")
    public Result<Payment> getInfo(@PathVariable Long id){

        return restTemplate.getForObject(PAYMENY_URL+"/payment/"+id,Result.class);
    }

}
