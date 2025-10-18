package com.vinogradov.demo7.servlet;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.dto.UserRegistrationDto;
import com.vinogradov.demo7.service.SignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;

    private static final String FILE_PREFIX_FULL = "C:/Users/UserHome/IdeaProjects/demo7/src/main/webapp/images";
    private static final String FILE_PREFIX = "/images";
    private static final int DIRECTORIES_COUNT = 100;

    @Override
    public void init(){
        signUpService = (SignUpService) getServletContext().getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("sign_up.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastname");
        Part part = req.getPart("file");

        // Проверяем, что данные не пустые
        if (login != null && password != null && !login.trim().isEmpty() && !password.trim().isEmpty()) {
            String fileParth = savePhoto(part);

            UserRegistrationDto userRegistrationDto = new UserRegistrationDto(name, lastName, login, password, fileParth);
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

    private String savePhoto(Part part) throws IOException {
        if (part != null) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String filePathFull = FILE_PREFIX_FULL + "/" + Math.abs(fileName.hashCode() % DIRECTORIES_COUNT) + "/" + fileName;
            String filePath = FILE_PREFIX + "/" + Math.abs(fileName.hashCode() % DIRECTORIES_COUNT) + "/" + fileName;
            File file = new File(filePathFull);

            InputStream content = part.getInputStream();
            file.getParentFile().mkdirs();
            file.createNewFile();
            try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[content.available()];
                content.read(buffer);
                fileOutputStream.write(buffer);
            }
            return filePath;
        }
        else {
            return null;
        }
    }
}
