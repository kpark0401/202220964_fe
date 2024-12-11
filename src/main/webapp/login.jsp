<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kku.cs.wp.wsd.dao.UserDAO" %>
<%@ page import="kr.ac.kku.cs.wp.wsd.model.User" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="login.jsp" method="post">
        <label for="username">사용자명:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="로그인">
    </form>
    <p style="color: red;">${error}</p>
    <p>계정이 없으신가요? <a href="register.jsp">회원가입</a></p>

    <%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            UserDAO userDAO = new UserDAO();
            try {
                User user = userDAO.getUserByUsername(username);
                if (user != null && user.getPassword().equals(password)) {
                    session.setAttribute("user", user);
                    response.sendRedirect("index.jsp");
                    return;
                } else {
                    request.setAttribute("error", "잘못된 사용자명 또는 비밀번호입니다.");
                }
            } catch (SQLException e) {
                request.setAttribute("error", "데이터베이스 오류가 발생했습니다.");
                e.printStackTrace();
            }
        }
    }
    %>
</body>
</html>
