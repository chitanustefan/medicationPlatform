package com.app.app.entities;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "medication_taken")
public class MedicationTaken {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_medication_taken", unique = true, nullable = false)
    private Long id_medication_taken;

    @Column
    private int medicationPlan;

    @Column
    private Date dateTaken;

    @Column
    private String medication;

    public MedicationTaken() {
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public Long getId_medication_taken() {
        return id_medication_taken;
    }

    public void setId_medication_taken(Long id_medication_taken) {
        this.id_medication_taken = id_medication_taken;
    }

    public int getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(int medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }
}
