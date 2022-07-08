
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit Information</h1>
<p>
    <c:if test="${message} !=null">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/login">Back to login</a>
</p>
<form method="post">
    <fieldset>
        <legend>Profile</legend>
        <table>
            <c:if test="${user != null}">
                <input type="text" name="id" value="<c:out value='${user.getIduser()}' />" hidden/>
            </c:if>
            <input type="text" name="tk" id="tk" value="${requestScope["user"].getTk()}" hidden/>
            <input type="text" name="mota" id="mota" value="${requestScope["user"].getChucvu()}" hidden/>

            <tr>
                <td>Full Name: </td>
                <td><input type="text" name="ten" id="ten" value="${requestScope["user"].getTen()}"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="mk" id="mk" value="${requestScope["user"].getMk()}"></td>
            </tr>

            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="sdt" id="sdt" value="${requestScope["user"].getSdt()}"></td>
            </tr>

            <tr>
                <td>Gender: </td>
                <td><input type="text" name="gioitinh" id="gioitinh" value="${requestScope["user"].getGioitinh()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>