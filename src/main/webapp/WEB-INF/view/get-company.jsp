<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.04.2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${company.id}</h1>
<h1>${company.companyName}</h1>
<h1>${company.locatedCompany}</h1>
<button>
    <a href="/">
        back
    </a>
</button>
<style>
    .container {
        text-align: center;
    }

    button,
    a,
    h1 {
        display: inline-block; /* элементы в виде блоков */
        color: #800080; /* фиолетовый цвет текста */
        background-color: transparent; /* прозрачный фон */
        border: 2px solid #800080; /* фиолетовая рамка */
        border-radius: 4px; /* скругленные углы */
        padding: 10px; /* внутренний отступ */
        text-decoration: none; /* отключение подчеркивания для ссылок */
        font-size: 24px; /* размер шрифта */
        margin: 10px; /* внешний отступ */
    }

    button:hover,
    a:hover,
    h1:hover {
        background-color: #800080; /* при наведении - фиолетовый фон */
        color: #fff; /* белый цвет текста */
    }

    button:focus,
    a:focus,
    h1:focus {
        outline: none; /* убираем обводку при фокусе */
    }
</style>
</body>
</html>
