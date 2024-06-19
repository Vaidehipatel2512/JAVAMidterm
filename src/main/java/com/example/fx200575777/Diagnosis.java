package com.example.fx200575777;

public class Diagnosis {
    private String patientId;
    private String symptoms;
    private String diagnosis;
    private String medicines;

    public Diagnosis(String patientId, String symptoms, String diagnosis, String medicines) {
        this.patientId = patientId;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
}
