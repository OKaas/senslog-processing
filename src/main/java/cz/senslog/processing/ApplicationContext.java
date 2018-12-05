package cz.senslog.processing;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by OK on 6/9/2017.
 */
@Configuration
@EntityScan("cz.senslog.model.db")
@ComponentScan("cz.senslog.processing")
@PropertySource("application.yml")
public class ApplicationContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContext.class);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}


