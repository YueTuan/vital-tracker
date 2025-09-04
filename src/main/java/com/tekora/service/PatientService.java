package com.tekora.service;

import com.tekora.model.Patient;
import rx.Observable;

import java.nio.channels.IllegalChannelGroupException;
import java.util.HashMap;
import java.util.Map;

public class PatientService {

    private final Map<String, VitalProcessor> patientProcessors = new HashMap<>();

    public void registerPatient(Patient patient) {
        patientProcessors.put(patient.getId(), new VitalProcessor());
        System.out.println("Paciente registrado: " + patient.getName());
    }

    public Observable<String> getPatientVitals(String patientId) {
        VitalProcessor processor = patientProcessors.get(patientId);
        if (processor == null) {
            return Observable.error(new IllegalArgumentException(
                    "Paciente no encontrado: " + patientId
            ));
        }
        return processor.getCombinedStream()
                .map(x -> "[Paciente " + patientId + "] " + x);
    }

}
