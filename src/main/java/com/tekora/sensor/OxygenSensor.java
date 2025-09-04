package com.tekora.sensor;

import com.tekora.model.VitalReading;
import lombok.RequiredArgsConstructor;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class OxygenSensor {

    public Observable<VitalReading> getStream() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(x -> VitalReading.builder()
                        .sensorName("OxygenSensor")
                        .value(this.generateOxygenLevel())
                        .unit("%")
                        .type("Oxygen")
                        .timestamp(LocalDateTime.now())
                        .build()
                )
                .subscribeOn(Schedulers.io());
    }

    private double generateOxygenLevel() {
        return 90 + Math.random() * 10;
    }

}

