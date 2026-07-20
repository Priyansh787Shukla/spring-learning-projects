package com.endeavour;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Config.xml");
        OrderService o = ioc.getBean("bean1", OrderService.class);
        PaymentService p = ioc.getBean("paymentService", PaymentService.class);
        p.makePayment();
        o.placeOrder();
    }
}