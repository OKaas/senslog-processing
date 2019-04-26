package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.EnumItemEntity;
import cz.senslog.model.db.EventEntity;
import cz.senslog.model.db.EventStatusEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.create.EventCreate;
import cz.senslog.processing.db.repository.EnumItemRepository;
import cz.senslog.processing.db.repository.EventRepository;
import cz.senslog.processing.db.repository.EventStatusRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by OK on 1/21/2018.
 */
@Api( tags = "Event")
@RestController
@RequestMapping("event")
public class EventController implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);


    private final static String EVENT_CREATE = "event.state.unprocessed";
    private EventStatusEntity EVENT_UNPROCESSED;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventStatusRepository eventStatusRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private EnumItemRepository enumItemRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void afterPropertiesSet() throws Exception {

        // TODO: get default values from database
        // name of table get from system properties / config file then load all
        EVENT_UNPROCESSED = eventStatusRepository.findOneByCode(EVENT_CREATE);
    }

    /* --- POST calls --- */

    /***
     * Post event
     *
     * @return
     */
    @PostMapping
    public HttpStatus post(@RequestBody List<EventCreate> events){
        LOGGER.info("> alertReceive {} ", events);

        for(EventCreate event : events){

            UnitEntity unitEntity = unitRepository.findById(event.getUnitId()).orElse(null);

            if( unitEntity == null ){
                LOGGER.warn("Unit id: \'{}\' does not exists!", event.getUnitId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            EnumItemEntity eventEnum = enumItemRepository.findOneByCode(event.getCode());
            if( eventEnum == null ){
                LOGGER.warn("EventCode: {} does not exists!", event.getCode());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
            eventEntity.setEventStatus(EVENT_UNPROCESSED);
            eventEntity.setUnit(unitEntity);
            eventEntity.setEnumItem(eventEnum);

            eventRepository.save(eventEntity);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Commons  --- */
}


