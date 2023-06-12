<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "tw.idv.ixercise.store.entity.*,tw.idv.ixercise.store.dao.*"
    import = "java.util.*"%>
  <%
  member m=(member)session.getAttribute("Member");
  //List<porder> l=new ImplPorder().queryMemberNo(m.getMember_no());
  List<porder> l=new ImplPorder().queryMemberNo(m.getName());
 
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=600 align=center border=1>
	<tr>
	<td>id<td>訂單編號<td>訂購人<td>商品<td>數量<td>日期
	<td>電子信箱
<%
for(porder p:l)
{
	out.println("<tr><td>"+p.getId()+
			"<td>"+p.getPorderNo()+
			
			//"<td>"+p.getMemberNo()+
			"<td>"+p.getName()+
			"<td>"+p.getProductName()+
			"<td>"+p.getPamount()+
			"<td>"+p.getPdate()+
			"<td>"+p.getEmail());
}

%>
</table>
</body>
</html>