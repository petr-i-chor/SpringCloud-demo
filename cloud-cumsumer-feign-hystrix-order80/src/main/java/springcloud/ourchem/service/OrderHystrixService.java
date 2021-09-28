package springcloud.ourchem.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.ourchem.service.impl.OrderFallbackService;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = OrderFallbackService.class) //客户端去调用服务端，碰上服务端宕机或关闭，
                                                                                            // 降级处理由客户端提供
public interface OrderHystrixService {


    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable(value = "id") Integer id);

    //失败
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id);


}
