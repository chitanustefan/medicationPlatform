package com.app.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recom")
public class Recommendation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_recommendation",unique = true, nullable = false)
    private Long id_recommendation;

    @Column
    private int id_patient_rec;

    @Column
    private Date dateReco;

    @Column
    private String desc_rec;

    public Recommendation() {
    }

    public Long getId_recomandation() {
        return id_recommendation;
    }

    public void setId_recomandation(Long id_recommendation) {
        this.id_recommendation = id_recommendation;
    }

    public int getId_patient() {
        return id_patient_rec;
    }

    public void setId_patient(int id_patient_rec) {
        this.id_patient_rec = id_patient_rec;
    }

    public Date getDateReco() {
        return dateReco;
    }

    public void setDateReco(Date dateReco) {
        this.dateReco = dateReco;
    }

    public String getDesc() {
        return desc_rec;
    }

    public void setDesc(String desc_rec) {
        this.desc_rec = desc_rec;
    }

}
