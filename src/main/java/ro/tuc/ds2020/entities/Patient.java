package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "medical_record", nullable = false)
    private String medicalRecord;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "programare")
    private String programare;

    public Patient() {
    }

    public Patient(String name, String address, String gender, Date birthdate, String medicalRecord, String doctor) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
    }

    public Patient(UUID id, String name, String address, String gender, Date birthdate, String medicalRecord,String doctor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
    }

    public Patient(String name, String address, String gender, Date birthdate, String medicalRecord, String doctor, String programare) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
        this.programare = programare;
    }

    public Patient(UUID id, String name, String address, String gender, Date birthdate, String medicalRecord,String doctor, String programare) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
        this.programare = programare;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getProgramare() {
        return programare;
    }

    public void setProgramare(String programare) {
        this.programare = programare;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id.equals(patient.id) &&
                name.equals(patient.name) &&
                address.equals(patient.address) &&
                gender.equals(patient.gender) &&
                birthdate.equals(patient.birthdate) &&
                medicalRecord.equals(patient.medicalRecord) &&
                doctor.equals(patient.doctor) &&
                programare.equals(patient.programare);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, gender, birthdate, medicalRecord,doctor,programare);
    }
}
