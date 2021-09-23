package ourchem.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ourchem.springcloud.dao.PaymentDao;
import ourchem.springcloud.domain.Payment;
import ourchem.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public int deletePayment(Long id) {
        return paymentDao.deletePayment(id);
    }

    @Override
    public Payment selectPayment(Long id) {
        return paymentDao.selectPayment(id);
    }
}
