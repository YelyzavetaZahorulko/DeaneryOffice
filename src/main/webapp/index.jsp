<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вхід</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<div class="login-container">
    <h2>Вхід</h2>
    <form action="login" method="post">
        <div class="login-group">
            <input type="text" name="username" placeholder="Ім'я користувача" required>
        </div>
        <div class="login-group">
            <input type="password" name="password" placeholder="Пароль" required>
        </div>
        <div class="login-group">
            <input type="submit" value="Увійти">
        </div>
    </form>
    <a href="registration.jsp">Реєстрація</a>
</div>
</body>
</html>