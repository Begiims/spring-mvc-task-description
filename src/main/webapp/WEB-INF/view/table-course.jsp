<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.04.2023
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--private Long id;
    private String courseName;
    private String duration;--%>
<table border="2px">
    <th>id</th>
    <th>course name</th>
    <th>course duration</th>
    <th>teacher</th>
    <c:forEach items="${find}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.courseName}</td>
            <td>${c.duration}</td>
            <td>
                <button>
                    <a href="/teacher/find/${c.id}">
                        teacher
                    </a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/course/courseForm/${ids}">save course</a></button>
<button><a href="/">back</a></button>
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