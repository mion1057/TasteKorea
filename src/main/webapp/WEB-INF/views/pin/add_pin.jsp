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
			<div class="content">
				<form:form modelAttribute="pinCommand" method="post"
					enctype="multipart/form-data">
					<form:input path="title" />
					<form:input path="imagePath" type="file" />
					<form:select path="region" required="required">
						<option value="0">------</option>
						<form:options items="${regionList}" itemLabel="eng"
							itemValue="regionId" />
					</form:select>
					<form:select path="category" required="required">
						<option value="0">-------</option>
						<form:options items="${pinCategoryList}" itemLabel="category" itemValue="categoryId"/>
					</form:select>
					<form:input path="mapData" />
					<form:input path="details" />
				</form:form>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
</body>
</html>