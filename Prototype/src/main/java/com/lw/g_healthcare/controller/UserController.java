package com.lw.g_healthcare.controller;

import com.lw.g_healthcare.entity.Patient;
import com.lw.g_healthcare.entity.User;
import com.lw.g_healthcare.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Controller class for managing User entities.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * Retrieves a paginated list of User entities based on the provided filter criteria.
     *
     * @param user the User entity with filter criteria
     * @param pageRequest pagination information
     * @return a ResponseEntity containing a page of User entities
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * Retrieves a User entity by its ID.
     *
     * @param userId the ID of the user
     * @return a ResponseEntity containing the User entity, or a 404 status if not found
     */
    @GetMapping("{userId}")
    public ResponseEntity<User> queryById(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(this.userService.queryById(userId));
    }

    /**
     * Retrieves a User entity by its email address.
     *
     * @param email the email address of the user
     * @return a ResponseEntity containing the User entity, or a 404 status if not found
     */
    @GetMapping("email/{email}")
    public ResponseEntity<User> queryByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(this.userService.queryByEmail(email));
    }

    /**
     * Adds a new User entity to the system.
     *
     * @param user the User entity to add
     * @return a ResponseEntity containing the added User entity, or a 400 status if the userId is empty
     */
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        if (user.getUserId().isEmpty()){
            System.out.println("userId is empty");
            return ResponseEntity.badRequest().body(null); // Changed to badRequest for clarity
        }
        try {
            return ResponseEntity.ok(this.userService.insert(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(null); // Changed to internal server error for clarity
        }
    }

    /**
     * Updates an existing User entity in the system.
     *
     * @param user the User entity with updated information
     * @return a ResponseEntity containing the updated User entity
     */
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * Deletes a User entity by its ID.
     *
     * @param userId the ID of the user to delete
     * @return a ResponseEntity indicating whether the deletion was successful
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestParam("userId") String userId) {
        return ResponseEntity.ok(this.userService.deleteById(userId));
    }

     /**
      * Checks if a patient exists in the system.
      *
      * @deprecated This method is just used for Cloud native Architecture demo.
      *
      * @param user the User entity with the patient's user ID
      * @return a ResponseEntity indicating whether the patient exists
      */
     @PostMapping("Check")
     public ResponseEntity<Boolean> checkPatient(@RequestBody User user) {
//         String url = "http://patientservice/patient/userId/" + user.getUserId();
//         try {
////             Patient response = restTemplate.getForObject(url, Patient.class);
//             return ResponseEntity.ok(true);
//         } catch (HttpClientErrorException.NotFound e) {
//             return ResponseEntity.ok(false);
//         }
         return ResponseEntity.ok(true);
     }
}
