<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tasteKorea</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/welcome_member.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>

</head>
<body>
	<header id="header">
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div id="content_wrap">
				<div id="content">
					<h1>
						taste<span>Korea</span>
					</h1>
					<h2>Welcome</h2>
					<div id="text_box">
						<h2>${tasteMember.fisrtName }<span>${tasteMember.lastName }</span>님환영합니다.</h2>
						<h2>즐거운 여행 되세요!</h2>
						<a href="/member/traveler/login">로그인</a> <a href="/">홈으로</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
</body>
</html>