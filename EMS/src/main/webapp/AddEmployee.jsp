<%
    String role = (String) session.getAttribute("role");

    if(role == null || !role.equals("admin")){
        response.sendRedirect("error.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee | EMS</title>
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>

<div class="container">
    <h2>Employee Management System</h2>

    <form action="AddEmployee" method="post">
        <div class="input-group">
            <label>Employee Name</label>
            <input type="text" name="name" placeholder="Enter name" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email" placeholder="Enter email" required>
        </div>

        <div class="input-group">
            <label>Department</label>
            <input type="text" name="department" placeholder="Enter department" required>
        </div>

        <div class="input-group">
            <label>Salary</label>
            <input type="number" name="salary" placeholder="Enter salary" required>
        </div>

        <div class="input-group">
             <label>phone</label>
             <input type="text" name="phone" placeholder="Enter Phone" required>
        </div>

        <button type="submit">Add Employee</button>
    </form>
</div>

</body>
</html>