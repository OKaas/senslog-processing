package cz.senslog.processing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import cz.senslog.model.db.EnumItemEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.rest.webmvc.json.JsonSchema;

import java.io.IOException;

/**
 * Created by OK on 6/9/2017.
 */
// Based on senslog-model
@EntityScan("cz.senslog.model.db")
@ComponentScan("cz.senslog.processing")
@PropertySource("application.yml")

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}


