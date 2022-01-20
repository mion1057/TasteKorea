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
	href="<c:url value='/resources/css/infomanagement_companion.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div id="content">
				<h2>Member Info</h2>
				<form:form modelAttribute="memberCommand" method="post"
					enctype="multipart/form-data">
					<form:input path="guide" style="display: none;" value="true" />
					<form:input path="sex" style="display: none;" />
					<div class="profile_info">
						<!-- 가이드가 등록한 본인 사진이 들어갈 공간 -->
						<h2>프로필 정보</h2>
						<div class="profile">
							<div class="profile_first">
								<span class="profileImage"><img src=""></span>
								<h3>이름</h3>
								<form:input path="firstName" value="${tasteMember.firstName }" readonly/><br>
								<h3>성</h3>
								<form:input path="lastName" value="${tasteMember.lastName }" readonly/>
								<div class="filebox">
									<!-- 단순히 파일명만 들어갈 인풋 path는 없음 -->
									<input class="upload-name" value="첨부파일" placeholder="첨부파일"
										readonly />
									<form:input path="profileImage" type="file" label="파일찾기" />
								</div>
							</div>
							<div class="profile_second">
								<h2>이메일</h2>
								<form:input path="email" value="${tasteMember.email }" readonly />
								<h2>비밀번호 변경</h2>
								<form:password path="passwd" minlength="8" maxlength="14"
									required="required" />
							</div>
							<div class="profile_number">
								<h2>전화번호</h2>
								<form:input path="phone" readonly />
								<h2>주민번호 앞자리</h2>
								<form:input path="ssn" maxlength="6" required="required" />
							</div>
							<div class="profile_third">
								<h2>지역</h2>
								<form:select path="region" required="required">
									<option value="0">------</option>
									<form:options items="${regionList}" itemLabel="region"
										itemValue="regionId" />
								</form:select>
								<h2>언어 능력</h2>
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
								<button>수정</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
		$("#profileImage").on('change', function() {
			var fileName = $("#profileImage").val();
			$(".upload-name").val(fileName);
		});
	</script>
</body>
</html>