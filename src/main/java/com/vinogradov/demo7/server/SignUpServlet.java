package com.vinogradov.demo7.server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {

    private static final Map<String, String> users = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("sign_up.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        // Проверяем, что данные не пустые
        if (login != null && password != null && !login.trim().isEmpty() && !password.trim().isEmpty()) {
            if (!users.containsKey(login)) {
                users.put(login, password);
                System.out.println("New user registered: " + login);

                resp.sendRedirect("/login");
            } else {
                // Пользователь уже существует
                resp.sendRedirect("/sign_up");
            }
        } else {
            // Неверные данные
            resp.sendRedirect("/sign_up");
        }
    }

    // Статический метод для получения Map с пользователями (для использования в LoginServlet)
    public static Map<String, String> getUsers() {
        return users;
    }
}
