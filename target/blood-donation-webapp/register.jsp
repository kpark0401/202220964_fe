<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="register" method="post">
        <label for="username">사용자명:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="birthdate">생년월일:</label>
        <input type="date" id="birthdate" name="birthdate" required><br><br>
        
        <label for="gender">성별:</label>
        <select id="gender" name="gender" required>
            <option value="남">남</option>
            <option value="여">여</option>
        </select><br><br>
        
        <input type="submit" value="가입하기">
    </form>
    <p>이미 계정이 있으신가요? <a href="login.jsp">로그인</a></p>
</body>
</html>
