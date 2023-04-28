<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<x:form action="updateemployee" method="post" modelAttribute="employee">
Id:<x:input type="text" path="id" readonly="readonly"/><br>

Name:<x:input type="text" path="name" /><br>
Mobile:<x:input type="text" path="mobile"/><br>
Salary:<x:input type="text" path="salary"/><br>
Date of joining<input type="Date" name="date" value="${employee.getDoj()}"><br>
<button  type="reset"> Reset </button>
<button  > Update </button>
</x:form>
</body>
</html>