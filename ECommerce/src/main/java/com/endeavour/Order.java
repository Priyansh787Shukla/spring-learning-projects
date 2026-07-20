package com.endeavour;

import com.endeavour.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Order
{
    PaymentService payment;

    public Order(@Qualifier("UPI") PaymentService payment)
    {
        this.payment = payment;
    }

    void makeOrder()
    {
        System.out.println("Order Placed");
        payment.pay();
    }
}
