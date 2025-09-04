package com.tekora.sensor;

import com.tekora.model.VitalReading;
import lombok.RequiredArgsConstructor;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class BodyTempSensor {

    public Observable<VitalReading> getStream() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(x -> VitalReading.builder()
                        .sensorName("BodyTempSensor")
                        .value(this.generateBodyTemp())
                        .unit("°C")
                        .type("BodyTemp")
                        .timestamp(LocalDateTime.now())
                        .build()
                )
                .subscribeOn(Schedulers.io());
    }

    private double generateBodyTemp() {
        return 36 + Math.random() * 4;
    }

}
