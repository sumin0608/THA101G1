<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Finish.jsp" method="post">
		<input type="radio" name="payWay" value="現金">現金<br>
		<input type="radio" name="payWay" value="刷卡">刷卡<br>
		<input type="radio" name="payWay" value="貨到付款">貨到付款<br>
		<input type="submit"  value="送出"><br>
	</form>


</body>
</html>