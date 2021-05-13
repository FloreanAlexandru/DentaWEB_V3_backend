package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final AccountService accountService;

    @Autowired
    public PatientService(PatientRepository patientRepository, AccountService accountService) {
        this.patientRepository = patientRepository;
        this.accountService = accountService;
    }

    public List<PatientDTO> find() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    public UUID insert(PatientDTO patientDTO) {
        Patient patient = patientDTO.toEntity();

        patient = patientRepository.save(patient);

        if (!accountService.insert(patientDTO.getUsername(), patientDTO.getPassword(), patient.getId(), "patient")) {
            patientRepository.deleteById(patient.getId());
        }

        return patient.getId();
    }

    public PatientDTO findPatientById(UUID uuid){
        Optional<Patient> optionalPatient = patientRepository.findById(uuid);
        PatientDTO patientDTO = new PatientDTO(optionalPatient.get().getName(),optionalPatient.get().getAddress(),optionalPatient.get().getGender(),
                optionalPatient.get().getBirthdate(),optionalPatient.get().getMedicalRecord(),optionalPatient.get().getDoctor(),optionalPatient.get().getProgramare());
        return patientDTO;
    }
    public void deletePatientById(UUID uuid) {
        Optional<Patient> optionalPatient = patientRepository.findById(uuid);

        optionalPatient.ifPresent(patient -> {
            patientRepository.save(patient);
        });

        if (optionalPatient.isPresent()) {
            accountService.deleteByUUID(uuid);
        }

        patientRepository.deleteById(uuid);
    }

    public Boolean updatePatient(UUID patientUuid, PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientUuid);

        optionalPatient.ifPresent(patient -> {
            patient.setId(patientUuid);
            patient.setName(patientDTO.getName());
            patient.setAddress(patientDTO.getAddress());
            patient.setGender(patientDTO.getGender());
            patient.setBirthdate(patientDTO.getBirthdate());
            patient.setMedicalRecord(patientDTO.getMedicalRecord());
            patientRepository.save(patient);
        });

        return optionalPatient.isPresent();
    }

    public Boolean updatePatient1(UUID patientUuid, String doctor, String programare){
        Optional<Patient> optionalPatient = patientRepository.findById(patientUuid);
        optionalPatient.ifPresent(patient -> {
            patient.setId(patientUuid);
            patient.setName(optionalPatient.get().getName());
            patient.setAddress(optionalPatient.get().getAddress());
            patient.setGender(optionalPatient.get().getGender());
            patient.setBirthdate(optionalPatient.get().getBirthdate());
            patient.setMedicalRecord(optionalPatient.get().getMedicalRecord());
            patient.setDoctor(doctor);
            patient.setProgramare(programare);
            patientRepository.save(patient);
        });

        return optionalPatient.isPresent();
    }
}
