package com.vinogradov.demo7.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/hello")
public class JavaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello %s".formatted(System.currentTimeMillis()));
    }
}
