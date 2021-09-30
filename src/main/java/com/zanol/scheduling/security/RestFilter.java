package com.zanol.scheduling.security;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


class RestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String path = ((RequestFacade) request).getServletPath();

        if (!path.equals("/api/auth/generateToken")) {

        }

        filterChain.doFilter(request, response);
    }
}