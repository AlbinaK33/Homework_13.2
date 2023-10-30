package app.database.configuration;

import org.flywaydb.core.Flyway;

import static app.database.configuration.Config.*;

public class Migration {

    public static void flywayMigration() {

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/script")
                .load()
                .migrate();
    }
}
