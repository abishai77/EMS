package com.ems.servlet;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/EditEmployee")
public class EditEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = dao.getEmployeeById(id);

        request.setAttribute("employee", emp);
        request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employee emp = new Employee();
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));
        emp.setPhone(request.getParameter("phone"));
        EmployeeDAO dao = new EmployeeDAO();
        dao.updateEmployee(emp);

        response.sendRedirect("ViewEmployee");
    }
}