package ourchem.springcloud.service;

import ourchem.springcloud.domain.Payment;



public interface PaymentService {

    public int addPayment(Payment payment);

    public int deletePayment(Long id);

    public Payment selectPayment(Long id);
}
