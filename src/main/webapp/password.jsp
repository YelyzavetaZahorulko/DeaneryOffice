<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Password Page</title>
</head>
<body>
<h1>Password Page</h1>
<form action="auth" method="post">
  <input type="hidden" name="userType" value="<%= request.getParameter("userType") %>">
  <label for="password">Enter your password:</label><br>
  <input type="password" id="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
