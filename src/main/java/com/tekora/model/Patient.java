package com.tekora.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Patient {
    String id;
    String name;
    int age;
    String gender;
    String room;
}
