<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
			$('#loginbtn').click(function(){
				$('#loginForm').submit();
			});
			
	});
</script>
</head>
<body>
	<div>
		오늘 접속자 수: ${stats.cnt }   / 전체 접속자 수: ${totalCount }
	</div>
	<form id = "loginForm" method="post" action="${pageContext.request.contextPath }/LoginServlet">
		<div>
			ID: <input type = "text" name="id">
		</div>
		<div>
			PW: <input type = "password" name="pw">
		</div>
		<div>
			<button type="button" id="loginbtn">로그인</button>
		</div>
	</form>
</body>
</html>