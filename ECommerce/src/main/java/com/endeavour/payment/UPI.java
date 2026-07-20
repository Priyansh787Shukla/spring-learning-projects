package com.endeavour.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class UPI implements PaymentService
{
    @Override
    public void pay()
    {
        System.out.println("Payment Done via UPI");
    }
}
