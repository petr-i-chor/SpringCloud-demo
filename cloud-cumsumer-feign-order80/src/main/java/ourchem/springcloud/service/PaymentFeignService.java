package ourchem.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.utils.Result;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    Result<Payment> getInfo(@PathVariable(value = "id") Long id);
}
