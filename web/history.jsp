<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
            <nav>
                <ul>
                    <li><a href="Controller">Home</a></li>
                    <%--<li><a href="Controller?action=Overview">Overview</a></li>--%>
                    <li><a href="Controller?action=SignUp">Sign up</a></li>
                    <li><a href="Controller?action=Products">Products</a></li>
                    <li><a href="Controller?action=AddProduct">Add product</a></li>
                    <li><a href="Controller?action=Cart">My cart</a></li>
                    <li id="actual"><a href="Controller?action=History">My history</a></li>
                </ul>
             </nav>
        <h2>Your order history</h2>
    </header>
    <main>
        <table>
            <c:set var="ordernr" scope="session" value="${0}"/>
            <c:forEach var ="order" items = "${orders}" >
                <c:set var="ordernr" scope="session" value="${ordernr + 1 }"/>
            <p>order <c:out value="${ordernr}"/> placed on <c:out value="${order.date}"/></p>

                <tr>
                    <td><c:out value="${order.address}"/></td>
                    <td><c:out value="${order.place}"/></td>
                    <td><c:out value="${order.zip}"/></td>
                    <td>Invoice sent: <c:out value="${order.invoice}"/></td>
                    <table>
                        <c:forEach var ="product" items = "${order.productlist}">
                            <tr>
                                <td><c:out value="${product.name}"/></td>
                                <td><c:out value="${product.description}"/></td>
                                <td><c:out value="${product.price}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <%--<td><a href="Controller?action=DeleteCart&id=${product.productId}">delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </main>
        <footer> &copy; Testing Groep 19, UC Leuven-Limburg </footer>
</div>
</body>
</html>