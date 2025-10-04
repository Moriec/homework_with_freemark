package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.dto.UserRegistrationDto;
import com.vinogradov.demo7.service.SignUpService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;

    @Override
    public void init(){
        signUpService = (SignUpService) getServletContext().getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("sign_up.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastname");

        // Проверяем, что данные не пустые
        if (login != null && password != null && !login.trim().isEmpty() && !password.trim().isEmpty()) {
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto(name, lastName, login, password);
            boolean isRegistration = signUpService.signUp(userRegistrationDto);
            if(isRegistration){
                resp.sendRedirect("/login");
            }
             else {
                // Пользователь уже существует
                resp.sendRedirect("/sign_up");
            }
        } else {
            // Неверные данные
            resp.sendRedirect("/sign_up");
        }
    }
}
