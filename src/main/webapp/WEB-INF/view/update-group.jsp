<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2023
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/update/${id}"method="post">
  <h1>groupName</h1>
  <input type="text" name="groupName" value="${group.groupName}">
  <h1>dataStart</h1>
  <input type = "text" name="dataStart" value="${group.dataStart}">
  <h1>dataFinish</h1>
  <input type = "text" name="dataFinish" value="${group.dataFinish}">
  <input type="submit" value="update Group">
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

  label {
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
