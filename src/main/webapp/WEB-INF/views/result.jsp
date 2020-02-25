<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>

</head>
<body>
<div>
    <table border="3">
        <tr>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>root 1</th>
            <th>root 2</th>
        </tr>
        <tr>
            <td>
                <h3>${root.valueA}</h3>
            </td>
            <td>
                <h3>${root.valueB}</h3>
            </td>
            <td>
                <h3>${root.valueC}</h3>
            </td>
            <td>
                <h3>${root.root1}</h3>
            </td>
            <td>
                <h3>${root.root2}</h3>
            </td>
        </tr>
    </table>
</div>
</body>
</html>