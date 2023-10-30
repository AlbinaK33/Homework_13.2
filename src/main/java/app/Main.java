package app;

import app.database.configuration.*;
import app.database.crud.*;
import app.database.entity.*;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start program");

        Migration.flywayMigration();

        ClientCrudService clientCrudService = new ClientCrudService();
        Client client = new Client();
        client.setFirstname("Albina");
        client.setLastname("Kovalchuk");
        clientCrudService.save(client);
        clientCrudService.delete(client);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planet = new Planet();
        planet.setId("NEP");
        planet.setName("Neptune");
        planetCrudService.save(planet);
        planetCrudService.delete(planet);

        HibernateUtil.getInstance().close();

        LOGGER.info("Finish program");
    }
}