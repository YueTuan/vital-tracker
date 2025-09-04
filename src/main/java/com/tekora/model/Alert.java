package com.tekora.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Alert {
    String type;
    String message;
    double value;
    String unit;
    String severity;
}
