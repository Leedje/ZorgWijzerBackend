package com.amarant.zorgwijzerbackend.models;
import com.google.cloud.firestore.annotation.PropertyName;
import com.google.cloud.firestore.DocumentSnapshot;

import java.time.Duration;
import java.util.Date;

public class Appointment {

    public Appointment () {};

    private String id;
    private String activity;
    private String client;
    private Date dateTime;
    private Integer duration;
    private String location;
    private String priority;
    private boolean isCompleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getDuration() {
        return duration;
    }

    private void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public static Appointment fromDocument(DocumentSnapshot doc) {
        Appointment appointment = new Appointment();
        appointment.setId(doc.getId()); // Firestore document ID
        appointment.setActivity(doc.getString("Activiteit"));
        appointment.setClient(doc.getString("Client"));
        appointment.setDateTime(doc.getDate("Datum & Tijd"));
        Long durationValue = doc.getLong("Duur");
        if (durationValue != null) {
            appointment.setDuration(durationValue.intValue());
        }
        appointment.setLocation(doc.getString("Locatie"));
        appointment.setPriority(doc.getString("Zwaarte"));
        Boolean completedValue = doc.getBoolean("isAfgerond");
        appointment.setCompleted(completedValue != null && completedValue);

        return appointment;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}