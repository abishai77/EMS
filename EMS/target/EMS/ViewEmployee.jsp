<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ems.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List | EMS</title>
    <link rel="stylesheet" href="css/view.css">
</head>
<body>

<div class="page-bg">
    <div class="card">

        <h2>Employee List</h2>

        <!-- Search -->
        <form action="ViewEmployee" method="get" class="search-box">
            <input type="text" name="keyword" placeholder="Search by ID or Name">
            <button type="submit">Search</button>
        </form>

        <!-- Add employee -->
        <div class="add-link">
            <a href="AddEmployee.jsp">+ Add Employee</a>
        </div>

        <!-- Table -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
            <%
                List<Employee> employees =
                        (List<Employee>) request.getAttribute("employees");

                if (employees != null && !employees.isEmpty()) {
                    for (Employee e : employees) {
            %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getName() %></td>
                    <td><%= e.getEmail() %></td>
                    <td><%= e.getDepartment() %></td>
                    <td><%= e.getSalary() %></td>
                    <td class="action">
                        <a class="edit" href="EditEmployee?id=<%= e.getId() %>">Edit</a>
                        <a class="delete" href="DeleteEmployee?id=<%= e.getId() %>"
                           onclick="return confirm('Delete this employee?')">Delete</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="no-data">No employees found</td>
                </tr>
            <% } %>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>