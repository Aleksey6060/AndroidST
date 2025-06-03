package com.example.eventdiary;

public class Event {
    private String title;
    private String date;
    private String priority;
    private long eventTime; // Время события в миллисекундах

    public Event(String title, String date, String priority, long eventTime) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.eventTime = eventTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getPriority() {
        return priority;
    }

    public long getEventTime() {
        return eventTime;
    }
}
