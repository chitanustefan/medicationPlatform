package com.app.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medication", unique = true, nullable = false)
    private Long id_medication;

    @Column
    private String name;

    @Column
    private String side_effect;

    @Column
    private String dosage;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<MedicationPerPlan> medicationPerPlans;

    public Medication() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_medication() {
        return id_medication;
    }

    public void setId_medication(Long id_medication) {
        this.id_medication = id_medication;
    }

    public String getSideEffects() {
        return side_effect;
    }

    public void setSideEffects(String sideEffects) {
        this.side_effect = sideEffects;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public List<MedicationPerPlan> getMedicationPerPlans() {
        return medicationPerPlans;
    }

    public void setMedicationPerPlans(List<MedicationPerPlan> medicationPerPlans) {
        this.medicationPerPlans = medicationPerPlans;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

}
