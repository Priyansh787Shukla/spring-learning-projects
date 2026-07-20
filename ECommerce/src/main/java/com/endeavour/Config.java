package com.endeavour;

import com.shop.Addtocart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.endeavour")
public class Config
{
    @Bean
    public User giveUser()
    {
        return new User("Priyansh", 21);
    }

    @Bean
    public Addtocart giveCart()
    {
        return new Addtocart();
    }
}
