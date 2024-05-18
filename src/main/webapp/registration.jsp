<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Форма Реєстрації</title>
  <link rel="stylesheet" href="main.css">
</head>
<body>
<div class="form-container">
  <h2>Форма реєстрації</h2>
  <form action="register" method="POST" class="registration-form">
    <div class="form-group">
      <label for="name">Ім'я:</label>
      <input type="text" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="surname">Прізвище:</label>
      <input type="text" id="surname" name="surname" required>
    </div>
    <div class="form-group">
      <label for="email">Емейл:</label>
      <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="password">Пароль:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <div class="form-group">
      <input type="submit" value="Реєструватися">
    </div>
  </form>
</div>
</body>
</html>