<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="styles/main.css"/>
</head>
<body>
<h1>Your Cart</h1>

<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${item.product.id}">
                    <input type="text" name="quantity" value="${item.quantity}">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>${item.product.description}</td>
            <td class="right">$${item.product.price}</td>
            <td class="right">$${item.total}</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="id" value="${item.product.id}">
                    <input type="submit" value="Remove Item">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>

<div class="actions">
    <form action="cart" method="post">
        <input type="hidden" name="action" value="shop">
        <input type="submit" value="Continue Shopping">
    </form>

    <form action="cart" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Checkout">
    </form>
</div>
</body>
</html>
