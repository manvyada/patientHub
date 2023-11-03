package com.patienthub.springboot.PatientHubServicespringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

	    private final patientService patientService;

	    @Autowired
	    public PatientController(patientService patientService) {
	        this.patientService = patientService;
	    }

	    @GetMapping("/{id}")
	    public patient getPatientById(@PathVariable Long id) {
	        return patientService.getPatientById(id);
	    }

	    @GetMapping("/")
	    public List<patient> getAllPatients() {
	        return patientService.getAllPatients();
	    }

    @PostMapping("/")
    public patient createPatient(@RequestBody patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{id}")
    public patient updatePatient(@PathVariable Long id, @RequestBody patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
