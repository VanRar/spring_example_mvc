<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    Dear Employee, please enter your details
</h2>

<br>
<br>

<form:form action="showDetails" modelAttribute="employee">

    Name <form:input path="name"/><br><br>
    Surname <form:input path="surname"/><br><br>
    Salary <form:input path="salary"/><br><br>
    Department <form:select path="department">
<%--    <form:option value="Information Technology" label="IT"/>--%>
<%--    <form:option value="Human Resources" label="HR"/>--%>
<%--    <form:option value="Sales" label="Sales"/>--%>
    <form:options items="${employee.departments}"/> <%-- map.key = value, map.value = label --%>
    </form:select>
    <br><br>

    <input type="submit" value="OK">

</form:form>

</body>
</html>