package com.app.app.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caregiver")
public class Caregiver {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_caregiver",unique = true, nullable = false)
    private Long id_caregiver;

    @OneToMany(mappedBy = "caregiver")
    private List<Patient> patients;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private User user;

    public Caregiver() {
    }

    public Long getId_caregiver() {
        return id_caregiver;
    }

    public void setId_caregiver(Long id_caregiver) {
        this.id_caregiver = id_caregiver;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
