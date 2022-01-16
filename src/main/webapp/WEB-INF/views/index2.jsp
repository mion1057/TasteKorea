<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/index.css'/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<!-- index 메인 -->
    <section>
        <div id="first_main">
            <div id="main_slider"></div>
            <div class="search_bar">
                <input type="text" placeholder="어디로 떠나시나요?">
                <button>Search</button>
            </div>
            <span class="welcome_msg">한국에 오시나요?<br>당신의 여행 친구를 찾아보세요</span>
        </div>
        <div id="second_main">
            <div class="pinbox_wrap">
                <h2>최신 PIN을 만나보세요</h2>
                <div class="pinbox left">
                    <div class="pinbox_image"></div>
                    <div class="pinbox_text"></div>
                </div>
                <div class="pinbox">
                    <div class="pinbox_image"></div>
                    <div class="pinbox_text"></div>
                </div>
                <div class="pinbox right">
                    <div class="pinbox_image"></div>
                    <div class="pinbox_text"></div>
                </div>
            </div>
        </div>
        <!-- 세번째 메인 -->
        <div id="third_main">
            <div>
                <h3></h3>
                <div></div>
            </div>
        </div>
        <div id="fourth_main">
        	<div>
                <h3></h3>
                <div></div>
            </div>
        </div>
    </section>
    <footer id="footer">
	
    </footer>
	<script src="<%=request.getContextPath()%> /resources/js/menu.js"></script>
</body>
</html>