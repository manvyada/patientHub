package com.patienthub.springboot.PatientHubServicespringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PatientServiceTest {

    @InjectMocks
    private patientService patientService;
    
    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPatientById() {
        // Arrange
        Long patientId = 1L;
        patient expectedPatient = new patient(patientId, null, 0, null);
        //Optional<patient> optionalPatient = Optional.of(new patient(patientId, null, 0, nul));

        expectedPatient.setId(patientId);

        // Act
        patient result = patientService.getPatientById(patientId);

        // Assert
        assertNotNull(result);
        assertEquals(patientId, result.getId());
    }

    @Test
    void testGetPatientByIdNotFound() {
        // Arrange
        Long patientId = 1L;
        when(patientService.getPatientById(patientId)).thenReturn(null);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> patientService.getPatientById(patientId));
    }

    // Add more test cases for other methods in PatientService if needed
}
