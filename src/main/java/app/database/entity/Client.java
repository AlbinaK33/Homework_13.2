package app.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.log4j.Logger;

@Entity
@Table(name = "clients")
@Data
public class Client {

    private static final Logger log = Logger.getLogger(Client.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 201, nullable = false)
    private String firstname;

    @Column(name = "last_name", length = 201, nullable = false)
    private String lastname;



    @PrePersist
    public void logNewUserAttempt() {
        log.info("Attempting to add new user with username: " + firstname + " : " + lastname);
    }

    @PostPersist
    public void logNewUserAdded() {
        log.info("Added user '" + firstname + " : " + lastname + "' with ID: " + id);
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
        log.info("Attempting to update user: " + firstname + " : " + lastname);
    }

    @PostUpdate
    public void logUserUpdate() {
        log.info("Updated user: " + firstname + " : " + lastname);
    }

    @PostLoad
    public void logUserLoad() {
        log.info("Load user: " + firstname + " : " + lastname);
    }

    @PreRemove
    public void logUserRemovalAttempt() {
        log.info("Attempting to delete user: " + firstname + " : " + lastname);
    }

    @PostRemove
    public void logUserRemoval() {
        log.info("Deleted user: " + firstname + " : " + lastname);
    }
}
