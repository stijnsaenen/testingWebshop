<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Products</title>
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
                <li id="actual"><a href="Controller?action=Products">Products</a></li>
                <li><a href="Controller?action=AddProduct">Add product</a></li>
                <li><a href="Controller?action=Cart">My cart</a></li>
            </ul>
        </nav>
        <h2>
            Products
        </h2>
    </header>
<main>
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>price</th>
        </tr>
        <c:forEach var ="products" items = "${products}" >
        <tr>
            <td><a href="Controller?action=Change&product=${products.productId}"><c:out value="${products.name}"/></a></td>
            <td><c:out value="${products.description}"/></td>
            <td><c:out value="${products.price}"/></td>
            <td><a href="Controller?action=Delete&id=${products.productId}">delete</a></td>
            <td><a href="Controller?action=AddCart&id=${products.productId}">add to cart</a></td>
        </tr>
        </c:forEach>
        <caption>Users Overview</caption>
    </table>
</main>
<footer>
    &copy; Testing Groep 19, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
