package com.app.app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_doctor",unique = true, nullable = false)
    private Long id_doctor;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    public Doctor() {
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
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
