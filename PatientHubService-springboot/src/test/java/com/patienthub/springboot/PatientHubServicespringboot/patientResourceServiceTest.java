package com.patienthub.springboot.PatientHubServicespringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PatientResourceServiceTest {

    @Mock
    private patientService patientService;

    @InjectMocks
    private patientResourceService patientResourceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPatientById() {
        // Arrange
        Long patientId = 1L;
        patient expectedPatient = new patient(patientId, null, 0, null);
        expectedPatient.setId(patientId);
        when(patientService.getPatientById(patientId)).thenReturn(expectedPatient);

        // Act
        patientResource result = patientResourceService.getPatientResourceById(patientId);

        // Assert
        assertNotNull(result);
        assertEquals(patientId, result.getId());
    }

    @Test
    void testGetPatientByIdNotFound() {
        // Arrange
        Long patientId = 1L;
        when(patientService.getPatientById(patientId)).thenThrow(ResourceNotFoundException.class);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> patientResourceService.getPatientResourceById(patientId));
    }
}
    // Add more test cases for other methods in PatientService if needed*/
