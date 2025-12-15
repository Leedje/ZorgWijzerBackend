package com.amarant.zorgwijzerbackend.repository;

import com.amarant.zorgwijzerbackend.models.Appointment;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
public class AppointmentRepository {

        private final Firestore firestore;

        public AppointmentRepository(Firestore firestore) {
            this.firestore = firestore;
        }

        public void save(Appointment appointment) throws ExecutionException, InterruptedException {
            firestore.collection("Appointment")
                    .document(appointment.getId().toString())
                    .set(appointment)
                    .get();
        }

        public Appointment findById(UUID id) throws ExecutionException, InterruptedException {
            DocumentReference docRef = firestore.collection("Appointment").document(id.toString());
            DocumentSnapshot snapshot = docRef.get().get();
            return snapshot.exists() ? snapshot.toObject(Appointment.class) : null;
        }

        public List<Appointment> getAllAppointments() throws ExecutionException, InterruptedException {
            return firestore.collection("Appointment")
                    .get()
                    .get()
                    .getDocuments()
                    .stream()
                    .map(doc -> doc.toObject(Appointment.class))
                    .toList();
        }

}
