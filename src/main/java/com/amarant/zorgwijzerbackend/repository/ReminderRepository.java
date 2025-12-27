package com.amarant.zorgwijzerbackend.repository;

import com.amarant.zorgwijzerbackend.models.Appointment;
import com.amarant.zorgwijzerbackend.models.Reminder;
import com.amarant.zorgwijzerbackend.models.ReminderUnsuccessfulAppointment;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Repository
public class ReminderRepository {

    private final Firestore firestore;

    public ReminderRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public List<ReminderUnsuccessfulAppointment> getAllUnsuccessfulAppointmentReminders() throws ExecutionException, InterruptedException {
        return firestore.collection("ReminderPotentieleAfspraak")
                .get()
                .get()
                .getDocuments()
                .stream()
                .map(ReminderUnsuccessfulAppointment::fromDocument).collect(Collectors.toList());

    }

    public List<Reminder>getAllReminders() throws ExecutionException, InterruptedException {
        return firestore.collection("Reminders")
                .get()
                .get()
                .getDocuments()
                .stream()
                .map(Reminder::fromDocument)
                .collect(Collectors.toList());
    }

}
