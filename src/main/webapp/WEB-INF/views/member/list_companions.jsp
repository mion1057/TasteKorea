<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>가이드 목록</h3>
<c:forEach var="member" items="${memberPage.content}">
${member.name }(${member.alias })<br><c:url value=""></c:url>
<img alt="" src='<c:url value="/resource/companion/profie/${member.profileImage }"/>'  width="100"><br>
</c:forEach>
</body>
</html>