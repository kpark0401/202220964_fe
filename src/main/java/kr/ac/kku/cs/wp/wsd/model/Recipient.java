package kr.ac.kku.cs.wp.wsd.model;

import java.util.Date;

public class Recipient {
    private int recipientId;
    private String name;
    private Date receivedDate;

    // Getters and setters
    public int getRecipientId() { return recipientId; }
    public void setRecipientId(int recipientId) { this.recipientId = recipientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getReceivedDate() { return receivedDate; }
    public void setReceivedDate(Date receivedDate) { this.receivedDate = receivedDate; }
}
