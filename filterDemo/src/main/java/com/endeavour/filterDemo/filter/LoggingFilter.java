package com.endeavour.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
//        System.out.println("Request Entered in Logging Filter");
//        chain.doFilter(request, response);
//        System.out.println("Request Exited from Logging Filter");

        long startTime = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String reqId = UUID.randomUUID().toString(); //unique request ID for each API call for log records
        resp.setHeader("Request-ID", reqId);

        //Request Log
        System.out.println("Incoming Request: "+req.getMethod()+" "+req.getRequestURI());

        try
        {
            chain.doFilter(request, response);
        }
        finally
        {
            long duration = System.currentTimeMillis() - startTime;

            //Response Status Log
            System.out.println("Response Status: "+resp.getStatus());

            System.out.println("Response Time or Request Duration: "+duration+"ms");
        }
    }
}
