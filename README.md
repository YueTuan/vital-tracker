# RxHealth Vital Tracker

## Description
**RxHealth Vital Tracker** is a reactive Java application built with **RxJava** that simulates real-time monitoring of patient vital signs.  
The system streams **heart rate, blood oxygen, and body temperature** from virtual sensors, processes them in parallel, and raises alerts when abnormal values are detected.

This project is designed to demonstrate **RxJava expertise** with best practices:
- Separation of concerns
- Reactive streams
- Concurrency management using Schedulers
- Real-time data processing & alerting

---

## Features
- 🫀 **Heart Rate Monitoring** (bpm)
- 🌬️ **Oxygen Saturation Monitoring** (%)
- 🌡️ **Body Temperature Monitoring** (°C)
- ⚡ Real-time stream combination using `combineLatest`
- 🚨 Automated health alerts:
    - Fever detection
    - Hypoxia detection
    - Tachycardia detection
- 👩‍⚕️ Multi-patient support with independent sensor streams

---

## Architecture
```bash
RxHealth-Vital-Tracker/
┣ 📂 model
┃ ┣ VitalReading.java # Sensor reading data model
┃ ┣ Alert.java # Health alert model
┃ ┗ Patient.java # Patient model
┣ 📂 sensor
┃ ┣ HeartRateSensor.java # Emits heart rate values
┃ ┣ OxygenSensor.java # Emits oxygen saturation
┃ ┗ BodyTempSensor.java # Emits body temperature
┣ 📂 service
┃ ┣ VitalProcessor.java # Combines sensor data
┃ ┣ AlertService.java # Generates alerts based on rules
┃ ┗ PatientService.java # Manages patients & their processors
┗ 📂 main
┗ MainApp.java # Entry point of the application
```

---

## Tech Stack
- **Java 17+**
- **RxJava 3**
- **Lombok** (for clean model classes)

---

## Why This Project?

This project showcases RxJava mastery with:

- Complex reactive pipelines
- Multi-source data stream handling
- Real-time alerting logic
- Scalable and clean architecture

Perfect for your portfolio or as a base project for healthcare monitoring systems.

## Example Output
```bash
>> [Paciente P002] [2025-09-03T23:09:48.439379] HR=68.5 bpm | O₂=90.2% | Temp=36.0 °C | Hipoxia detectada
>> [Paciente P001] [2025-09-03T23:09:48.439379] HR=119.1 bpm | O₂=93.5% | Temp=37.9 °C | Taquicardia detectada
>> [Paciente P001] [2025-09-03T23:09:49.387672] HR=75.9 bpm | O₂=93.5% | Temp=37.9 °C
>> [Paciente P002] [2025-09-03T23:09:49.387672] HR=116.5 bpm | O₂=90.2% | Temp=36.0 °C | Taquicardia detectada | Hipoxia detectada
>> [Paciente P002] [2025-09-03T23:09:49.387672] HR=116.5 bpm | O₂=98.5% | Temp=36.0 °C | Taquicardia detectada
>> [Paciente P001] [2025-09-03T23:09:49.387672] HR=75.9 bpm | O₂=93.5% | Temp=36.2 °C
>> [Paciente P001] [2025-09-03T23:09:49.387672] HR=75.9 bpm | O₂=95.7% | Temp=36.2 °C
>> [Paciente P002] [2025-09-03T23:09:49.387672] HR=116.5 bpm | O₂=98.5% | Temp=38.1 °C | Taquicardia detectada | Fiebre detectada
>> [Paciente P002] [2025-09-03T23:09:50.394229800] HR=116.5 bpm | O₂=92.2% | Temp=38.1 °C | Taquicardia detectada | Fiebre detectada
```
