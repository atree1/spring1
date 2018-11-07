<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>register Page</h1>
	
	<h3><sec:authentication property="principal"/></h3>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<button>admin only</button>
	</sec:authorize>
</body>
</html>