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
				<li class="gnb_list"><a href="member/companion/list" class="gnb_btn">가이드리스트</a>
				<li class="gnb_list"><a href="" class="gnb_btn">PIN</a></li>
				<li class="gnb_list"><a href="" class="gnb_btn">고객센터</a></li>
			</ul>
		</div>
		<!-- 로그인 & 회원가입 -->
		<div id="snb_zone">
			<ul class="sub_list_wrap">
				<li class="sub_list"><span class="login_btn btn">Log in</span>
					<ul class="child_wrap">
						<li class="child_list before1"><a href="login">traveler</a></li>
						<li class="child_list before2"><a href="login">Companion</a></li>
					</ul>
				</li>
				<li class="sub_list"><span class="sign_btn btn">Sign up</span>
					<ul class="child_wrap">
						<li class="child_list before1"><a href="member/travelr/add">traveler</a></li>
						<li class="child_list before2"><a href="member/companion/add">Companion</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>