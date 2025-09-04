package com.tekora.service;

import com.tekora.model.VitalReading;
import com.tekora.sensor.BodyTempSensor;
import com.tekora.sensor.HeartRateSensor;
import com.tekora.sensor.OxygenSensor;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.time.LocalDateTime;

public class VitalProcessor {

    private final HeartRateSensor heartRateSensor = new HeartRateSensor();
    private final OxygenSensor oxygenSensor = new OxygenSensor();
    private final BodyTempSensor bodyTempSensor = new BodyTempSensor();
    private final AlertService alertService = new AlertService();

    public Observable<String> getCombinedStream() {
        return Observable.combineLatest(
                heartRateSensor.getStream(),
                oxygenSensor.getStream(),
                bodyTempSensor.getStream(),
                (heart, oxygen, temp) -> {
                    String status = String.format(
                            "[%s] HR=%.1f %s | O₂=%.1f%s | Temp=%.1f %s",
                            LocalDateTime.now(),
                            heart.getValue(), heart.getUnit(),
                            oxygen.getValue(), oxygen.getUnit(),
                            temp.getValue(), temp.getUnit()
                    );

                    StringBuilder alerts = new StringBuilder();
                    for (VitalReading reading : new VitalReading[]{heart, oxygen, temp}) {
                        alertService.checkAlert(reading).ifPresent(
                                x -> alerts.append(" | ").append(x.getMessage())
                        );
                    }

                    return status + alerts.toString();
                }
        ).observeOn(Schedulers.computation());
    }

}
