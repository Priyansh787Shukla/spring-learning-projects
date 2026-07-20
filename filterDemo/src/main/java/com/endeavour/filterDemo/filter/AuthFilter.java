package com.endeavour.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String token = req.getHeader("token");
        String apiKey = req.getHeader("api-key");
        if(token==null || !token.equals("12345"))
        {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //more readable(401=unauthorized), can also write--> resp.setStatus(401);
            return;
        }
        if(apiKey==null || !apiKey.equals("secret123"))
        {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.setContentType("application/json");
            resp.getWriter().write("{\n\t\"message\" : \"Invalid/Missing API Key\"\n}");
            return;
        }

        chain.doFilter(request, response);
    }
}
