package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.ObservationEntity;
import cz.senslog.model.db.SensorEntity;
import cz.senslog.model.dto.create.ObservationCreate;
import cz.senslog.processing.db.repository.ObservationRepository;
import cz.senslog.processing.db.repository.SensorRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.model.dto.Observation;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@Api(tags = "Observation")
@RestController
@RequestMapping("observation")
@Validated
public class ObservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservationController.class);

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* --- POST calls --- */

    /***
     *
     * @return
     */
    @PostMapping
    public HttpStatus post(@RequestBody List<ObservationCreate> observationCreate){

        LOGGER.info("> observation {} ", observationCreate.toString());

        for( ObservationCreate observationToSave : observationCreate){
            SensorEntity sensorEntity = sensorRepository.findById(observationToSave.getSensorId()).orElse(null);

            // Sensor by specified ID does not exists or is not attached to user Unit
            if( sensorEntity == null ){
                LOGGER.warn("Sensor id: \'{}\' does not exists!", observationToSave.getSensorId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            ObservationEntity observationEntity = modelMapper.map(observationToSave, ObservationEntity.class);
            observationEntity.setSensor(sensorEntity);

            observationRepository.save(observationEntity);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}


