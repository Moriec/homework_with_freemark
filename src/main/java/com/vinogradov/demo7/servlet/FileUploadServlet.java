package com.vinogradov.demo7.servlet;

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

@WebServlet("/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadServlet extends HttpServlet {

    private static final String FILE_PREFIX = "/tmp";
    private static final int DIRECTORIES_COUNT = 100;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("upload.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        if (part != null) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            File file = new File(FILE_PREFIX + File.separator +
                    (fileName.hashCode() % DIRECTORIES_COUNT) + File.separator + fileName);

            InputStream content = part.getInputStream();
            file.getParentFile().mkdirs();
            file.createNewFile();
            try(FileOutputStream  fileOutputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[content.available()];
                content.read(buffer);
                fileOutputStream.write(buffer);
            }
        }
        resp.sendRedirect("/sign_up");
    }
}
