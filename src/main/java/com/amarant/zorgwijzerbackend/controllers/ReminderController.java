package com.amarant.zorgwijzerbackend.controllers;

import com.amarant.zorgwijzerbackend.dtos.ReminderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReminderController
{
    @GetMapping("/reminders")
    public ResponseEntity<List<ReminderDTO>> GetAllReminders(){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/reminders/create")
    public ResponseEntity<Boolean> CreateReminder(@RequestBody ReminderDTO reminderDTO){

        return ResponseEntity.ok(false);
    }

}
