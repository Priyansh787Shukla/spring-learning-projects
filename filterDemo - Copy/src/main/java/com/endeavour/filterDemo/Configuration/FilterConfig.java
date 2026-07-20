package com.endeavour.filterDemo.Configuration;

import com.endeavour.filterDemo.filter.ResponseHeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**@Configuration
public class FilterConfig
{
    @Bean
    public FilterRegistrationBean<ResponseHeaderFilter> getBean()
    {
        FilterRegistrationBean<ResponseHeaderFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new ResponseHeaderFilter());
        bean.addUrlPatterns("/api/*");
        return bean;
    }
}*/
