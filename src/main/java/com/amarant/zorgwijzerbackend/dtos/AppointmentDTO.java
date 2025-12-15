package com.amarant.zorgwijzerbackend.dtos;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;

public class AppointmentDTO {
    UUID id;
    String title;
    String resident;
    Date dateTime;
    Duration duration; // can be estimated by the AI
    String location;
}
