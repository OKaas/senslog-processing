package cz.senslog.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by OK on 6/9/2017.
 */
@SpringBootApplication
@ComponentScan("cz.hsrs.maplog")
@EntityScan("cz.senslog.db.model")
// TODO probably not necessary
@EnableJpaRepositories("cz.hsrs.maplog.db")
@PropertySource("application.yml")
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


