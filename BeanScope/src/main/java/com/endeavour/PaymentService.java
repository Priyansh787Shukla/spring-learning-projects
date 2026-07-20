package com.endeavour;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService
{
    OrderService orderService;

    public PaymentService(@Lazy OrderService orderService)
    {
        this.orderService = orderService;
    }

    public void pay()
    {
        System.out.println("Payment Successful");
        orderService.orderDetails();
    }
}
