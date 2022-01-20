<<<<<<< HEAD
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
	href="<c:url value='/resources/css/signup_companion.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />	
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
			<form:form method="post" modelAttribute="memberCommand">
				<form:input path="guide" style="display: none;" value="false" />
				<div id="content_wrap">
					<div id="content">
						<!-- 이메일 & 패스워드 -->
						<div id="first_box">
							<h3>Email</h3>
							<form:input path="email" autocomplete="off" required="required" />
							<span class="errorTxt"></span>
							<h3>Password</h3>
							<form:password path="passwd" minlength="8" maxlenth="14"
								placeholder="8 to 14 characters" required="required" />
						</div>
						<!-- 개인정보 -->
						<div id="second_box">
							<h3>First name</h3>
							<form:input path="firstName" autocomplete="off"
								required="required" />
							<h3>Last name</h3>
							<form:input path="lastName" autocomplete="off"
								required="required" />
							<h3>Sex</h3>
							<form:select path="sex">
								<option value="m">male</option>
								<option value="f">female</option>
							</form:select>
							<h3>Region</h3>
							<form:select path="region">
								<option value="0">------</option>
								<form:options items="${regionList}" itemLabel="eng" itemValue="regionId"/>
							</form:select>
							<button id="submit_btn">Submit</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
</body>
=======
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
	href="<c:url value='/resources/css/signup_companion.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />	
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
			<form:form method="post" modelAttribute="memberCommand">
				<form:input path="guide" style="display=none;" value="false" />
				<div id="content_wrap">
					<div id="content">
						<!-- 이메일 & 패스워드 -->
						<div id="first_box">
							<h3>Email</h3>
							<form:input path="email" autocomplete="off" required="required" />
							<span class="errorTxt"></span>
							<h3>Password</h3>
							<form:password path="passwd" minlength="8" maxlenth="14"
								placeholder="8 to 14 characters" required="required" />
						</div>
						<!-- 개인정보 -->
						<div id="second_box">
							<h3>First name</h3>
							<form:input path="firstName" autocomplete="off"
								required="required" />
							<h3>Last name</h3>
							<form:input path="lastName" autocomplete="off"
								required="required" />
							<h3>Sex</h3>
							<form:select path="sex">
								<option value="m">male</option>
								<option value="f">female</option>
							</form:select>
							<h3>Region</h3>
							<form:select path="region">
								<option value="0">------</option>
								<form:options items="${regionList}" />
							</form:select>
							<button id="submit_btn">Submit</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
</body>
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
</html>