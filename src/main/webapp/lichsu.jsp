<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/8/2022
  Time: 11:29 AM
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
        <a href="/index.jsp">Back to home</a>
    </h2>
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>IDHD</th>
                <th>Ngay xuat HD</th>
                <th>Ten KH</th>
                <th>Tong tien</th>
                <th>Chi tiet</th>
            </tr>
            <c:forEach var="hd" items="${list}">
                <tr>
                    <td><input type="text" name="idhd" id="idhd" value="${hd.idhd}" readonly></td>
                    <td><input type="text" name="ngxuathd" id="ngxuathd" value="${hd.ngxuathd}" readonly></td>
                    <td><input type="text" name="ten" id="ten" value="${hd.ten}" readonly></td>
                    <td><input type="text" name="trigia" id="trigia" value="${hd.trigia}" readonly></td>
                    <td><a href="/giohang?order=chitiet&idhdct=${hd.idhd}">Chi tiet</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>


</div>
</body>
</html>

