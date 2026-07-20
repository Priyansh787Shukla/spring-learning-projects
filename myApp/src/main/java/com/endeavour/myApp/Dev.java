package com.endeavour.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev
{
    @Autowired// field-injection
    @Qualifier("desktop")
    private Computer lpt;
    public void build()
    {
        lpt.compile();
        System.out.println("Working on Some Awesome Project...!");
    }
}
