package com.endeavour;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
//        OrderService o1 = ioc.getBean(OrderService.class);
//        o1.placeOrder();
    }
}