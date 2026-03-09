package com.ems.servlet;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ViewEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees;

        if (keyword == null || keyword.trim().isEmpty()) {
            employees = dao.getAllEmployee();
        }
        
        else {
            try {
                int id = Integer.parseInt(keyword);
                Employee emp = dao.getEmployeeById(id);
                employees = new ArrayList<>();
                if (emp != null) {
                    employees.add(emp);
                }
            } catch (NumberFormatException e) {
                employees = dao.getEmployeesByName(keyword);
            }
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("ViewEmployee.jsp")
                .forward(request, response);
    }

}
