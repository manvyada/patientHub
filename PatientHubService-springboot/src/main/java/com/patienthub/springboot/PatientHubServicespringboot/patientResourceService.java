package com.patienthub.springboot.PatientHubServicespringboot;

//import com.patienthub.springboot.PatientHubServicespringboot.ResourceNotFoundException;
//import com.patienthub.springboot.PatientHubServicespringboot.patientResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class patientResourceService {
    // In-memory data structure (for demonstration purposes)
    private List<patientResource> patientResources = new ArrayList<>();
    public patientResource getPatientResourceById(Long id) {
        Optional<patientResource> patientResourceOptional = patientResources.stream()
                .filter(resource -> resource.getId().equals(id))
                .findFirst();

        return patientResourceOptional.orElseThrow(() -> new ResourceNotFoundException("Patient resource not found with id: " + id));
    }

    public List<patientResource> getAllPatientResources() {
        return patientResources;
    }

    public patientResource createPatientResource(patientResource patientResource) {
        // Logic to generate a unique ID for the new patient resource (if required)
        // For demonstration purposes, assuming resources are given unique IDs externally
        patientResources.add(patientResource);
        return patientResource;
    }

    public patientResource updatePatientResource(Long id, patientResource updatedResource) {
        // Find the existing patient resource by ID and update its properties
        for (int i = 0; i < patientResources.size(); i++) {
            if (patientResources.get(i).getId().equals(id)) {
                patientResources.set(i, updatedResource);
                return updatedResource;
            }
        }
        throw new ResourceNotFoundException("Patient resource not found with id: " + id);
    }

    public void deletePatientResource(Long id) {
        // Remove the patient resource with the given ID
        patientResources.removeIf(resource -> resource.getId().equals(id));
    }
}

