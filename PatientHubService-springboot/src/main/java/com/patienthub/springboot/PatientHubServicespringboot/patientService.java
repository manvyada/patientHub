package com.patienthub.springboot.PatientHubServicespringboot;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
        @Service
	    public class patientService {

	        private final Map<Long, patient> patients = new HashMap<>();
	        private long idCounter = 1;

	        public patient createPatient(patient patient) {
	            patient.setId(idCounter++);
	            patients.put(patient.getId(), patient);
	            return patient;
	        }

	        public List<patient> getAllPatients() {
	            return new ArrayList<>(patients.values());
	        }

	        public patient getPatientById(Long id) {
	            patient patient = patients.get(id);
	            if (patient == null) {
	                throw new ResourceNotFoundException("Patient not found with id: " + id);
	            }
	            return patient;
	        }

	        public patient updatePatient(Long id, patient updatedPatient) {
	            if (!patients.containsKey(id)) {
	                throw new ResourceNotFoundException("Patient not found with id: " + id);
	            }
	            updatedPatient.setId(id);
	            patients.put(id, updatedPatient);
	            return updatedPatient;
	        }

	        public void deletePatient(Long id) {
	            if (!patients.containsKey(id)) {
	                throw new ResourceNotFoundException("Patient not found with id: " + id);
	            }
	            patients.remove(id);
	        }
	        
        }

	   // private final PatientRepository patientRepository;
/*	    @Autowired
	    public PatientService(PatientRepository patientRepository) {
	        this.patientRepository = patientRepository;
	    }

	    public patientService() {
	        // Default constructor
	    }

	    public patientService(Long id, String resourceName) {
	        this.id = id;
	        this.resourceName = resourceName;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getResourceName() {
	        return resourceName;
	    }

	    public void setResourceName(String resourceName) {
	        this.resourceName = resourceName;
	    }

	    @Override
	    public String toString() {
	        return "PatientResource{" +
	                "id=" + id +
	                ", resourceName='" + resourceName + '\'' +
	                '}';
	    }

	    public patient getPatientById(Long id) {
	        Optional<patient> patient = patientRepository.findById(id);
	        return patient.orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
	    }

	    public List<patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	    public Patient createPatient(patient patient) {
	        // Additional logic can be added before saving the patient to the database, if needed
	        return patientRepository.save(patient);
	    }

	    public patient updatePatient(Long id, Patient updatedPatient) {
	        if (!patientRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Patient not found with id: " + id);
	        }
	        updatedPatient.setId(id);
	        return patientRepository.save(updatedPatient);
	    }

	    public void deletePatient(Long id) {
	        if (!patientRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Patient not found with id: " + id);
	        }
	        patientRepository.deleteById(id);
	    }
	}
		}
	}*/
