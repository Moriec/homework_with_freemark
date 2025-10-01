package com.vinogradov.demo7.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "begin", urlPatterns = "/")
public class BeginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.ftl").forward(req, resp);
    }
}
