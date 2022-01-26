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
	href="<c:url value='/resources/css/page_allPin.css'/>" />
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
            <div class="content">
                <h3 class="p_title">PIN</h3>
                <div class="region_bar">
                    <form action="">
                        <input type="button" value="Seoul" onclick="">
                        <input type="button" value="Busan" onclick="">
                        <input type="button" value="Jeju" onclick="">
                        <input type="button" value="Daegu" onclick="">
                        <input type="button" value="Chuncheon" onclick="">
                        <input type="button" value="Incheon" onclick="">
                        <input type="button" value="Gwangju" onclick="">
                        <input type="button" value="Ulleungdo" onclick="">
                        <input type="button" value="Pyongyang" onclick="">
                    </form>
                </div>
                <div class="region_bar">
                    <form action="">
                        <input type="button" value="food&amp;drink" onclick="">
                        <input type="button" value="sigthseeing" onclick="">
                        <input type="button" value="shopping" onclick="">
                        <input type="button" value="play&amp;arcade" onclick="">
                        <input type="button" value="medical&amp;beauty" onclick="">
                        <input type="button" value="sports&amp;leisure" onclick="">
                        <input type="button" value="job&amp;education" onclick="">
                    </form>
                </div>
              <c:forEach var="pin" items="${pinList.result.content}">
              		<div class="pin_box">
                    <a href=""></a>
                    <div class="user_profile">
                        <a href="">
                            <!-- 강드 프로필 사진 들어갈 부분 src 수정-->
                            <img src="<c:url value='/resource/companion/profie/${pin.member.profileImage}' />" alt="">
                            <span class="user_name">${pin.member.firstName}<span>${pin.member.lastName }</span></span>
                        </a>        
                        <span class="pin_region">
                            <img src="images/marker.png" alt="">
                            지역이름
                        </span>
                    </div>
                    <div class="pin_image">
                        <!-- <img src="images/daegu1.jpg" alt=""> -->
                        <img alt="" src="<c:url value='/resource/companion/profie/${pin.imagePath}' />">
                    </div>
                    <div class="pin_title">
                        <div>
                            <span class="lastName">가이드닉네임&nbsp;</span>
                            <span class="title">핀 제목이 들어감</span>
                        </div>
                    </div>
                </div>
              </c:forEach>
                
                <div class="pin_box">
                    <a href=""></a>
                    <div class="user_profile">
                        <a href="">
                            <!-- 강드 프로필 사진 들어갈 부분 src 수정-->
                            <img src="images/user.png" alt="">
                            <span class="user_name"></span>
                        </a>        
                        <span class="pin_region">
                            <img src="images/marker.png" alt="">
                            지역이름
                        </span>
                    </div>
                    <div class="pin_image">
                        <img src="images/dague1.jpg" alt="">
                    </div>
                    <div class="pin_title">
                        <div>
                            <span class="lastName">가이드닉네임&nbsp;</span>
                            <span class="title">핀 제목이 들어감</span>
                        </div>
                    </div>
                </div>
                <div class="pin_box">
                    <a href=""></a>
                    <div class="user_profile">
                        <a href="">
                            <!-- 강드 프로필 사진 들어갈 부분 src 수정-->
                            <img src="images/user.png" alt="">
                            <span class="user_name"></span>
                        </a>        
                        <span class="pin_region">
                            <img src="images/marker.png" alt="">
                            지역이름
                        </span>
                    </div>
                    <div class="pin_image">
                        <img src="images/dague1.jpg" alt="">
                    </div>
                    <div class="pin_title">
                        <div>
                            <span class="lastName">가이드닉네임&nbsp;</span>
                            <span class="title">핀 제목이 들어감</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>