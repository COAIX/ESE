package com.lw.g_healthcare.dao;

import com.lw.g_healthcare.entity.Appointment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) interface for managing Appointment entities.
 */
public interface AppointmentDao {

    /**
     * Retrieves an Appointment entity by its ID.
     *
     * @param appointmentId the ID of the appointment
     * @return the Appointment entity, or null if not found
     */
    Appointment queryById(String appointmentId);

    /**
     * Retrieves a list of Appointment entities with pagination.
     *
     * @param appointment the Appointment entity with filter criteria
     * @param pageable the pagination information
     * @return a list of Appointment entities
     */
    List<Appointment> queryAllByLimit(Appointment appointment, @Param("pageable") Pageable pageable);

    /**
     * Counts the total number of Appointment entities based on filter criteria.
     *
     * @param appointment the Appointment entity with filter criteria
     * @return the total count of matching Appointment entities
     */
    long count(Appointment appointment);

    /**
     * Inserts a new Appointment entity into the database.
     *
     * @param appointment the Appointment entity to insert
     * @return the number of rows affected
     */
    int insert(Appointment appointment);

    /**
     * Inserts a batch of Appointment entities into the database.
     *
     * @param entities the list of Appointment entities to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<Appointment> entities);

    /**
     * Inserts or updates a batch of Appointment entities in the database.
     * If an entity already exists, it will be updated.
     *
     * @param entities the list of Appointment entities to insert or update
     * @return the number of rows affected
     */
    int insertOrUpdateBatch(@Param("entities") List<Appointment> entities);

    /**
     * Updates an existing Appointment entity in the database.
     *
     * @param appointment the Appointment entity with updated information
     * @return the number of rows affected
     */
    int update(Appointment appointment);

    /**
     * Deletes an Appointment entity from the database by its ID.
     *
     * @param appointmentId the ID of the appointment to delete
     * @return the number of rows affected
     */
    int deleteById(String appointmentId);

    /**
     * Retrieves a list of all Appointment entities.
     *
     * @return a list of all Appointment entities
     */
    ArrayList<Appointment> queryAll();
}
