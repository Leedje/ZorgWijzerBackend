package com.amarant.zorgwijzerbackend.models;


import com.google.cloud.firestore.DocumentSnapshot;

import java.util.Date;
import java.util.List;

public class Reminder {

    public Reminder() {}

    private String id;
    private String title;
    private String activity;
    private String description;
    private String client;
    private Date timeCreated;
    private Date appointmentTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
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

    public static Reminder fromDocument(DocumentSnapshot doc) {
        Reminder reminder = new Reminder();

        reminder.setId(doc.getId());
        reminder.setTitle(doc.getString("Titel"));
        reminder.setActivity(doc.getString("Activiteit"));
        reminder.setClient(doc.getString("Client"));
        reminder.setTimeCreated(doc.getDate("DatumTijdAfspraak"));
        reminder.setAppointmentTime(doc.getDate("tijdReminderGemaakt"));
        reminder.setDescription(doc.getString("Beschrijving"));
        return reminder;
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
}
