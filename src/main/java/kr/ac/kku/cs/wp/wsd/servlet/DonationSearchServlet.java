package kr.ac.kku.cs.wp.wsd.servlet;

import kr.ac.kku.cs.wp.wsd.dao.DonationDAO;
import kr.ac.kku.cs.wp.wsd.dao.RecipientDAO;
import kr.ac.kku.cs.wp.wsd.model.Donation;
import kr.ac.kku.cs.wp.wsd.model.Recipient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DonationSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String certificateNumber = request.getParameter("certificateNumber");
        DonationDAO donationDAO = new DonationDAO();
        RecipientDAO recipientDAO = new RecipientDAO();

        try {
            Donation donation = donationDAO.getDonationByCertificateNumber(certificateNumber);
            if (donation != null) {
                Recipient recipient = recipientDAO.getRecipientById(donation.getRecipientId());
                request.setAttribute("donation", donation);
                request.setAttribute("recipient", recipient);
            } else {
                request.setAttribute("error", "해당 증서 번호의 헌혈 정보를 찾을 수 없습니다.");
            }
        } catch (SQLException e) {
            throw new ServletException("데이터베이스 오류", e);
        }

        request.getRequestDispatcher("donationSearch.jsp").forward(request, response);
    }
}
