package com.vinogradov.demo7.server;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // Устанавливаем кодировку для входящих запросов
        request.setCharacterEncoding("UTF-8");
        
        // Устанавливаем кодировку для исходящих ответов
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Передаем управление следующему фильтру или сервлету
        chain.doFilter(request, response);

    }
}
