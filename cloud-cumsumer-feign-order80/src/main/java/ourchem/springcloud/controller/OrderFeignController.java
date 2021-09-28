package ourchem.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.service.OrderFeignService;
import ourchem.springcloud.utils.Result;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/comsumer")
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;


    @GetMapping("/payment/getInfo/{id}")
    public Result<Payment> getInfo(@PathVariable Long id){

        return orderFeignService.getInfo(id);
    }

    @GetMapping("payment/feign/timeout")
    public String timeout(){
        return orderFeignService.timeout();
    }



}
