package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.service.UserService;
import com.vinogradov.demo7.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "User", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("userService");
    }
}