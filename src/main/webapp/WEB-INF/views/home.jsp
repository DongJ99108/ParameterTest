<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Home</h2>
	<a href="/temp?a=hello&b=123">temp</a> 
	
	<hr />
	<h2>GET 방식 전송</h2>
	<ul>
	  <li>Parameter 처리 방법</li>
	  <li><a href="/temp1?a=hello&b=123">temp1으로 값 전송</a></li>
	  <li><a href="/temp2?a=hello&b=123">temp2으로 값 전송</a></li>
	  <li><a href="/temp3?a=hello&b=123">temp3으로 값 전송</a></li>
	  <li><a href="/temp4?a=hello&b=123">temp4으로 값 전송</a></li>
	  
	  <li>Model 로 데이터를 돌려받는  방법</li>
	  <li><a href="/temp5?a=hello&b=123">temp5으로 값 전송</a></li>
	  <li><a href="/temp6?a=hello&b=123">temp6으로 값 전송</a></li>
	  <li><a href="/temp7?a=hello&b=123">temp7으로 값 전송</a></li>
	  
	  <li>Path Variable 호출 방법</li>
	  <li><a href="/temp8/hello/123">temp8으로 값 전송</a></li>
	  <li><a href="/temp9/hello/123">temp9으로 값 전송</a></li>
	  <li><a href="/temp10/hello/123">temp10으로 값 전송</a></li>
	
	</ul>
	
	
</body>
</html>











