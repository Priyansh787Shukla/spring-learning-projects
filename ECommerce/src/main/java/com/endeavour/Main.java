package com.endeavour;

import com.shop.Addtocart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        User user = ioc.getBean(User.class);
        user.show();
        Addtocart cart = ioc.getBean(Addtocart.class);
        cart.show();
        Order order =  ioc.getBean(Order.class);
        order.makeOrder();
    }
}