<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Check</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <%--<li><a href="Controller?action=Overview">Overview</a></li>--%>
                <li><a href="Controller?action=SignUp">Sign up</a></li>
                <li><a href="Controller?action=Products">Products</a></li>
                <li><a href="Controller?action=AddProduct">Add product</a></li>
                <li><a href="Controller?action=Cart">My cart</a></li>
                <li><a href="Controller?action=History">My history</a></li>
            </ul>
        </nav>
        <h2>
            Check password
        </h2>
    </header>
    <form method="post" action="Controller?action=Check" novalidate="novalidate">
        <p><label for="password">Type in password</label><input type="password" id="password" name="password" required value="" ></p>
        <p><label for="id"></label><input type="hidden" id="id" name="id" required value="${id}" ></p>
        <p><input type="submit" id="ckeck" value="check password"></p>
    </form>
    <p>
        <c:if test="${not empty text}">
            <c:out value="${text}">
            </c:out>
        </c:if>
    </p>
</div>
</body>
</html>
