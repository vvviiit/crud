<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <style>
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }

        th {
            background: SteelBlue;
            color: white;
        }

        td, th {
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>

<h3>User List By Name</h3>
<c:if test="${!empty users}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">User Name</th>
            <th width="120">Age</th>
            <th width="120">isAdmin</th>
            <th width="120">CreatedDate</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.admin}</td>
                <td>${user.createdDate.toString().substring(0,10)}</td>
                <td><a href="<c:url value='/updateUser/${user.id}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteUser/${user.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<p><a href="${pageContext.request.contextPath}/getAllUsers">Home page</a></p>

</body>
</html>