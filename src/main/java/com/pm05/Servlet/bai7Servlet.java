package com.pm05.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/bai7Servlet")
@MultipartConfig
public class bai7Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        Part imagePart = request.getPart("image");
        
        
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO bai7 (first_name, last_name, image) VALUES (?, ?, ?)"
            );
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            
             
            InputStream imageInputStream = imagePart.getInputStream();
            ps.setBlob(3, imageInputStream);
            
            ps.executeUpdate();
            ps.close();
            conn.close();
            
            response.getWriter().println("lưu thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("lỗi: " + e.getMessage());
        }
    }
    
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/upload_files";
        String username = "root";
        String password = "huy22092003";
        return DriverManager.getConnection(url, username, password);
    }
}
