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
<link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/footer.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
<script src="<c:url value='/resources/js/slideshow.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<!-- index 메인 -->
           <section>
        <div id="container">
            <div id="first_main">
                <div id="slideshow-containerider">
                    <div class="mySlideDiv fimg fade active"></div>
                    <div class="mySlideDiv simg fade"></div>
                    <div class="mySlideDiv timg fade"></div>
                    <div class="mySlideDiv yimg fade"></div>
                </div>
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
                        <div class="pinbox_image">
                            <a href=""><img src="" alt=""></a>
                        </div>
                        <div class="pinbox_text">
                            <div class="text1">
                                <h3>#부산#여기는모를껄<br>#나만아는장소</h3>
                            </div>
                            <div class="text2">
                                <div><img src="" alt=""></div>
                                <div><span>${companion.name}님</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="pinbox center">
                        <div class="pinbox_image">
                            <a href=""><img src="" alt=""></a>
                        </div>
                        <div class="pinbox_text">
                            <div class="text1">
                                <h3>#서울#로컬만아는곳<br>#로컬</h3>
                            </div>
                            <div class="text2">
                                <span>${companion.name}님</span>
                            </div>
                        </div>
                    </div>
                    <div class="pinbox right">
                        <div class="pinbox_image">
                            <a href=""><img src="" alt=""></a>
                        </div>
                        <div class="pinbox_text">
                            <div class="text1">
                                <h3>#언제가보겠어#인생사진<br>#노을맛집</h3>
                            </div>
                            <div class="text2">
                                <span>${companion.name}님</span>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
                <div id="third_main">
                    <!-- 우측스크롤바 가진 지역 PIN -->
                    <h2>지역별 핀</h2>
                    <div id="region_content_wrap">
                        <div class="region_pin_wrap">
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>서울</span>
                                <img src="<c:url value='/resources/images/region/seoul.jpg'/>" >
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>부산</span>
                                <img src="<c:url value='/resources/images/region/busan.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>제주</span>
                                <img src="<c:url value='/resources/images/region/jeju.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>대구</span>
                                <img src="<c:url value='/resources/images/region/daegu1.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>울릉도</span>
                                <img src="<c:url value='/resources/images/region/ulleungdo.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>춘천</span>
                                <img src="<c:url value='/resources/images/region/chuncheon.png'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>광주</span>
                                <img src="<c:url value='/resources/images/region/gwangju.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>인천</span>
                                <img src="<c:url value='/resources/images/region/incheon.jpg'/>" alt="">
                            </div>
                            <div class="region_pin_box">
                                <a href=""></a>
                                <span>평양</span>
                                <img src="<c:url value='/resources/images/region/pyongyang.jpg'/>" alt="">
                            </div>
                            <div class="view_more">
                                <a href="">View more</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="fourth_main">
                    <div class="fourth_content">
                        <a href="/member/companion/list">Guide List</a>
                        <div class="fourth_background"></div>
                    </div>
                </div>
                <div id="">
                    <div>
                        
                    </div>
                </div>
            </div>
    </section>
    <footer>
       <%@ include file="/WEB-INF/views/incl/footer.jsp"%> 
    </footer>
</body>
</html>