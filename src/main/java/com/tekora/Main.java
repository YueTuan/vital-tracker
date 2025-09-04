package com.tekora;

import com.tekora.model.Patient;
import com.tekora.service.PatientService;
import com.tekora.service.VitalProcessor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PatientService patientService = new PatientService();

        Patient p1 = Patient.builder().id("P001").name("Juan Perez").age(45).room("A101").build();
        Patient p2 = Patient.builder().id("P002").name("Maria Lopez").age(60).room("A102").build();

        patientService.registerPatient(p1);
        patientService.registerPatient(p2);

        patientService.getPatientVitals("P001").subscribe(
                data -> System.out.println(">> " + data),
                error -> System.err.println("Error: " + error)
        );

        patientService.getPatientVitals("P002").subscribe(
                data -> System.out.println(">> " + data),
                error -> System.err.println("Error: " + error)
        );

        Thread.sleep(20000);
    }
}