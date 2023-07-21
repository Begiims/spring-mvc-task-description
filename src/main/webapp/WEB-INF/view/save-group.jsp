<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.04.2023
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/saveGroups/${ids}" method="post">
    <h1>group name</h1>
    <input type="text" name="groupName">
    <h1>data start</h1>
    <input type="text" name="dataStart">
    <h1>data finish</h1>
    <input type="text" name="dataFinish">
    <c:forEach items="${course}" var="idCourse">
        <br>
        <br>
        <input type="radio" id="${idCourse.id}" name="idCourse" value="${idCourse.id}">
        <label for="${idCourse.id}">${idCourse.courseName}</label><br>
    </c:forEach>
    <input type="submit" value="save course">
</form>
<style>
    form {
        background-color: #f2f2f2;
        border: 1px solid #ccc;
        padding: 10px;
        width: 50%; /* ширина формы */
        margin: 0 auto; /* автоматически центрирует форму */
        text-align: center; /* выравнивание содержимого по центру */
    }

    h1 {
        margin: auto 0;
    }

    label {;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        text-align: left; /* выравнивание полей ввода по левому краю */

        display: block;
        font-weight: bold;
        color: #800080; /* фиолетовый цвет */
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        text-align: left; /* выравнивание полей ввода по левому краю */
        margin-bottom: 10px; /* отступ между полями ввода */
    }

    input[type="submit"] {
        background-color: #800080;
        color: #fff;
        padding: 5px 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #a64ca6; /* более темный оттенок фиолетового */
    }
</style>
</body>
</html>
