<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updated">
username: <input type="text" name="name"  value="${editview.name}" /></br>
password: <input type="text" name="password"  value="${editview.password}"/></br>
gmail   : <input type="text" name="gamil" value="${editview.gamil}" readonly/></br>
cellnum : <input type="text" name="cellnum" value="${editview.cellnum}"/></br>
<input type="submit" value="update"/>

</form>
</body>
</html>