<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ems.model.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="css/view.css">
</head>
<body>

<div class="page-bg">
    <div class="card">
        <h2>Edit Employee</h2>

        <form action="EditEmployee" method="post">

            <input type="hidden" name="id" value="<%= emp.getId() %>">

            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" value="<%= emp.getName() %>" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" value="<%= emp.getEmail() %>" required>
            </div>

            <div class="form-group">
                <label>Department</label>
                <input type="text" name="department" value="<%= emp.getDepartment() %>" required>
            </div>

            <div class="form-group">
                <label>Salary</label>
                <input type="number" step="0.01" name="salary"
                       value="<%= emp.getSalary() %>" required>
            </div>

            <button type="submit" class="btn">Update Employee</button>

            <a href="ViewEmployee" class="back-link">← Back</a>
        </form>
    </div>
</div>

</body>
</html>