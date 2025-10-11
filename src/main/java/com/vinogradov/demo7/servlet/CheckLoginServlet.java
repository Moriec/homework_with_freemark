package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.service.CheckLoginService;
import com.vinogradov.demo7.service.impl.CheckLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/check-login")
public class CheckLoginServlet extends HttpServlet {

    CheckLoginService checkLoginService;

    @Override
    public void init() throws ServletException {
        checkLoginService = (CheckLoginService)getServletContext().getAttribute("checkLoginService");
    }

    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");

        if(!checkLoginService.checkLogin(login)){
            resp.setContentType("text/plain");
            resp.getWriter().write("Логин из авиабле");
        }
        else {
            resp.setContentType("text/plain");
            resp.getWriter().write("Логин алреду экзизт");
        }
    }
}
