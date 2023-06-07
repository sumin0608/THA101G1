<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,
    tw.idv.ixercise.store.entity.*,
    tw.idv.ixercise.store.dao.*"%>
<%
request.setCharacterEncoding("UTF-8");
List<porder> l=(List)session.getAttribute("L");
String PayWay=request.getParameter("payWay");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
						  		
						  			//product p=new implProduct().query(productName);
						  			
						  			//char single = '"';
						  			
						  			
						  			
						  			for(porder p:l)
						  			{
						  				product pr=new implProduct().query(p.getProductName());
						  				String img=pr.getPicture();
						  				out.println(
							  					"<tr><td align='center' width='200' height='200'><img src= lib/img/"+pr.getPicture()+">"+
							  					"<td>"+p.getProductName()
							  					
							  					
							  					);
						  			
						  			}						  			
						  			
						  			
						  		
						  	
						  	%>
						  	付款方式:<%=PayWay %>
						  	
<a href="insertPorderServlet">提交</a>
</body>
</html>