package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="p_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private long ssn;
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate birth;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List< Reservation> reservations = new ArrayList<>();

    public Patient() {}
    public Patient(long ssn, String firstName, String lastName, char gender, LocalDate birth) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birth = birth;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", ssn=" + ssn +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
