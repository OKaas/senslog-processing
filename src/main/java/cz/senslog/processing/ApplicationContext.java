package cz.senslog.processing;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Collections;

import static com.google.common.base.Predicates.or;

/**
 * Created by OK on 6/9/2017.
 */
@Configuration
@EntityScan("cz.senslog.model.db")
@ComponentScan("cz.senslog.processing")
@PropertySource("classpath:application.yml")
@EnableSwagger2
public class ApplicationContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContext.class);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .directModelSubstitute(Timestamp.class, Long.class)
                .directModelSubstitute(Point.class, String.class);

    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis( or (RequestHandlerSelectors.any(), RequestHandlerSelectors.withClassAnnotation(RepositoryRestResource.class)))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Senslog-v2 API - processing",
                "",
                "1.0.0-rc",
                "Terms of service",
                new Contact("Michal Kepka & Ondrej Kaas", "{mkepka|kaas}@ntis.zcu.cz", "{mkepka|kaas}@ntis.zcu.cz"),
                "License of API [empty]", "API license URL [emptyyy]", Collections.emptyList());
    }

}


