package com.pm05.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.sql.DataSource;

@WebServlet("/EmailServlet")
@MultipartConfig
public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");
        Part attachmentPart = request.getPart("attachment");

        String username = "hoanghuy220903@gmail.com";
        String password = "darc oqem nszz lkwa";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(messageText);

            if (attachmentPart != null) {
                String fileName = attachmentPart.getSubmittedFileName();
                ByteArrayDataSource dataSource = new ByteArrayDataSource(attachmentPart.getInputStream(), attachmentPart.getContentType());
                message.setDataHandler(new DataHandler(dataSource));
                message.setFileName(fileName);
            }

            Transport.send(message);

            response.getWriter().println("success!");
        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("fail!");
        }
    }
}
