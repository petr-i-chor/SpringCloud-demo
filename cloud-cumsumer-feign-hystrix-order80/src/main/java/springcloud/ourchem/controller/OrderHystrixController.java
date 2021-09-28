package springcloud.ourchem.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.ourchem.service.OrderHystrixService;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/comsumer")
@DefaultProperties(defaultFallback ="payment_global_fallback" )
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;
    
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")/*
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int age = 10/0;
        String result = orderHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    /*
    代码膨胀，
    添加全局服务降级
    @DefaultProperties(defaultFallback ="payment_global_fallback" )
    （全局fallback）+自定义,减少代码膨胀
     */
    public String payment_global_fallback(){
        return "global全局异常，请稍后再试";
    }

}
