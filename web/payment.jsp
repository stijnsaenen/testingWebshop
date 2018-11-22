<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
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
            </ul>
        </nav>
        <h2>
            Place your order.
        </h2>
    </header>
    <main>
        <c:if test="${not empty errors}">
            <c:forEach var="error" items="${errors}">
                <div class="alert-danger">
                    <ul>
                        <li>${error}</li>
                    </ul>
                </div>
            </c:forEach>
        </c:if>
        <form method="post" action="thankyou.jsp" novalidate="novalidate">


            <h3>
                Your info
            </h3>
            <p><label for="name">Name:</label><input type="text" id="name" name="name" required value=""></p>
            <p><label for="adres">Address:</label><input type="text" id="adres" name="name" required value=""></p>
            <p><label for="postcode">ZIP code:</label><input type="text" id="postcode" name="name" required value="">
            <p><label for="invoice">Invoice:</label><input type="checkbox" id="invoice" name="invoice" value="">
            </p>
            <h3>Your products</h3>
            <table id="productsPayment">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
                <c:set var="totaalprijs" scope="session" value="${0}"/>
                <c:forEach var="products" items="${cartproducten}">
                    <c:set var="totaalprijs" scope="session" value="${totaalprijs + products.price }"/>
                    <tr>
                        <td><c:out value="${products.name}"/></td>
                        <td><c:out value="${products.description}"/></td>
                        <td><c:out value="${products.price}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <p><input type="submit" id="Bestel" value="Order"></p>

        </form>
    </main>
    <footer>
        &copy; Testing Groep 19, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>