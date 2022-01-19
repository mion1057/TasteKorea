<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/add_companion.css'/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<!-- 중앙에 모아질 회원가입 틀 -->
		<div id="container">
			<form:form method="post" modelAttribute="companionCommand" enctype="multipart/form-data">
			<div id="content_wrap">
				<div id="content">
					<!-- 이메일 & 패스워드 -->
					<div id="first_box">wls
						<h3>이메일</h3>
						<form:input path="email" required="required"/>
						<h3>패스워드</h3>
						<form:password path="passwd" minlength="8" maxlenth="14"
						placeholder="8~14자리" required="required" />
					</div>
					<!-- 개인정보 -->
					<div id="second_box">
						<h3>이름</h3>
						<form:input path="name" minlength="2" required="required"/>
						<h3>주민등록번호 앞 6자리</h3>
						<form:input path="ssn" maxlenth="6" 
						pattern="[0-9]+" required="required"/>
						<h3>성별</h3>
						<form:select path="sex">
							<option value="m">남자</option>
							<option value="f">여자</option>
						</form:select>
						<h3>전화번호</h3>
						<form:input path="phone" placeholder="휴대전화번호 '-' 제외"
						required="required"
						maxlength="11" />
						<h3>지역</h3>
						<form:select path="region">
	                    	<option value="0">-- 선택 --</option>
		                    <form:options items="${regionList}"  itemLabel="kor" itemValue="eng"/>
		                </form:select>
					</div>
					<div id="third_box">
						<!-- 언어 옵션 forEach -->
						<h3>언어 능력</h3>
						<c:forEach begin="0" end="2" var="i">
							<form:select path="languageSkillCommandList[${i}].languageId">
								<option value="0">-- 선택 --</option>
								<form:options items="${foreignLanguageList}" itemLabel="lang"
									itemValue="languageId" />
							</form:select>
							<form:select path="languageSkillCommandList[${i}].skillLevel">
								<option value="0">-- 선택 --</option>
								<form:options items="${languageLevelList}" />
							</form:select>
							<br>
						</c:forEach>
						<h3>본인 사진</h3>
						<form:input path="photoFile" type="file" />
						<br>
						<h3>자기 소개</h3>
						<form:input path="introduction" placeholder="간단한 자기소개"
						required="required"
						maxlenth="100" />
						<button>등록</button>
					</div>
				</div>
			</div>
			</form:form>
		</div>
	</section>
	<footer> </footer>
	
</body>
</html>