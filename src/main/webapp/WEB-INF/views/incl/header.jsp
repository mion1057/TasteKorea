<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header_zone">
		<!-- 로고 -->
		<div id="logo_zone">
			<!-- 홈 이동 버튼 -->
			<a href="/">taste<span class="bold">Korea</span></a>
		</div>
		<!-- 주메뉴 -->
		<div id="gnb_zone">
			<ul>
				<li class="gnb_list"><a href="" class="gnb_btn">가이드리스트</a>
				<li class="gnb_list"><a href="/pin/index" class="gnb_btn">PIN</a></li>
			</ul>
		</div>
		<!-- 로그인 & 회원가입 -->
		<c:choose>
			<c:when test="${empty user}">
				<div id="snb_zone">
					<ul class="sub_list_wrap">
						<li class="sub_list"><span class="login_btn btn"><a href="/member/login">Log in</a></span></li>
						<li class="sub_list"><span class="sign_btn btn">Sign up</span>
							<ul class="child_wrap">
								<li class="child_list before1"><a href="/member/traveler/add">traveler</a></li>
								<li class="child_list before2"><a href="/member/companion/add">Companion</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div id="snb_zone">
                <ul class="sub_list_wrap">
                    <li class="sub_list membername">
                        <a href="#"><span>${user.firstName}</span><span>${user.lastName}님</span></a>
                        <ul class="child_wrap">
                        	<c:if test="${user.guide == true}">
                            	<li class="child_list after1"><a href="/member/companion/mypage">내 정보</a></li>
                            </c:if>
                            <c:if test="${user.guide == false}">
                            	<li class="child_list after1"><a href="member/traveler/mypage">내 정보</a></li>
                            </c:if>
                            <!-- <li class="child_list after2"><a href="">내 게시글</a></li> -->
                            <li class="child_list after3"><a href="/member/logout">Log out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>