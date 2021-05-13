package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.Patient;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class PatientDTO extends RepresentationModel<PatientDTO> {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String gender;
    private Date birthdate;
    private String medicalRecord;
    private String doctor;
    private String programare;


    public PatientDTO() {
    }

    public PatientDTO(UUID id, String name, String address, String gender, Date birthdate, String medicalRecord, String doctor,String programare) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
        this.programare = programare;
    }

    public PatientDTO(String name, String address, String gender, Date birthdate, String medicalRecord, String doctor, String programare) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
        this.programare = programare;
    }

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.address = patient.getAddress();
        this.gender = patient.getGender();
        this.birthdate = patient.getBirthdate();
        this.medicalRecord = patient.getMedicalRecord();
        this.doctor = patient.getDoctor();
        this.programare = patient.getProgramare();
    }

    public String getProgramare() {
        return programare;
    }

    public void setProgramare(String programare) {
        this.programare = programare;
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Patient toEntity() {
        return new Patient(this.name, this.address, this.gender, this.birthdate, this.medicalRecord,this.doctor,this.programare);
    }

    public Patient toEntityExternal() {
        return new Patient(this.id, this.name, this.address, this.gender, this.birthdate, this.medicalRecord, this.doctor, this.programare);
    }

    public void updatePatient(Patient patient) {
        patient.setName(this.name);
        patient.setAddress(this.address);
        patient.setGender(this.gender);
        patient.setBirthdate(this.birthdate);
        patient.setMedicalRecord(this.medicalRecord);
        patient.setDoctor(this.doctor);
        patient.setProgramare(this.programare);
    }

    public static PatientDTO getPatientForCaregiver(Patient patient) {
        return new PatientDTO(patient.getId(),
                patient.getName(),
                patient.getAddress(),
                patient.getGender(),
                patient.getBirthdate(),
                patient.getMedicalRecord(),
                patient.getDoctor(),
                patient.getProgramare());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PatientDTO that = (PatientDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                address.equals(that.address) &&
                gender.equals(that.gender) &&
                birthdate.equals(that.birthdate) &&
                medicalRecord.equals(that.medicalRecord) &&
                doctor.equals(that.doctor) &&
                programare.equals(that.programare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, address, gender, birthdate, medicalRecord, doctor,programare);
    }
}
