<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="/calculate" method="post">
    <input type="number" placeholder="A" name="a" required> *X^2 +
    <input type="number" placeholder="B" name="b" required> *X +
    <input type="number" placeholder="C" name="c" required> = 0
    <br>
    <br>
    <button>Calculate</button>

</form>
</body>
</html>
