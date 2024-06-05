<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="main.css"> <!-- Підключаємо стилі -->
</head>
<body>
<h2>Login Page</h2>
<form action="auth" method="post">
    <label for="student">Student</label>
    <input type="radio" id="student" name="userType" value="student"><br>
    <label for="employee">Employee</label>
    <input type="radio" id="employee" name="userType" value="employee"><br><br>
    <!-- Додано поле для введення пароля -->
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
