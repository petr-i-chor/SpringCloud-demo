package ourchem.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.service.PaymentService;
import ourchem.springcloud.utils.Result;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ourchem")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment")
    public Result<Payment> payment(@RequestBody Payment payment) {
        int i = paymentService.addPayment(payment);
        if (i>0){
            return new Result<Payment>(200,"添加成功");
        }else {
            return new Result<Payment>(500,"添加失败");
        }
    }

    @DeleteMapping("/payment/{id}")
    public Result<Payment> payment(@PathVariable(value = "id") Long id){
        int i = paymentService.deletePayment(id);
        if (i>0){
            return new Result<Payment>(200,"删除成功");
        }else {
            return new Result<Payment>(500,"删除失败");
        }
    }

    @GetMapping("/payment/{id}")
    public Result<Payment> payment(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.selectPayment(id);
        if (payment!=null){
            return new Result<Payment>(payment,"删除成功",200);
        }else {
            return new Result<Payment>(500,"删除失败");
        }
    }
}
