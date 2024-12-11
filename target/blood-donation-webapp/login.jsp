<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="login" method="post">
        <label for="username">사용자명:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="로그인">
    </form>
    <p>${error}</p>
    <p>계정이 없으신가요? <a href="register.jsp">회원가입</a></p>
</body>
</html>
