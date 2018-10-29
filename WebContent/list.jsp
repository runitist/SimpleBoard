<%@page import="kr.co.hk.dto.S_Board_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<S_Board_DTO> lsd = (List<S_Board_DTO>) request.getAttribute("lsd");
%>
<table class="listtable">
	<tr>
		<th class="gno">게시번호</th>
		<th class="gna">제목</th>
		<th class="gda">게시일</th>
	</tr>
	<%
		if (lsd != null) {
			for (S_Board_DTO vo : lsd) {
	%>
	<tr>
		<th><%=vo.getBoard_No()%></th>
		<td><a href="listdetail.do?board_no=<%=vo.getBoard_No()%>"><%=vo.getBoard_Title()%></a></td>
		<th><%=vo.getRegdate()%></th>
	</tr>
	<%
		}
		}
	%>
</table>