<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		${loginStaff.storeId } 지점
	</div>
	<div>
		${loginStaff.username } 관리자님 
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
	</div>
	
	<h1>Menu</h1>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">홈</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">영화 반납</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">회원목록 관리</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">영화목록 관리</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">영화재고 관리</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">영화배우 관리</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">영화 출연배우 등록</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">매장 통계</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/">MVP</a>
	</div>
</body>
</html>