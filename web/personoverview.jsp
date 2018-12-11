<%@page import="domain.model.Person" %>
<%@page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <%--<li id="actual"><a href="Controller?action=Overview">Overview</a></li>--%>
                <li><a href="Controller?action=SignUp">Sign up</a></li>
                <li><a href="Controller?action=Products">Products</a></li>
                <li><a href="Controller?action=AddProduct">Add product</a></li>
                <li><a href="Controller?action=Cart">My cart</a></li>
                <li><a href="Controller?action=History">My history</a></li>
            </ul>
        </nav>
        <h2>
            User Overview
        </h2>

    </header>
    <main>
        <table>
            <tr>
                <th>E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
                <c:forEach var ="personen" items = "${personen}" >
                    <tr>
                        <td><c:out value="${personen.email}"/></td>
                        <td><c:out value="${personen.firstName}"/></td>
                        <td><c:out value="${personen.lastName}"/></td>
                        <td><a href="Controller?action=DeletePerson&id=${personen.userid}">delete</a></td>
                        <%--<td><a href="Controller?action=Checkpass&id=${personen.userid}">check</a></td>--%>
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