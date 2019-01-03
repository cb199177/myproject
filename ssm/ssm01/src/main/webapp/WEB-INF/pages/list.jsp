<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/28
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="account">
    ${account.name} ${account.money}<br>
</c:forEach>
<h3>OK啦</h3>
</body>
</html>
