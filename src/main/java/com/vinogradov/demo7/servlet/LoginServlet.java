package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.dto.UserLoginDto;
import com.vinogradov.demo7.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    LoginService loginService;

    @Override
    public void init(){
        loginService = (LoginService) getServletContext().getAttribute("loginService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserLoginDto userLoginDto = new UserLoginDto(login, password);

        UserDto userDto = loginService.getUserByLoginAndPassword(userLoginDto);

        if (userDto == null) {
            resp.sendRedirect("login");
        }
        else {
            req.setAttribute("userDto", userDto);
            req.getRequestDispatcher("main").forward(req, resp);
        }
    }
}
