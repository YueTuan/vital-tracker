package com.tekora.model;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class VitalReading {
    String sensorName;
    double value;
    String unit;
    String type;
    LocalDateTime timestamp;
}
