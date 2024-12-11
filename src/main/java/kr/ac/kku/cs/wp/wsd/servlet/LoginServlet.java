package kr.ac.kku.cs.wp.wsd.servlet;

import kr.ac.kku.cs.wp.wsd.dao.UserDAO;
import kr.ac.kku.cs.wp.wsd.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("userInfo.jsp");
            } else {
                request.setAttribute("error", "잘못된 사용자명 또는 비밀번호입니다.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("데이터베이스 오류", e);
        }
    }
}
