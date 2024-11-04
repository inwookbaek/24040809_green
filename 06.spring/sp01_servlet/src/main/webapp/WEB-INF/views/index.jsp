<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp(in servlet)</h1>
	<ol>
		<li>index.jsp는 서블릿설정과는 상관없이 호출된다.</li>
		<li>application.properties에 prefix와 surffix를 설정해야 한다.</li>
		<ul>
			<li>spring.mvc.view.prefix=/WEB-INF/views/</li>
			<li>spring.mvc.view.suffix=.jsp</li>
		</ul>
		<li>build.gradle에 JSP의존주입을 해야 한다.</li>
		<ul>
			<li>implementation 'org.apache.tomcat.embed:tomcat-embed-jasper' // JSP support</li>
			<li>implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0' // JSTL with spring boot 3.x.x</li>
		</ul>
	</ol>
</body>
</html>