<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" />
</head>

<body>
<h1>CD List</h1>
<table>
    <tr>
        <th>Description</th>
        <th>Price</th>
        <th></th>
    </tr>

        <tr>
            <td>86 (the band) - True Life Songs and Pictures</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="id" value="8601">
                    <input type="hidden" name="description" value="86 (the band) - True Life Songs and Pictures">
                    <input type="hidden" name="price" value="14.95">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The first CD</td>
            <td>$12.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="id" value="pf01">
                    <input type="hidden" name="description" value="Paddlefoot - The first CD">
                    <input type="hidden" name="price" value="12.95">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The second CD</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="id" value="pf02">
                    <input type="hidden" name="description" value="Paddlefoot - The second CD">
                    <input type="hidden" name="price" value="14.95">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Joe Rut - Genuine Wood Grained Finish</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="id" value="jr01">
                    <input type="hidden" name="description" value="Joe Rut - Genuine Wood Grained Finish">
                    <input type="hidden" name="price" value="14.95">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
    </table>
</body>

</html>