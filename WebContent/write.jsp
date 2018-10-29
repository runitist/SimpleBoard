<%@page import="kr.co.hk.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int bdn = BoardDAO.get_MaxBoardNum();
%>
<form action="write.do" method="post">
	<label for="Board_No">보드번호(자동발생) : </label>
	<input id="Board_No" name="Board_No" value="<%=bdn+1%>" readonly="readonly" type="text" required="required" /> <br /> 
	<label for="Board_Title">제목 : </label>
	<input id="Board_Title"	name="Board_Title" autofocus="autofocus" autocomplete="on" type="text" required="required" /> <br /> 
	<label for="Board_Content">내용	</label>
	<textarea name="Board_Content" id="content" cols="30" rows="10"  required="required"></textarea>	<br /> 
	<label for="Regdate">등록날짜 : </label>
	<input id="Regdate"	name="Regdate" type="date"  required="required" /> <br /> 
	<input type="submit" value="등록" /> <button type="button">조회</button>
</form>
