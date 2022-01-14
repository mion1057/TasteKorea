<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/signup_companion.css'/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
<script src="<c:url value='/resources/js/traveler_check_email.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<section>
		<!-- 중앙에 모아질 회원가입 틀 -->
		<div id="container">
			<form:form method="post" 
            modelAttribute="travelerCommand"> 
			<div id="content_wrap">
				<div id="content">
					<!-- 이메일 & 패스워드 -->
					<div id="first_box">
						<h3>이메일</h3>
						<form:input path="email" autocomplete="off" required="required"/>
						<span class="errorTxt"></span>
						<h3>패스워드</h3>
						<form:password path="passwd" minlength="8" maxlenth="14"
						placeholder="8~14자리" required="required" />
					</div>
					<!-- 개인정보 -->
					<div id="second_box">
						<h3>이름</h3>
						<form:input path="name" minlength="2" autocomplete="off" required="required"/>
						<button id="submit_btn">등록</button>
					</div>
				</div>
			</div>
			</form:form>
		</div>
	</section>
	<footer> </footer>

</body>
</html>