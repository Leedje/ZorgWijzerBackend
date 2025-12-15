package com.amarant.zorgwijzerbackend.models;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Reminder {

    public Reminder() {}

    private UUID id = UUID.randomUUID();
    private String title;
    private String description;
    private Date timeSent;
    private Date appointmentTime;

    List<Appointment> appointments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
