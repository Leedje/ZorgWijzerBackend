package com.amarant.zorgwijzerbackend.controllers;

import com.amarant.zorgwijzerbackend.dtos.ReminderDTO;
import com.amarant.zorgwijzerbackend.dtos.ReminderUnsuccessfulAppointmentDTO;
import com.amarant.zorgwijzerbackend.repository.ReminderRepository;
import com.amarant.zorgwijzerbackend.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController
{
    @Autowired
    ReminderService reminderService;

    @GetMapping
    public ResponseEntity<List<ReminderDTO>> GetAllReminders() throws ExecutionException, InterruptedException{
        List<ReminderDTO> reminders = reminderService.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/unsuccessful-appointments")
    public ResponseEntity<List<ReminderUnsuccessfulAppointmentDTO>> GetUnsuccessfulAppointmentReminders() throws ExecutionException, InterruptedException{
        List<ReminderUnsuccessfulAppointmentDTO> unsuccessfulReminders = reminderService.getAllUnsuccessfulAppointmentReminders();
        return ResponseEntity.ok(unsuccessfulReminders);
    }
}
