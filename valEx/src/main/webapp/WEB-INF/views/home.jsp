<%@page import="java.util.Enumeration"%>
<%@page import="org.springframework.validation.BindingResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script></script>
</head>
<body>
	<h1>밸리데이션 검사</h1>
	
	<form action="/test/result/">
	<p>
	number:<input type="text" name="number" /><span>${errs.number }</span>
	</p>
	<p>
	number2:<input type="text" name="number2" /><span>${errs.number2 }</span>
	</p>
	<p>
	name:<input type="text" name="name" /><span>${errs.name }</span>
	</p>
	<p>
	pw:<input type="password" name="pw" /><span>${errs.pw }</span>
	</p>
	<p>
	email:<input type="email" name="email" /><span>${errs.email }</span>
	</p>
	<p>
	email2:<input type="email" name="email2" /><span>${errs.email2 }</span>
	</p>
	<p>
	<button>전송</button>
	</p>
	</form>
</body>
</html>








