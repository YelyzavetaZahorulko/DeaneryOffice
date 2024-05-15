<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Форма Реєстрації</title>
</head>
<body>
<h2>Форма Реєстрації</h2>
<form action="/registration-servlet" method="POST">
    Ім'я: <label>
    <input type="text" name="name" required>
</label><br>
    Прізвище: <label>
    <input type="text" name="surname" required>
</label><br>
    Емейл: <input type="email" name="email" required><br>
    Пароль: <input type="password" name="password" required><br>
    <input type="submit" value="Реєструватися">
</form>
<html>