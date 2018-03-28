package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.ObservationEntity;
import cz.senslog.model.db.SensorEntity;
import cz.senslog.model.dto.create.ObservationCreate;
import cz.senslog.processing.db.queryspecification.specification.SensorById;
import cz.senslog.processing.db.repository.ObservationRepository;
import cz.senslog.processing.db.repository.SensorRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.model.dto.Observation;
import cz.senslog.processing.security.UserToken;
import cz.senslog.processing.util.QueryBuilder;
import cz.senslog.rest.dto.create.ObservationReceive;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class ObservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservationController.class);

    private static final String PREFIX_CONTROLLER = "/observation";
    protected Type LIST_DTO = new TypeToken<List<Observation>>() {}.getType();

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /* --- REST calls --- */

    /***
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(@AuthenticationPrincipal UserToken token,
                             @RequestBody List<ObservationCreate> observationReceive){

        LOGGER.info("> client: {}, observation {} ", token, observationReceive);

        // TODO: In ObservationCreate here should not  be unit id, because IoT dont care about unit, it want to just send data

        for( ObservationCreate observationToSave : observationReceive){
            SensorEntity sensorEntity = (SensorEntity) sensorRepository.findOne(
                    SensorById.matchUnitById(observationToSave.getSensor()));

            // Sensor by specified ID does not exists or is not attached to user Unit
            if( sensorEntity == null ){
                return RestMapping.STATUS_BAD_REQUEST;
            }

            ObservationEntity observationEntity = modelMapper.map(observationToSave, ObservationEntity.class);
            observationEntity.setSensor(sensorEntity);
//            observationEntity.setTimeReceived(new Timestamp(System.currentTimeMillis()) );

            observationRepository.save(observationEntity);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


