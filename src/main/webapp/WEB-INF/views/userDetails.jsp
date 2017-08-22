<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <style>
        .blue-button {
            background: #25A6E1;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#25A6E1', endColorstr='#188BC0', GradientType=0);
            padding: 3px 5px;
            color: #fff;
            font-family: 'Helvetica Neue', sans-serif;
            font-size: 12px;
            border-radius: 2px;
            -moz-border-radius: 2px;
            -webkit-border-radius: 4px;
            border: 1px solid #1A87B9
        }

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
<form:form method="post" modelAttribute="user" action="/SpringMVCHibernateCRUDExample/addUser">
    <table>
        <tr>
            <th colspan="2">Add User</th>
        </tr>
        <tr>
            <form:hidden path="id"/>
            <td><form:label path="name">User Name:</form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="age">Age:</form:label></td>
            <td><form:input path="age" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="admin">Admin:</form:label></td>
            <td><form:input path="admin" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button"/></td>
        </tr>
    </table>
</form:form>
</br>

<a href="${pageContext.request.contextPath}/listPage/0">User pages</a><br/>

<h3>User List</h3>
<c:if test="${!empty listOfUsers}">
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
        <c:forEach items="${listOfUsers}" var="user">
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
</body>
</html>