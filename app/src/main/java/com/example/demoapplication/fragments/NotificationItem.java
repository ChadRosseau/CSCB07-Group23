package com.example.demoapplication.fragments;

public class NotificationItem {
    private String title;
    private String type;
    private String timestamp;
    private String content;

    public NotificationItem(String title, String type, String timestamp, String content) {
        this.title = title;
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
    public String getType() { return type; }
    public String getTimestamp() {return timestamp; }
    public String getContent() {
        return content;
    }
}
