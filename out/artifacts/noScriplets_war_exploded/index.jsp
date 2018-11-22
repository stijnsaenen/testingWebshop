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
					<li id="actual"><a href="Controller">Home</a></li>
					<%--<li><a href="Controller?action=Overview">Overview</a></li>--%>
					<li><a href="Controller?action=SignUp">Sign up</a></li>
					<li><a href="Controller?action=Products">Products</a></li>
					<li><a href="Controller?action=AddProduct">Add product</a></li>
					<li><a href="Controller?action=Cart">My cart</a></li>
				</ul>
			</nav>
			<h2>Home</h2>
		</header>
		<main> Welcome to our webshop. Browse our products to see our latest items added in our webshop.
		Add items to your cart by pressing "add to cart"</main>
		<footer> &copy; Testing Groep 19, UC Leuven-Limburg </footer>
	</div>
</body>
</html>