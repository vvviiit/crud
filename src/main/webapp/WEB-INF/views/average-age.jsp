<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
Average age is : ${averageAge}
</head>
<body>
<p><a href="${pageContext.request.contextPath}/getAllUsers">
    <button>Home page</button>
</a></p>
</body>
</html>