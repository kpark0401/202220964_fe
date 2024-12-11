package kr.ac.kku.cs.wp.wsd.dao;

import kr.ac.kku.cs.wp.wsd.model.Recipient;
import kr.ac.kku.cs.wp.wsd.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipientDAO {
    public Recipient getRecipientById(int recipientId) throws SQLException {
        String sql = "SELECT * FROM recipients WHERE recipient_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, recipientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Recipient recipient = new Recipient();
                    recipient.setRecipientId(rs.getInt("recipient_id"));
                    recipient.setName(rs.getString("name"));
                    recipient.setReceivedDate(rs.getDate("received_date"));
                    return recipient;
                }
            }
        }
        return null;
    }

    // Create (Insert)
    public void addRecipient(Recipient recipient) throws SQLException {
        String sql = "INSERT INTO recipients (name, received_date) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recipient.getName());
            pstmt.setDate(2, new java.sql.Date(recipient.getReceivedDate().getTime()));
            pstmt.executeUpdate();
        }
    }

    // Read (Select All)
    public List<Recipient> getAllRecipients() throws SQLException {
        List<Recipient> recipients = new ArrayList<>();
        String sql = "SELECT * FROM recipients";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Recipient recipient = new Recipient();
                recipient.setRecipientId(rs.getInt("recipient_id"));
                recipient.setName(rs.getString("name"));
                recipient.setReceivedDate(rs.getDate("received_date"));
                recipients.add(recipient);
            }
        }
        return recipients;
    }

    // Update
    public void updateRecipient(Recipient recipient) throws SQLException {
        String sql = "UPDATE recipients SET name = ?, received_date = ? WHERE recipient_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recipient.getName());
            pstmt.setDate(2, new java.sql.Date(recipient.getReceivedDate().getTime()));
            pstmt.setInt(3, recipient.getRecipientId());
            pstmt.executeUpdate();
        }
    }

    // Delete
    public void deleteRecipient(int recipientId) throws SQLException {
        String sql = "DELETE FROM recipients WHERE recipient_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, recipientId);
            pstmt.executeUpdate();
        }
    }
}
