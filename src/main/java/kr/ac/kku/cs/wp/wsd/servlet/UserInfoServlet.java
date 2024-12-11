package kr.ac.kku.cs.wp.wsd.servlet;

import kr.ac.kku.cs.wp.wsd.dao.UserDAO;
import kr.ac.kku.cs.wp.wsd.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("userInfo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        user.setName(request.getParameter("name"));
        // 다른 필드 업데이트

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.updateUser(user);
            session.setAttribute("user", user);
            response.sendRedirect("userInfo.jsp");
        } catch (SQLException e) {
            throw new ServletException("사용자 정보 업데이트 오류", e);
        }
    }
}
