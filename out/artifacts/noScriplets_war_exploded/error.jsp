<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Error</title>
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
            </ul>
        </nav>
        <h2>
            Error
        </h2>
    </header>
    <main>
        <h3>Oops something went wrong!</h3>
        <p><a href="index.jsp">go back to home</a></p>
        <p>There is an exception!! ${pageContext.exception}</p>
        <p>message:${pageContext.exception.message}</p>
    </main>
</div>
</body>
</html>