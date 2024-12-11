package kr.ac.kku.cs.wp.wsd.dao;

import kr.ac.kku.cs.wp.wsd.model.Donation;
import kr.ac.kku.cs.wp.wsd.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAO {
    public Donation getDonationByCertificateNumber(String certificateNumber) throws SQLException {
        String sql = "SELECT * FROM donations WHERE certificate_number = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, certificateNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Donation donation = new Donation();
                    donation.setDonationId(rs.getInt("donation_id"));
                    donation.setUserId(rs.getInt("user_id"));
                    donation.setCertificateNumber(rs.getString("certificate_number"));
                    donation.setDonationDate(rs.getDate("donation_date"));
                    donation.setDonationType(rs.getString("donation_type"));
                    donation.setBloodAmount(rs.getInt("blood_amount"));
                    donation.setRecipientId(rs.getInt("recipient_id"));
                    donation.setCreatedAt(rs.getTimestamp("created_at"));
                    donation.setUpdatedAt(rs.getTimestamp("updated_at"));
                    return donation;
                }
            }
        }
        return null;
    }
 // Create (Insert)
    public void addDonation(Donation donation) throws SQLException {
        String sql = "INSERT INTO donations (user_id, certificate_number, donation_date, donation_type, blood_amount, recipient_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donation.getUserId());
            pstmt.setString(2, donation.getCertificateNumber());
            pstmt.setDate(3, new java.sql.Date(donation.getDonationDate().getTime()));
            pstmt.setString(4, donation.getDonationType());
            pstmt.setInt(5, donation.getBloodAmount());
            pstmt.setInt(6, donation.getRecipientId());
            pstmt.executeUpdate();
        }
    }

    // Read (Select All)
    public List<Donation> getAllDonations() throws SQLException {
        List<Donation> donations = new ArrayList<>();
        String sql = "SELECT * FROM donations";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Donation donation = new Donation();
                donation.setDonationId(rs.getInt("donation_id"));
                donation.setUserId(rs.getInt("user_id"));
                donation.setCertificateNumber(rs.getString("certificate_number"));
                donation.setDonationDate(rs.getDate("donation_date"));
                donation.setDonationType(rs.getString("donation_type"));
                donation.setBloodAmount(rs.getInt("blood_amount"));
                donation.setRecipientId(rs.getInt("recipient_id"));
                donation.setCreatedAt(rs.getTimestamp("created_at"));
                donation.setUpdatedAt(rs.getTimestamp("updated_at"));
                donations.add(donation);
            }
        }
        return donations;
    }

    // Update
    public void updateDonation(Donation donation) throws SQLException {
        String sql = "UPDATE donations SET user_id = ?, certificate_number = ?, donation_date = ?, donation_type = ?, blood_amount = ?, recipient_id = ? WHERE donation_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donation.getUserId());
            pstmt.setString(2, donation.getCertificateNumber());
            pstmt.setDate(3, new java.sql.Date(donation.getDonationDate().getTime()));
            pstmt.setString(4, donation.getDonationType());
            pstmt.setInt(5, donation.getBloodAmount());
            pstmt.setInt(6, donation.getRecipientId());
            pstmt.setInt(7, donation.getDonationId());
            pstmt.executeUpdate();
        }
    }

    // Delete
    public void deleteDonation(int donationId) throws SQLException {
        String sql = "DELETE FROM donations WHERE donation_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donationId);
            pstmt.executeUpdate();
        }
    }
}
