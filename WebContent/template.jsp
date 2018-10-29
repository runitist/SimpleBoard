<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sectionFlag = request.getAttribute("sectionFlag").toString();
	String flagTitle = request.getAttribute("flagTitle").toString();
%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="Common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=flagTitle%></title>
</head>
<body>
	<div class="container">
		<header>
			<h1><%=flagTitle%></h1>
		</header>
		<div class="mid">
			<nav>
				<ul class="navul1">
					<li><a href="home.do">홈</a></li>
					<li><a href="list.do">리스트</a></li>
					<li><a href="write.do">글쓰기</a></li>
				</ul>
			</nav>
			<section>
				<jsp:include page="<%=sectionFlag%>" />
			</section>
		</div>
		<footer>CopyRight by Lee</footer>
	</div>
</body>
</html>