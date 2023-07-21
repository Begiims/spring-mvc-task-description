<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2023
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>id</th>
    <th>email</th>
    <th>first name</th>
    <th>last name</th>
    <c:forEach items="${find}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.email}</td>
            <td>${f.firstName}</td>
            <td>${f.lastName}</td>
        </tr>
    </c:forEach>
</table>
<button>
    <a href="/teacher/saveForm/${id}">
        save teacher
    </a>
</button>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
        max-width: 600px;
        margin: 0 auto;
        background-color: #f5f5f5;
        font-family: Arial, sans-serif;
    }

    th, td {
        padding: 4px;
        text-align: left;
        border: 1px solid #ccc;
    }

    th {
        background-color: #8a2be2;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #dcdcdc;
    }

    tr:hover {
        background-color: #f0f0f0;
    }

    button, a {
        display: block;
        margin: 0 auto;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        color: #fff;
        background-color: #8a2be2;
        cursor: pointer;
    }

    button:hover, a:hover {
        background-color: #663399;
    }

</style>
</body>
</html>
