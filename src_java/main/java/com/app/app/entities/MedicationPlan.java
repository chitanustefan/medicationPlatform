package com.app.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "medicationPlan")
public class MedicationPlan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_medication_plan", unique = true, nullable = false)
    private Long id_medication_plan;

    @Column
    private String intake_intervals;

    @Column
    private String period;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "medicationPlan", cascade = CascadeType.ALL)
    private List<MedicationPerPlan> medicationPerPlans;

    @Column
    private Date startPeriod;

    @Column
    private Date finishPeriod;


/*    @ManyToOne
    @JoinColumn
    private Medication  medication;*/

    public MedicationPlan() {
    }


    public Long getIdMedicationPlan() {
        return id_medication_plan;
    }

    public void setIdMedicationPlan(Long id_medication_plan) {
        this.id_medication_plan = id_medication_plan;
    }

    public String getIntake_intervals() {
        return intake_intervals;
    }

    public void setIntake_intervals(String intake_intervals) {
        this.intake_intervals = intake_intervals;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<MedicationPerPlan> getMedicationPerPlans() {
        return medicationPerPlans;
    }

    public void setMedicationPerPlans(List<MedicationPerPlan> medicationPerPlans) {
        this.medicationPerPlans = medicationPerPlans;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getFinishPeriod() {
        return finishPeriod;
    }

    public void setFinishPeriod(Date finishPeriod) {
        this.finishPeriod = finishPeriod;
    }
}
