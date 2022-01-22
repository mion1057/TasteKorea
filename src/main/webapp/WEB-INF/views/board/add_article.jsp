<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<form name="form">
	<input type="text" name="data" id="data"/>
	<input type="submit"/>
</form>

<p id="result">가낟</p>
<script type="text/javascript">
$('form').on('submit', function () {
	event.preventDefault();
    var queryString = $("form[name=form]").serialize() ;
    alert(queryString);
    $.ajax({
    	type : 'POST', 
        url : this.action,
        data : $(this).serialize(),
        success : function(json){
        	$('#result').text(json) 
        }
    });
});
</script>
</body>
</html>