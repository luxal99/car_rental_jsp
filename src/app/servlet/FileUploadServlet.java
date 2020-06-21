package app.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUploadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //get the file chosen by the user
        Part filePart = request.getPart("fileToUpload");

        //get the InputStream to store the file somewhere
        InputStream fileInputStream = filePart.getInputStream();

        File fileToSave = new File("/home/" + filePart.getSubmittedFileName());
        Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);

        //get the URL of the uploaded file
        String fileUrl = "http://localhost:8080/home/assets/img/" + filePart.getSubmittedFileName();

        response.sendRedirect(request.getContextPath());

    }
}
