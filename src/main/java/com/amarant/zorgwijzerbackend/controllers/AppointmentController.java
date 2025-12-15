package com.amarant.zorgwijzerbackend.controllers;

import com.amarant.zorgwijzerbackend.dtos.AppointmentDTO;
import com.amarant.zorgwijzerbackend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateAppointment(@RequestBody AppointmentDTO appointment){

        try {
            appointmentService.createAppointment(appointment);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> GetAllAppointments() throws ExecutionException, InterruptedException {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);

    }
}
