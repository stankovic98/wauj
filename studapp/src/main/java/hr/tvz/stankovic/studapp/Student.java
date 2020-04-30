package hr.tvz.stankovic.studapp;

import java.time.LocalDate;

public class Student {
    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEctsCount() {
        return ectsCount;
    }

    public void setEctsCount(int ectsCount) {
        this.ectsCount = ectsCount;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String jmbag;
    private String name;
    private String surname;
    private int ectsCount;
    private LocalDate dateOfBirth;

    public Student(String jmbag, String name, String surname, LocalDate dateOfBirth, int ectsCount) {
        this.jmbag = jmbag;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ectsCount = ectsCount;
    }
}
