package com.amarant.zorgwijzerbackend.mapper;

import com.amarant.zorgwijzerbackend.dtos.ReminderUnsuccessfulAppointmentDTO;
import com.amarant.zorgwijzerbackend.models.ReminderUnsuccessfulAppointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RUAMapper {
    RUAMapper INSTANCE = Mappers.getMapper(RUAMapper.class);
    ReminderUnsuccessfulAppointment DTOtoReminderUnsuccessfulAppointment(ReminderUnsuccessfulAppointmentDTO dto);
    ReminderUnsuccessfulAppointmentDTO ReminderUnsuccessfulAppointmentToDto(ReminderUnsuccessfulAppointment unsuccessfulAppointment);
}
