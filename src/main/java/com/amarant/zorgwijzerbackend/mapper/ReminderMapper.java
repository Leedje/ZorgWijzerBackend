package com.amarant.zorgwijzerbackend.mapper;

import com.amarant.zorgwijzerbackend.dtos.ReminderDTO;
import com.amarant.zorgwijzerbackend.models.Reminder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReminderMapper
{
    ReminderMapper INSTANCE = Mappers.getMapper(ReminderMapper.class);
    Reminder DtoToReminder(ReminderDTO dto);
    ReminderDTO ReminderToDto(Reminder reminder);

}
