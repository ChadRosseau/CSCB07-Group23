package com.example.demoapplication.fragments;

public class NotificationItem {
    private String title;
    private String type;
    private String timestamp;
    private String content;
    private boolean isExpanded;
    private boolean isRead;

    public NotificationItem(String title, String type, String timestamp, String content) {
        this.title = title;
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
        this.isExpanded = false;
    }

    public String getTitle() {
        return title;
    }
    public String getType() { return type; }
    public String getTimestamp() {return timestamp; }
    public String getContent() {
        return content;
    }
    public boolean isExpanded() { return isExpanded; }
    public boolean isRead() { return isRead; }

    public void setContent(String content) { this.content = content; }
    public void setExpanded(boolean status) { this.isExpanded = status; }
    public void setRead(boolean status) { this.isRead = status; }
}
