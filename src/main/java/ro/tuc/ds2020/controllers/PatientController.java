package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.services.PatientService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getPatients() {
        List<PatientDTO> patientDTOS = patientService.find();

        return new ResponseEntity<>(patientDTOS, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") UUID patientId) {
        PatientDTO patientDTO = patientService.findPatientById(patientId);
        if (patientDTO.equals(null)) {
            return new ResponseEntity<>(null,HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);

        }
    }
    @PostMapping()
    public ResponseEntity<UUID> insertPatient(@Valid @RequestBody PatientDTO patientDTO) {
        UUID patientId = patientService.insert(patientDTO);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UUID> deletePatient(@PathVariable("id") UUID patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(patientId, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UUID> updatePatient(@PathVariable("id") UUID patientId, @Valid @RequestBody PatientDTO patientDTO) {
        Boolean result = patientService.updatePatient(patientId, patientDTO);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/app")
    public ResponseEntity<UUID> updatePatient1(@RequestParam(value="patientId") UUID patientId, @RequestParam(value="doctor") String doctor, @RequestParam(value="programare") String programare) {
        Boolean result = patientService.updatePatient1(patientId, doctor, programare);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }
}
