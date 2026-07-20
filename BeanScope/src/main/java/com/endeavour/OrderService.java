package com.endeavour;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderService
{
    PaymentService paymentService;

    public OrderService(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    public void placeOrder()
    {
        paymentService.pay();
        System.out.println("Order Placed");
    }

    public void orderDetails()
    {
        System.out.println("Order Details");
    }
}
