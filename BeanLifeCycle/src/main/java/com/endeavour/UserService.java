package com.endeavour;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component("myPolo") // This is the name of the bean
public class UserService implements BeanNameAware //One of the Aware interfaces
{
    public UserService()
    {
        System.out.println("User Service Created...");
    }

    @Override
    public void setBeanName(String name) // This method is called by the IoC container
    {
        System.out.println("Bean Name: "+name);
    }
}
