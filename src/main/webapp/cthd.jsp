<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/8/2022
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gio hang list</title>
</head>
<body class="container">
<center>
    <h1>Order List</h1>
</center>

<div>
    <h2>
        <a href="/giohang">Back to lich su</a>
    </h2>
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>IDSP</th>
                <th>TenSP</th>
                <th>Gia</th>
                <th>SL</th>
            </tr>
            <c:forEach var="gh" items="${list}">
                <tr>
                    <td><input type="text" name="idsp" id="idsp" value="${gh.idsp}" readonly></td>
                    <td><input type="text" name="tensp" id="tensp" value="${gh.tensp}" readonly></td>
                    <td><input type="text" name="gia" id="gia" value="${gh.gia}" readonly></td>
                    <td><input type="text" name="sl" id="sl" value="${gh.sl}" readonly></td>
                </tr>
            </c:forEach>

        </table>
    </form>


</div>
</body>
</html>
