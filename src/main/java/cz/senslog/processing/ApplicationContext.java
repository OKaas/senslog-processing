package cz.senslog.processing;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by OK on 6/9/2017.
 */
@Configuration
public class ApplicationContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContext.class);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}


