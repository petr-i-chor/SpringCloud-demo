package ourchem.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ourchem.springcloud.domain.Payment;

@Mapper
public interface PaymentDao {

    public int addPayment(Payment payment);

    public int deletePayment(@Param("id") Long id);

    public Payment selectPayment(@Param("id") Long id);
}
