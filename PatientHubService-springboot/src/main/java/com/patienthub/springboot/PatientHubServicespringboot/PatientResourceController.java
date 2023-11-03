

package com.patienthub.springboot.PatientHubServicespringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient-resources")
public class PatientResourceController {

    private final patientResourceService patientResourceService;

    @Autowired
    public PatientResourceController(patientResourceService patientResourceService) {
        this.patientResourceService = patientResourceService;
    }

    @GetMapping("/{id}")
    public patientResource getPatientResourceById(@PathVariable Long id) {
        return patientResourceService.getPatientResourceById(id);
    }

    @GetMapping("/")
    public List<patient> getAllPatientResources() {
        return Arrays.asList(new patient(1L, "John Doe", 38, "Male"),new patient(2L, "Johny Dep", 30, "Male"),new patient(3L, "Divya", 26, "Female"),new patient(4L, "karan", 33, "Male"));
        	    
    }

    @PostMapping("/")
    public patientResource createPatientResource(@RequestBody patientResource patientResource) {
        return patientResourceService.createPatientResource(patientResource);
    }

    @PutMapping("/{id}")
    public patientResource updatePatientResource(@PathVariable Long id, @RequestBody patientResource updatedResource) {
        return patientResourceService.updatePatientResource(id, updatedResource);
    }

    @DeleteMapping("/{id}")
    public void deletePatientResource(@PathVariable Long id) {
        patientResourceService.deletePatientResource(id);
    }
}

