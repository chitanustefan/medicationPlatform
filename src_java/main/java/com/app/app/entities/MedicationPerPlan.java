package com.app.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "medicationPerPlan")
public class MedicationPerPlan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_med_per_plan", unique = true, nullable = false)
    private Long id_med_per_plan;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private MedicationPlan medicationPlan;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Medication medication;

    public MedicationPerPlan() {
    }

    public Long getId_med_per_plan() {
        return id_med_per_plan;
    }

    public void setId_med_per_plan(Long id_med_per_plan) {
        this.id_med_per_plan = id_med_per_plan;
    }

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
