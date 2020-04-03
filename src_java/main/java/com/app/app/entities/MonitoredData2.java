package com.app.app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoredData2")
public class MonitoredData2 {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_monitoredata2",unique = true, nullable = false)
    private Long id_monitoredata2;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishTime;

    @Column
    private String act;

    @ManyToOne()
    @JoinColumn
    @JsonIgnore
    private Patient patient;

    @Column
    private Long difference;

    public MonitoredData2() {
    }

    public MonitoredData2(LocalDateTime date, LocalDateTime finishTime, String act) {
        this.startTime = date;
        this.finishTime = finishTime;
        this.act = act;
    }

    public Long getDifference() {
        return difference;
    }

    public void setDifference(Long difference) {
        this.difference = difference;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public Duration getDuration() {
        Duration duration = Duration.between(this.getStartTime(), this.finishTime);
        return duration;
    }

    public Long getId_monitoredata2() {
        return id_monitoredata2;
    }

    public void setId_monitoredata2(Long id_monitoredata2) {
        this.id_monitoredata2 = id_monitoredata2;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
