<%@ page import="Models.Hoadon" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/7/2022
  Time: 8:40 PM
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

<div align="center">
    <h2>
          dang xuat va quay lai trang chu
        <a href="/index.jsp">Back to home</a>
    </h2>
    <h2>
        Thong tin hoa don
    </h2>
    <table border="1" cellpadding="5">
        <caption><h4>Thank you for ordered</h4></caption>
        <tr>
            <th>ID HD</th>
            <th>Ngay xuat HD</th>
            <th>Ten KH</th>
            <th>Ten SP</th>
            <th>Gia</th>
            <th>So luong</th>
            <th>Tong tien</th>
        </tr>
        <tr>
            <td><input type="text" name="idhd" id="idhd" value="${hoadon.idhd}" disabled></td>
            <td><input type="text" name="ngxuathd" id="ngxuathd" value="${hoadon.ngxuathd}" disabled></td>
            <td><input type="text" name="ten" id="ten" value="${hoadon.ten}" disabled></td>
            <td>
                <c:forEach var="list" items="${list}">
                    <input type="text" name="tensp" value="${list.getTensp()}" disabled><br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="list" items="${list}">
                    <input type="text" name="gia" value="${list.getGia()}" disabled><br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="list" items="${list}">
                    <input type="text" name="sl" value="${list.getSl()}" disabled><br/>
                </c:forEach>
            </td>
            <td><input type="text" name="trigia" id="trigia" value="${hoadon.trigia}" disabled></td>
        </tr>
    </table>
</div>
</body>
</html>

