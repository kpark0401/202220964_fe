package kr.ac.kku.cs.wp.wsd.servlet;

import kr.ac.kku.cs.wp.wsd.dao.UserDAO;
import kr.ac.kku.cs.wp.wsd.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        try {
            user.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthdate")));
        } catch (ParseException e) {
            throw new ServletException("날짜 형식 오류", e);
        }
        user.setGender(request.getParameter("gender"));
        user.setRole("USER");

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser(user);
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            throw new ServletException("사용자 등록 오류", e);
        }
    }
}
