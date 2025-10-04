package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserDto userDto = (UserDto) req.getAttribute("userDto");

        req.setAttribute("name", userDto.getName());
        req.setAttribute("lastname", userDto.getLastName());
        req.setAttribute("login", userDto.getLogin());

        req.getRequestDispatcher("main.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserDto userDto = (UserDto) req.getAttribute("userDto");

        req.setAttribute("name", userDto.getName());
        req.setAttribute("lastname", userDto.getLastName());
        req.setAttribute("login", userDto.getLogin());

        System.out.print(userDto.getLastName());
        req.getRequestDispatcher("main.ftl").forward(req, resp);

    }
}
