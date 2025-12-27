package com.amarant.zorgwijzerbackend.dtos;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;

public class AppointmentDTO {
    public String id;
    public String activity;
    public String client;
    public Date dateTime;
    public Integer duration;
    public String location;
    public String priority;
    public boolean isCompleted;
}
