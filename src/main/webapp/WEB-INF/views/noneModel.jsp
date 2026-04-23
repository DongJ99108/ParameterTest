<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>넘어온 data(model)</h2>
	${ a }    == model.getAttribute("a") 
	${ vo.a } == vo.getA() 
	<p>a : ${ a }</p>
	<p>b : ${ b }</p>
	<br>
	<p>a : ${ vo.a }</p>
	<p>b : ${ vo.b }</p>
	<br>
	<p>a : ${ attrName.a }</p>
	<p>b : ${ attrName.b }</p>
	<br>
	<p>a : ${ param.a }(request.getParameter("a"))</p>
	<p>b : ${ param.b }(request.getParameter("a"))
	   requestScope 공유한다
	</p>
	
	<br>
</body>





</html>








