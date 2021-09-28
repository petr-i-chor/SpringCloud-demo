package ourchem.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.service.PaymentService;
import ourchem.springcloud.utils.Result;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping()
    public Result<Payment> add(@RequestBody Payment payment) {
        int i = paymentService.addPayment(payment);
        log.info(payment.toString());
        if (i>0){
            return new Result<Payment>(200,"添加成功,serverPort:  "+serverPort);
        }else {
            return new Result<Payment>(500,"添加失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<Payment> remove(@PathVariable(value = "id") Long id){
        int i = paymentService.deletePayment(id);
        if (i>0){
            return new Result<Payment>(200,"删除成功");
        }else {
            return new Result<Payment>(500,"删除失败");
        }
    }

    @GetMapping("/{id}")
    public Result<Payment> getInfo(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.selectPayment(id);
        if (payment!=null){
            return new Result<Payment>(200,"操作成功，serverPort: "+serverPort,payment);
        }else {
            return new Result<Payment>(500,"操作失败");
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("server_name:  "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance: instances) {
            log.info("Host:"+instance.getHost()+"\t"+"Port:"+instance.getPort()+"\t"+"Uri:"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }



}
