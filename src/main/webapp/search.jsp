<%@ page import="com.example.deaneryoffice.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Search Students</title>
  <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<h2>Search Students</h2>
<form action="search" method="post">
  <label for="lastName">Search by Last Name:</label>
  <input type="text" id="lastName" name="lastName">
  <button type="submit" name="searchType" value="byLastName">Search</button>

  <label for="groupName">Search by Group Name:</label>
  <input type="text" id="groupName" name="groupName">
  <button type="submit" name="searchType" value="byGroupName">Search</button>
</form>

<%
  List<Student> searchResults = (List<Student>) request.getAttribute("searchResults");
  if (searchResults != null) {
%>
<h3>Search Results:</h3>
<ul>
  <% for (Student student : searchResults) { %>
  <li><%= student.getFirstName() %> <%= student.getLastName() %> - <%= student.getGroup().getName() %></li>
  <% } %>
</ul>
<% } %>
</body>
</html>
