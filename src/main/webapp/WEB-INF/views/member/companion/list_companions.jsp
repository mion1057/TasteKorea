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
	href="<c:url value='/resources/css/signup_companion.css'/>" />
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
		<!-- 중앙에 모아질 회원가입 틀 -->
		<div id="container">
			<c:forEach var="companion" items="${companionList}">
         ${companion }
         <div class="guide_wrap">
					<div class="image_box">
						<!-- 사진 -->
						<a href=""><img
							src="<c:url value='/resource/companion/profie/${companion.photo }'/>"
							class="guide_intro"></a>
					</div>
					<div class="info_box">
						<p class="guide_name">
							이름 <span>${companion.name }</span>
						</p>
						<p class="guide_age">
							나이 <span>${companion.ssn }</span>
						</p>
						<p class="guide_region">
							지역 <span>${companion.region }</span>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>

	</section>
	<script type="text/javascript">
		$(".pageInfo a").on("click", function(e) {
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.attr("action", "/board/list");
			moveForm.submit();
		});
	</script>
	<footer> </footer>

</body>
</html>