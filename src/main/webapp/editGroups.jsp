<%@ page import="com.example.deaneryoffice.Group" %>
<%@ page import="com.example.deaneryoffice.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Manage Groups</title>
  <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<h3>Current Groups</h3>
<ul>
  <%
    List<Group> groups = (List<Group>) request.getAttribute("groups");
    if (groups != null) {
      for (Group group : groups) {
  %>
  <li>
    <%= group.getName() %>
    <ul>
      <%
        for (Student student : group.getStudents()) {
      %>
      <li><%= student.getFirstName() %> <%= student.getLastName() %></li>
      <%
        }
      %>
    </ul>
  </li>
  <%
    }
  } else {
  %>
  <li>No groups found.</li>
  <%
    }
  %>
</ul>

<h3>Add Group</h3>
<form action="editGroups" method="post">
  <label for="groupName">Group Name:</label>
  <input type="text" id="groupName" name="groupName">
  <button type="submit" name="action" value="addGroup">Add Group</button>
</form>

<h3>Add Student</h3>
<form action="editGroups" method="post">
  <label for="addStudentGroupName">Group Name:</label>
  <input type="text" id="addStudentGroupName" name="groupName">
  <label for="firstName">First Name:</label>
  <input type="text" id="firstName" name="firstName">
  <label for="lastName">Last Name:</label>
  <input type="text" id="lastName" name="lastName">
  <button type="submit" name="action" value="addStudent">Add Student</button>
</form>

<h3>Remove Student</h3>
<form action="editGroups" method="post">
  <label for="removeStudentGroupName">Group Name:</label>
  <input type="text" id="removeStudentGroupName" name="groupName">
  <label for="removeFirstName">First Name:</label>
  <input type="text" id="removeFirstName" name="firstName">
  <label for="removeLastName">Last Name:</label>
  <input type="text" id="removeLastName" name="lastName">
  <button type="submit" name="action" value="removeStudent">Remove Student</button>
</form>

<a href="index.jsp">Back to Home</a>
</body>
</html>
