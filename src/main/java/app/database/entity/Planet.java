package app.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.log4j.Logger;

@Entity
@Table(name = "planets")
@Data
public class Planet {

    private static final Logger log = Logger.getLogger(Planet.class);

    @Id
    @Column(columnDefinition = "VARCHAR(10) CHECK (id REGEXP '^[A-Z0-9]+$')", nullable = false)
    private String id;

    @Column(name = "planet_name", length = 501, nullable = false)
    private String name;



    @PrePersist
    public void logNewPlanetAttempt() {
        log.info("Attempting to add new planet with name: " + name);
    }

    @PostPersist
    public void logNewPlanetAdded() {
        log.info("Added planet '" + name + "' with ID: " + id);
    }

    @PreUpdate
    public void logPlanetUpdateAttempt() {
        log.info("Attempting to update planet: " + name);
    }

    @PostUpdate
    public void logPlanetUpdate() {
        log.info("Updated planet: " + name);
    }

    @PostLoad
    public void logPlanetLoad() {
        log.info("Load planet: " + name);
    }

    @PreRemove
    public void logPlanetRemovalAttempt() {
        log.info("Attempting to delete planet: " + name);
    }

    @PostRemove
    public void logPlanetRemoval() {
        log.info("Deleted planet: " + name);
    }

}
