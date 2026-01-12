package com.amarant.zorgwijzerbackend.models;

import com.google.cloud.firestore.DocumentSnapshot;
import java.util.Date;

public class ReminderUnsuccessfulAppointment {
    private String id;
    private String activity;
    private String caller;
    private String category;
    private String client;
    private Date dateTime;
    private Integer duration;
    private String instruction;
    private boolean completed;
    private String location;
    private Integer staff;

    private String phoneNumber;
    private String urgency;
    private String priority;

    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }

    public String getCaller() { return caller; }
    public void setCaller(String caller) { this.caller = caller; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public Date getDateTime() { return dateTime; }
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public String getInstruction() { return instruction; }
    public void setInstruction(String instruction) { this.instruction = instruction; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getStaff() { return staff; }
    public void setStaff(Integer staff) { this.staff = staff; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getUrgency() { return urgency; }
    public void setUrgency(String urgency) { this.urgency = urgency; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public static ReminderUnsuccessfulAppointment fromDocument(DocumentSnapshot doc) {
        ReminderUnsuccessfulAppointment reminder = new ReminderUnsuccessfulAppointment();

        reminder.setId(doc.getId());
        reminder.setActivity(doc.getString("Activiteit"));
        reminder.setCaller(doc.getString("Beller"));
        reminder.setCategory(doc.getString("Categorie"));
        reminder.setClient(doc.getString("Client"));
        reminder.setDateTime(doc.getDate("Datum & Tijd"));

        Long durationValue = doc.getLong("Duur");
        if (durationValue != null) {
            reminder.setDuration(durationValue.intValue());
        }

        reminder.setInstruction(doc.getString("Instructie"));

        Boolean completedValue = doc.getBoolean("IsAfgerond");
        reminder.setCompleted(completedValue != null && completedValue);

        reminder.setLocation(doc.getString("Locatie"));

        Long staffValue = doc.getLong("Personeel");
        if (staffValue != null) {
            reminder.setStaff(staffValue.intValue());
        }

        reminder.setPhoneNumber(doc.getString("Telefoonnummer"));
        reminder.setUrgency(doc.getString("Urgentie"));
        reminder.setPriority(doc.getString("Zwaarte"));

        return reminder;
    }
}