package com.amarant.zorgwijzerbackend.services;

import com.amarant.zorgwijzerbackend.dtos.AppointmentDTO;
import com.amarant.zorgwijzerbackend.mapper.AppointmentMapper;
import com.amarant.zorgwijzerbackend.models.Appointment;
import com.amarant.zorgwijzerbackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public void createAppointment(AppointmentDTO appointmentDTO) throws ExecutionException, InterruptedException {
        appointmentRepository.save(appointmentMapper.DtoToAppointment(appointmentDTO));
    }

    public List<AppointmentDTO> getAllAppointments() throws ExecutionException, InterruptedException {
        return appointmentRepository.getAllAppointments()
                .stream()
                .map(appointmentMapper::AppointmentToDto)
                .collect(Collectors.toList());

    }
}
