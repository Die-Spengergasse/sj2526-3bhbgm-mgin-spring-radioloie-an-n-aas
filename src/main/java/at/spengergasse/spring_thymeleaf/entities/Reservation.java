package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "r_reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Patient patient;
    private Machine machine;
    private LocalDate dateTime;
    private String bodyregion;
    private String comment ;
}
