package kr.ac.kku.cs.wp.wsd.model;

import java.util.Date;

public class Donation {
    private int donationId;
    private int userId;
    private String certificateNumber;
    private Date donationDate;
    private String donationType;
    private int bloodAmount;
    private int recipientId;
    private Date createdAt;
    private Date updatedAt;

    // Getters and setters
    public int getDonationId() { return donationId; }
    public void setDonationId(int donationId) { this.donationId = donationId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getCertificateNumber() { return certificateNumber; }
    public void setCertificateNumber(String certificateNumber) { this.certificateNumber = certificateNumber; }

    public Date getDonationDate() { return donationDate; }
    public void setDonationDate(Date donationDate) { this.donationDate = donationDate; }

    public String getDonationType() { return donationType; }
    public void setDonationType(String donationType) { this.donationType = donationType; }

    public int getBloodAmount() { return bloodAmount; }
    public void setBloodAmount(int bloodAmount) { this.bloodAmount = bloodAmount; }

    public int getRecipientId() { return recipientId; }
    public void setRecipientId(int recipientId) { this.recipientId = recipientId; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
