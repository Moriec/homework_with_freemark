package com.vinogradov.demo7.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/handle")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String uri = (String) request.getAttribute("javax.servlet.error.request_uri");

        request.setAttribute("statusCode", statusCode);
        request.setAttribute("uri", uri == null ? "" : uri);

        if(statusCode == HttpServletResponse.SC_INTERNAL_SERVER_ERROR){
            request.setAttribute("message", throwable.getMessage());
        }

        request.getRequestDispatcher("exception.ftl").forward(request, response);
    }
}
