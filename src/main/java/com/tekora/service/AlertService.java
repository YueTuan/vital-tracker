package com.tekora.service;

import com.tekora.model.Alert;
import com.tekora.model.VitalReading;

import java.util.Optional;

public class AlertService {

    public Optional<Alert> checkAlert(VitalReading reading) {
        switch (reading.getType()) {
            case "HeartRate":
                if (reading.getValue() > 100) {
                    return Optional.of(
                            Alert.builder()
                                    .type("HeartRate")
                                    .message("Taquicardia detectada")
                                    .value(reading.getValue())
                                    .unit(reading.getUnit())
                                    .severity("HIGH")
                                    .build()
                    );
                }
                break;
            case "Oxygen":
                if (reading.getValue() < 92) {
                    return Optional.of(Alert.builder()
                            .type("Oxygen")
                            .message("Hipoxia detectada")
                            .value(reading.getValue())
                            .unit(reading.getUnit())
                            .severity("MEDIUM")
                            .build());
                }
                break;
            case "BodyTemp":
                if (reading.getValue() > 38) {
                    return Optional.of(Alert.builder()
                            .type("BodyTemp")
                            .message("Fiebre detectada")
                            .value(reading.getValue())
                            .unit(reading.getUnit())
                            .severity("HIGH")
                            .build());
                }
                break;
        }
        return Optional.empty();
    }

}
