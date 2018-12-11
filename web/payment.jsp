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
                <li><a href="Controller?action=History">My history</a></li>A
            </ul>
        </nav>
        <h2>
            Place your order.
        </h2>
    </header>
    <main>
        <a href="Controller?action=Cart"><p><- Go back to cart</p></a>
        <c:if test="${not empty errors}">
            <c:forEach var="error" items="${errors}">
                <div class="alert-danger">
                    <ul>
                        <li>${error}</li>
                    </ul>
                </div>
            </c:forEach>
        </c:if>
        <form method="post" action="Controller?action=ThankYou" novalidate="novalidate">


            <h3>
                Your info
            </h3>
            <p><label for="adres">Address:</label><input type="text" id="adres" name="adres" placeholder="street number place" required value=""></p>
            <p><label for="place">Place:</label><input type="text" id="place" name="place" placeholder="Leuven" required value=""></p>
            <p><label for="postcode">ZIP code:</label><input type="text" id="postcode" name="postcode" placeholder="3000" required value="">
            <p><label for="invoice">Invoice:</label><input type="checkbox" id="invoice" name="invoice" value="">
            </p>
            <h3>Your products</h3>
            <table id="productsPayment">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="product" items="${cartproducten}">
                    <tr>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.description}"/></td>
                        <td><c:out value="${product.price}"/></td>
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