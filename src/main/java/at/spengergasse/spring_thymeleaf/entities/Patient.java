package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="p_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private long ssn;
    private String firstName;
    private String LastName;
    private char gender;
    private LocalDate birth;
    private List<>

    public Patient() {}
    public Patient(long ssn, String firstName, String lastName, char gender, LocalDate birth) {
        this.ssn = ssn;
        this.firstName = firstName;
        LastName = lastName;
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
                ", LastName='" + LastName + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
