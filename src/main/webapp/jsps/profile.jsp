<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deleteemployee(gamil) {
	alert("delete triggered for : " + gamil);
	document.forms[0].action="${pageContext.request.contextPath}/deleteEmployee?gamil="+gamil;
	document.forms[0].method="post";
	document.forms[0].submit();
}
function editmode(gamil) {
	alert("edit triggered for : " + gamil);
	document.forms[0].action="${pageContext.request.contextPath}/editin?editview="+gamil;
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteall" method="post">
	<table border="2">


		<tr>
			<th>name</th>
			<th>gamil</th>
			<th>cellnum</th>

		</tr>
		<core:forEach var="employee" items="${message}">
			<tr>
				<td><core:out value="${employee.name}" /></td>
				<td><core:out value="${employee.gamil}"/></td>
				<td><core:out value="${employee.cellnum}" /></br></td>
				<td><input type="button" value="edit" onclick="editmode('${employee.gamil}')" /></td>
				<td><input type="button" value="delete" onclick="deleteemployee('${employee.gamil}')" /></td>
				<td><input type ="checkbox" name="gamil" value="${employee.gamil}"/></td>
			</tr>
		</core:forEach>
	</table>
	<input type="submit" value="deleteall"/>
	</form>
</body>
</html>