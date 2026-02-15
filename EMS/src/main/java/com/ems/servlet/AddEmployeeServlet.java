package com.ems.servlet;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("== doPost called ==");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone= req.getParameter("phone");

        Employee emp =  new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setDepartment(department);
        emp.setSalary(salary);
        emp.setPhone(phone);

        EmployeeDAO dao = new EmployeeDAO();
        boolean status = dao.AddEmployee(emp);
        if (status) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}