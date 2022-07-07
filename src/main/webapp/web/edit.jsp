<%--
  Created by IntelliJ IDEA.
  User: Tinh Chu
  Date: 7/6/2022
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test="${message} !=null">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/sanpham">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="id" id="id" value="${requestScope["sanpham"].getIdsp()}" hidden></td>
            </tr>
            <tr>
                <td>NameP: </td>
                <td><input type="text" name="tensp" id="tensp" value="${requestScope["sanpham"].getTensp()}"></td>
            </tr>
            <tr>
                <td>Unit: </td>
                <td><input type="text" name="dvt" id="dvt" value="${requestScope["sanpham"].getDvt()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="mota" id="mota" value="${requestScope["sanpham"].getMota()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="gia" id="gia" value="${requestScope["sanpham"].getGia()}"></td>
            </tr>
            <tr>
                <td>Image: </td>
                <td><input type="text" name="img" id="img" value="${requestScope["sanpham"].getImg()}"></td>
            </tr>
           <tr>
                <td>Kind of Product: </td>
                <td><input type="text" name="loaisp" id="loaisp" value="${requestScope["sanpham"].getLoaisp()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>