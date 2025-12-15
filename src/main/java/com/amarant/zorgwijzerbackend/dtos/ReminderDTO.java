package com.amarant.zorgwijzerbackend.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReminderDTO {
    private UUID id;
    private String title;
    private String description;
    private Date timeSent;
    private Date appointmentTime;
    List<AppointmentDTO> appointments;
}
