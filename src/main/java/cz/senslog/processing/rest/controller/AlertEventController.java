package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.EventCodeEntity;
import cz.senslog.model.db.EventEntity;
import cz.senslog.model.db.EventState;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.AlertEvent;
import cz.senslog.model.dto.create.EventCreate;
import cz.senslog.processing.db.repository.AlertEventRepository;
import cz.senslog.processing.db.repository.AlertRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.processing.security.UserToken;
import cz.senslog.processing.util.QueryBuilder;
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
 * Created by OK on 1/21/2018.
 */
@RestController
public class AlertEventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertEventController.class);

    private final static String PREFIX_CONTROLLER = "/alertEvent";
    private final static Type LIST_DTO = new TypeToken<List<AlertEvent>>() {}.getType();
    private final static EventState EVENT_CREATE = EventState.UNPROCCESSED;

    @Autowired
    private AlertEventRepository alertEventRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /***
     * /alertEvent/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(
                             @AuthenticationPrincipal UserToken token,
                             @RequestBody List<EventCreate> alerts
    ){
        LOGGER.info("> client: {}, alertReceive {} ", token, alerts);

        for(EventCreate alertEvent : alerts){

            UnitEntity unitEntity = unitRepository.findOne(alertEvent.getUnitId());

            if( unitEntity == null ){ return RestMapping.STATUS_BAD_REQUEST; }

            EventCodeEntity eventCodeEntity = alertRepository.findOneByCode(alertEvent.getCode());
            if( eventCodeEntity == null ){ return RestMapping.STATUS_BAD_REQUEST; }

            EventEntity eventEntity = modelMapper.map(alertEvent, EventEntity.class);
            eventEntity.setEventCode(eventCodeEntity);
            eventEntity.setUnit(unitEntity);
            eventEntity.setState(EVENT_CREATE);

            alertEventRepository.save(eventEntity);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


