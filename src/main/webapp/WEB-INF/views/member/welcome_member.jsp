<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/welcome_companion.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>

</head>
<body>
	<header id="header">
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<section id="container">
    <div id="container">
        <div id="content_wrap">
            <div id="content">
                <h1>taste<span>Korea</span></h1>
                <h2>Welcome</h2>
                <div id="text_box">
                    <h2>${member.firstName }</h2><h2>${member.lastName}님 환영합니다.</h2>
                    <h2>즐거운 여행 되세요!</h2>
                    <a href="/user/traveler/login">로그인</a>
                    <a href="/">홈으로</a>
                </div>
            </div>
        </div>
    </div>
	</section>
	<footer> 
	</footer>

</body>
</html>