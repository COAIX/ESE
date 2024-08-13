package com.lw.g_healthcare.controller;

import com.lw.g_healthcare.entity.Patient;
import com.lw.g_healthcare.service.PatientService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing Patient entities.
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    /**
     * Service object for handling patient-related operations.
     */
    @Resource
    private PatientService patientService;

    /**
     * Retrieves a paginated list of Patient entities based on the provided filter criteria.
     *
     * @param patient     the Patient entity with filter criteria
     * @param pageRequest pagination information
     * @return a ResponseEntity containing a page of Patient entities
     */
    @GetMapping
    public ResponseEntity<Page<Patient>> queryByPage(Patient patient, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientService.queryByPage(patient, pageRequest));
    }

    /**
     * Retrieves a Patient entity by its ID.
     *
     * @param patientId the ID of the patient
     * @return a ResponseEntity containing the Patient entity, or a 404 status if not found
     */
    @GetMapping("{patientId}")
    public ResponseEntity<Patient> queryById(@PathVariable("patientId") String patientId) {
        return ResponseEntity.ok(this.patientService.queryById(patientId));
    }

    /**
     * Retrieves a Patient entity by the associated user ID.
     *
     * @param userId the user ID associated with the patient
     * @return a ResponseEntity containing the Patient entity, or a 404 status if not found
     */
    @GetMapping("userId/{userId}")
    public ResponseEntity<Patient> queryByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(this.patientService.queryByUserId(userId));
    }

    /**
     * Adds a new Patient entity to the system.
     *
     * @param patient the Patient entity to add
     * @return a ResponseEntity containing the added Patient entity, or a 400 status if the patientId is empty
     */
    @PostMapping
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        if (patient.getPatientId().isEmpty()) {
            System.out.println("patientId is empty");
            return ResponseEntity.badRequest().body(null); // Changed to badRequest for clarity
        }
        try {
            return ResponseEntity.ok(this.patientService.insert(patient));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(null); // Changed to internal server error for clarity
        }
    }

    /**
     * Updates an existing Patient entity in the system.
     *
     * @param patient the Patient entity with updated information
     * @return a ResponseEntity containing the updated Patient entity
     */
    @PutMapping
    public ResponseEntity<Patient> edit(@RequestBody Patient patient) {
        return ResponseEntity.ok(this.patientService.update(patient));
    }

    /**
     * Updates a Patient entity based on the associated user ID.
     *
     * @param patient the Patient entity with updated information
     * @return a ResponseEntity containing the updated Patient entity
     */
    @PutMapping("userId")
    public ResponseEntity<Patient> editByUserId(@RequestBody Patient patient) {
        return ResponseEntity.ok(this.patientService.updateByUserId(patient));
    }

    /**
     * Deletes a Patient entity by its ID.
     *
     * @param patientId the ID of the patient to delete
     * @return a ResponseEntity indicating whether the deletion was successful
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestParam("patientId") String patientId) {
        return ResponseEntity.ok(this.patientService.deleteById(patientId));
    }
}
