<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보</title>
</head>
<body>
    <h2>사용자 정보</h2>
    <c:if test="${not empty user}">
        <p>사용자명: ${user.username}</p>
        <p>이름: ${user.name}</p>
        <p>생년월일: ${user.birthdate}</p>
        <p>성별: ${user.gender}</p>
        <p>역할: ${user.role}</p>
        
        <h3>정보 수정</h3>
        <form action="userInfo" method="post">
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" value="${user.name}" required><br><br>
            
            <label for="birthdate">생년월일:</label>
            <input type="date" id="birthdate" name="birthdate" value="${user.birthdate}" required><br><br>
            
            <label for="gender">성별:</label>
            <select id="gender" name="gender" required>
                <option value="남" ${user.gender == '남' ? 'selected' : ''}>남</option>
                <option value="여" ${user.gender == '여' ? 'selected' : ''}>여</option>
            </select><br><br>
            
            <input type="submit" value="정보 수정">
        </form>
    </c:if>
    <c:if test="${empty user}">
        <p>로그인이 필요합니다. <a href="login.jsp">로그인 페이지로 이동</a></p>
    </c:if>
    <br>
    <a href="index.jsp">메인 페이지로 돌아가기</a>
</body>
</html>
