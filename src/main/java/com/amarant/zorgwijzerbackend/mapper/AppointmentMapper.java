package com.amarant.zorgwijzerbackend.mapper;

import com.amarant.zorgwijzerbackend.dtos.AppointmentDTO;
import com.amarant.zorgwijzerbackend.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);
    Appointment DtoToAppointment(AppointmentDTO dto);
    AppointmentDTO AppointmentToDto(Appointment appointment);

}
