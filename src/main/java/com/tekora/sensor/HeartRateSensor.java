package com.tekora.sensor;

import com.tekora.model.VitalReading;
import lombok.RequiredArgsConstructor;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class HeartRateSensor {

    public Observable<VitalReading> getStream() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(x -> VitalReading.builder()
                        .sensorName("HeartRateSensor")
                        .value(this.generateHeartRate())
                        .unit("bpm")
                        .type("HeartRate")
                        .timestamp(LocalDateTime.now())
                        .build()
                )
                .subscribeOn(Schedulers.io());
    }

    private double generateHeartRate() {
        return 60 + Math.random() * 60;
    }

}
