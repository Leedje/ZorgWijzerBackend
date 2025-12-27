package com.amarant.zorgwijzerbackend.services;

import com.amarant.zorgwijzerbackend.dtos.ReminderDTO;
import com.amarant.zorgwijzerbackend.dtos.ReminderUnsuccessfulAppointmentDTO;
import com.amarant.zorgwijzerbackend.mapper.RUAMapper;
import com.amarant.zorgwijzerbackend.mapper.ReminderMapper;
import com.amarant.zorgwijzerbackend.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper;
    private final RUAMapper ruaMapper;

    public ReminderService(ReminderRepository reminderRepository, ReminderMapper reminderMapper, RUAMapper ruaMapper) {
        this.reminderRepository = reminderRepository;
        this.reminderMapper = reminderMapper;
        this.ruaMapper = ruaMapper;
    }

    public List<ReminderDTO> getAllReminders() throws ExecutionException, InterruptedException{
        return reminderRepository.getAllReminders()
                .stream()
                .map(reminderMapper::ReminderToDto)
                .collect(Collectors.toList());
    }

    public List<ReminderUnsuccessfulAppointmentDTO> getAllUnsuccessfulAppointmentReminders() throws ExecutionException, InterruptedException{
        return reminderRepository.getAllUnsuccessfulAppointmentReminders()
                .stream()
                .map(ruaMapper::ReminderUnsuccessfulAppointmentToDto)
                .collect(Collectors.toList());
    }
}
