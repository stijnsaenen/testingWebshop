<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Order Completed</title>
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
                <li id="actual"><a href="Controller?action=Cart">My cart</a></li>
            </ul>
        </nav>
        <h2>Thank you for using our webshop. You will receive a confirmation mail with a link to track your order.</h2>
    </header>
    <main>
        <a href="index.jsp"><p>-> Click here to return to the home page <-</p></a>
        <a href="Controller?action=Products"><p>-> Click here to return to the products overview <-</p></a>
    </main>
    <footer> &copy; Testing Groep 19, UC Leuven-Limburg </footer>
</div>
</body>
</html>