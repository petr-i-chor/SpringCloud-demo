package ourchem.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.service.PaymentService;
import ourchem.springcloud.utils.Result;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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
            return new Result<Payment>(200,"操作成功,serverPort:"+serverPort,payment);
        }else {
            return new Result<Payment>(500,"操作失败");
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
