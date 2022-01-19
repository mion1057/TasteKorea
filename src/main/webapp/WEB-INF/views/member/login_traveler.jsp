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
	href="<c:url value='/resources/css/login_traveler.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<section>
		<div id="container">
			<div id="content_wrap">
				<div id="content">
					<h1>
						taste<span>Korea</span>
					</h1>
					<h2>Traveler</h2>
					<form:form modelAttribute="travelerCommand" method="post">
						<h3>이메일</h3>
						<form:input path="email" />
						<h3>패스워드</h3>
						<form:password path="passwd" />
						<button>Log in</button>
					</form:form>
					<a href="/guide/choose_join">Sign up</a>
				</div>
			</div>
		</div>
	</section>
	<footer> </footer>

</body>
</html>