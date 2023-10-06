<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>test</title>
    </head>
    <body>
        <form action="result.jsp" method="post">
            <h1> User Registration Form</h1>
    
            <input type="text" placeholder="First Name"><input type="text" placeholder="Last Name"><br><br>
    
            <input type="email" id="email" name="email" placeholder="Your Email" required><br><br>
    
            <input type="email" id="remail" name="remail" placeholder="Re-enter Email" required><br><br>
    
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required><br><br>
    
            <label for="month">Birthday:</label><br><br>
            
            <select id="month" name="month">
                <option value="" disabled selected hidden>Month</option>
                <% String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; %>
                <% for (int i = 0; i < months.length; i++) { %>
                    <option value="<%= (i + 1) %>"><%= months[i] %></option>
                <% } %>
            </select>
            <select name="day" id="day">
                <option value="" disabled selected hidden>Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                <% } %>
            </select>
            <select name="year" id="year">
                <option value="" disabled selected hidden>Year</option>
                <% for (int i = 1900; i <= 2030; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                <% } %>
            </select><br><br>
            
            <label>Sex:</label>
        <input type="radio" id="female" name="sex" value="female">
        <label for="female">Female</label>
        <input type="radio" id="male" name="sex" value="male">
        <label for="male">Male</label><br><br>
            <input type="submit" value="Sign Up">
        </form>    
    </body>
</html>