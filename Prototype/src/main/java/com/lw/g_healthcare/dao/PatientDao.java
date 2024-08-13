package com.lw.g_healthcare.dao;

import com.lw.g_healthcare.entity.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Data Access Object (DAO) interface for managing Patient entities.
 */
public interface PatientDao {

    /**
     * Retrieves a Patient entity by its ID.
     *
     * @param patientId the ID of the patient
     * @return the Patient entity, or null if not found
     */
    Patient queryById(String patientId);

    /**
     * Retrieves a list of Patient entities with pagination.
     *
     * @param patient the Patient entity with filter criteria
     * @param pageable the pagination information
     * @return a list of Patient entities
     */
    List<Patient> queryAllByLimit(Patient patient, @Param("pageable") Pageable pageable);

    /**
     * Counts the total number of Patient entities based on filter criteria.
     *
     * @param patient the Patient entity with filter criteria
     * @return the total count of matching Patient entities
     */
    long count(Patient patient);

    /**
     * Inserts a new Patient entity into the database.
     *
     * @param patient the Patient entity to insert
     * @return the number of rows affected
     */
    int insert(Patient patient);

    /**
     * Inserts a batch of Patient entities into the database.
     *
     * @param entities the list of Patient entities to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<Patient> entities);

    /**
     * Inserts or updates a batch of Patient entities in the database.
     * If an entity already exists, it will be updated.
     *
     * @param entities the list of Patient entities to insert or update
     * @return the number of rows affected
     */
    int insertOrUpdateBatch(@Param("entities") List<Patient> entities);

    /**
     * Updates an existing Patient entity in the database.
     *
     * @param patient the Patient entity with updated information
     * @return the number of rows affected
     */
    int update(Patient patient);

    /**
     * Deletes a Patient entity from the database by its ID.
     *
     * @param patientId the ID of the patient to delete
     * @return the number of rows affected
     */
    int deleteById(String patientId);

    /**
     * Retrieves a Patient entity by its user ID.
     *
     * @param userId the user ID associated with the patient
     * @return the Patient entity, or null if not found
     */
    Patient queryByUserId(String userId);

    /**
     * Updates a Patient entity based on its user ID.
     *
     * @param patient the Patient entity with updated information
     * @return the number of rows affected
     */
    int updateByUserId(Patient patient);
}
