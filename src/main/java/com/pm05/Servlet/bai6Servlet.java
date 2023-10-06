package com.pm05.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/bai6Servlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 10 MB
public class bai6Servlet extends HttpServlet {

    private static final String SQL_INSERT_FILE = "INSERT INTO bai6_uploadfiles (name,size,content) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Part> parts = request.getParts().stream().collect(Collectors.toList());
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/upload_files", "root", "huy22092003");
            statement = connection.prepareStatement(SQL_INSERT_FILE);
        } catch (SQLException | ClassNotFoundException e) {
            out.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            return;
        }
         // Tải lên từng tệp
         for (Part part : parts) {
            // Lấy tên tệp
            String fileName = part.getName();

            // Lấy kích thước tệp
            long fileSize = part.getSize();

            // Lấy nội dung tệp
            InputStream inputStream = part.getInputStream();
            byte[] bytes = new byte[(int) fileSize];
            inputStream.read(bytes);

            // Thêm tệp vào cơ sở dữ liệu
            try{
            statement.setString(1, fileName);
            statement.setLong(2, fileSize);
            statement.setBytes(3, bytes);
            statement.executeUpdate();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        // Trả về thông báo thành công
        out.println("Tải lên thành công!");
    }

}
