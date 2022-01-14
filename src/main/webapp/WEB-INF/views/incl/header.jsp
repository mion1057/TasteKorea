<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<li class="gnb_list"><a href="guide/companion/list"
					class="gnb_btn">가이드리스트</a>
				<li class="gnb_list"><a href="" class="gnb_btn">PIN</a></li>
				<li class="gnb_list"><a href="" class="gnb_btn">고객센터</a></li>
			</ul>
		</div>
		<!-- 로그인 & 회원가입 -->
		<div id="snb_zone">
			<c:choose>
				<c:when test="${!empty companion and empty traveler}">
					<ul class="sub_list_wrap">
						<li class="sub_list"><a href="#">${companion.name}님</a>
							<ul class="child_wrap">
								<li class="child_list after1"><a href="">My page</a></li>
								<li class="child_list after2"><a href="">Log out</a></li>
							</ul></li>
					</ul>
				</c:when>
				<c:when test="${!empty traveler && empty companion }">
					<ul class="sub_list_wrap">
						<li class="sub_list"><a href="#">${traveler.name}님</a>
							<ul class="child_wrap">
								<li class="child_list after1"><a href="">My page</a></li>
								<li class="child_list after2"><a href="">Log out</a></li>
							</ul></li>
					</ul>
				</c:when>
				<c:otherwise>
				<span style="display=none;">${traveler.id}</span>
							<ul class="sub_list_wrap">
						<li class="sub_list"><span class="login_btn btn">Log
								in</span>
							<ul class="child_wrap">
								<li class="child_list before1"><a
									href="/user/traveler/login">traveler</a></li>
								<li class="child_list before2"><a
									href="/guide/companion/login">Companion</a></li>
							</ul></li>
						<li class="sub_list"><span class="sign_btn btn">Sign
								up</span>
							<ul class="child_wrap">
								<li class="child_list before1"><a
									href="/user/traveler/signup">traveler</a></li>
								<li class="child_list before2"><a
									href="/guide/companion/signup">Companion</a></li>
							</ul>
						</li>
				</ul>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
</body>
</html>