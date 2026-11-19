<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Your Cart</title>
  <link rel="stylesheet" href="styles/main.css" />
</head>

<body>
<h1>Thanks for buying!</h1>
<h2>Total price: $${sessionScope.total}</h2>

<div class="actions">
    <form action="cart" method="post">
        <input type="hidden" name="action" value="back">
        <input type="submit" value="Back">
    </form>
</div>
</body>

</html>