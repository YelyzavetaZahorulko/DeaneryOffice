<%@ page import="com.example.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результати пошуку</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Результати пошуку</h1>

    <% List<Student> searchResults = (List<Student>) request.getAttribute("searchResults"); %>
    <% if (searchResults != null && !searchResults.isEmpty()) { %>
    <table border="1">
        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Група</th>
        </tr>
        </thead>
        <tbody>
        <% for (Student student : searchResults) { %>
        <tr>
            <td><%= student.getFirstName() %></td>
            <td><%= student.getLastName() %></td>
            <td><%= student.getGroup() != null ? student.getGroup().getName() : "Без Групи" %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Результатів не знайдено.</p>
    <% } %>

    <a href="${pageContext.request.contextPath}/student">Повернутися до панелі студента</a>
</div>
</body>
</html>

