<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>헌혈 증서 조회</title>
</head>
<body>
    <h2>헌혈 증서 조회</h2>
    <form action="donationSearch" method="post">
        <label for="certificateNumber">헌혈 증서 번호:</label>
        <input type="text" id="certificateNumber" name="certificateNumber" required>
        <input type="submit" value="조회">
    </form>
    
    <c:if test="${not empty donation}">
        <h3>헌혈 정보</h3>
        <p>증서 번호: ${donation.certificateNumber}</p>
        <p>헌혈 날짜: ${donation.donationDate}</p>
        <p>헌혈 유형: ${donation.donationType}</p>
        <p>헌혈량: ${donation.bloodAmount}ml</p>
        
        <c:if test="${not empty recipient}">
            <h3>수혜자 정보</h3>
            <p>수혜자 이름: ${recipient.name}</p>
            <p>수혈 날짜: ${recipient.receivedDate}</p>
        </c:if>
    </c:if>
    
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    
    <br>
    <a href="index.jsp">메인 페이지로 돌아가기</a>
</body>
</html>
