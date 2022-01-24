<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                <div class="title_box">
                    <input type="text" id="title" value="Have you been here before?">
                    <input type="text" id="region" value="Daegu"><br>
                    <input type="text" id="category" value="food&drink">
                </div>
                <div class="pin_detail">
                    <div class="image_box">
                        <img src="images/mate.jpg" alt="">
                    </div>
                    <div style="white-space:pre;" class="information_box">

                    </div>
                </div>
                <div class="guide_info">
                    <div>
                        <img src="images/user.png" alt="">
                    </div>
                    <div>
                        <p>alias :&nbsp;<span>값</span></p><br>
                        <p>age :&nbsp;<span>값</span></p><br>
                        <p>sex :&nbsp;<span>값</span></p><br>
                        <p>language:&nbsp;<span>값</span></p><br>
                        <p>language :&nbsp;<span>값</span></p><br>
                    </div>
                </div>
                <div class="comments_wrap">
                    <form:form modelAttribute="" method="">
                        <div class="comments_box">
                            <input type="text" id="comments" placeholder="Enter the comments here">
                        </div>
                        <div class="btn_box">
                            <button>입력</button><span class="cancel">취소</span>
                        </div>
                    </form:form>
                    <div class="comments_here">
                        <input type="text" id="comment" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>
    </section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
    <script>
        $('#comments').on('click', function(){
            $('.btn_box').css({ display : "block" });
            $('#comments').css({ borderBottom: "3px solid rgb(187, 187, 187)"})
        })
        $('.cancel').on('click', function(){
            $('.btn_box').css({ display : "none" });
            $('#comments').css({ borderBottom: "1px solid rgb(187, 187, 187)"})
        })
    </script>
</body>
</html>