<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>My cart</title>
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
                <li id="actual"><a href="Controller?action=Cart">My cart</a></li>
                <li><a href="Controller?action=History">My history</a></li>
            </ul>
        </nav>
        <c:if test="${not empty error}">
                <div class="alert-danger">
                    <ul>
                        <li>${error}</li>
                    </ul>
                </div>
        </c:if>
        <h2>
            Items in my cart
        </h2>
    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>price</th>
            </tr>
            <c:set var="totaalprijs" scope="session" value="${0}"/>
            <c:forEach var ="product" items = "${cartproducten}" >
                <c:set var="totaalprijs" scope="session" value="${totaalprijs + product.price }"/>
                <tr>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><a href="Controller?action=DeleteCart&id=${product.productId}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="Controller?action=EmptyCart"><p>Empty your cart</p></a>
        <div class="cartbox">
            <div class="boxcontent">
                <p>Total price : <c:out value="${totaalprijs}"/>€</p>
                <form action="Controller?action=Payment" method="post">
                    <input type="submit" value="Next">
                </form>
            </div>
        </div>
    </main>
    <footer>
        &copy; Testing Groep 19, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
