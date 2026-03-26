package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "r_reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
    private LocalDate dateTime;
    private String bodyregion;
    private String comment ;


    public Reservation() {}

    public Reservation(Patient patient, Machine machine, LocalDate dateTime, String bodyregion, String comment) {
        this.patient = patient;
        this.machine = machine;
        this.dateTime = dateTime;
        this.bodyregion = bodyregion;
        this.comment = comment;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public String getBodyregion() {
        return bodyregion;
    }

    public void setBodyregion(String bodyregion) {
        this.bodyregion = bodyregion;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", patient=" + patient +
                ", machine=" + machine +
                ", dateTime=" + dateTime +
                ", bodyregion='" + bodyregion + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
