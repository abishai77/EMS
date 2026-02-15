package com.ems.servlet;
import com.ems.dao.EmployeeDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAO();
        boolean deleted = dao.deleteEmployee(id);

        // After delete → go back to ViewEmployee
        response.sendRedirect("ViewEmployee");
    }
}