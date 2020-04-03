package com.app.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_patient",unique = true, nullable = false)
    private Long id_patient;

    @Column
    private String medicalRecord;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Caregiver caregiver;

    @ManyToOne()
    @JoinColumn
    @JsonIgnore
    private Doctor doctor;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private User user;

    @OneToOne(mappedBy = "patient")
    private MedicationPlan medicationPlan;

    @OneToMany(mappedBy = "patient")
    private List<MonitoredData2> datas;

//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//    private List<MonitoredData2> monitoredDataList;

    public Patient(){}

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

}
