package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.EnumItemEntity;
import cz.senslog.model.db.EventCodeEntity;
import cz.senslog.model.db.EventEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.Event;
import cz.senslog.model.dto.create.EventCreate;
import cz.senslog.processing.db.repository.EnumItemRepository;
import cz.senslog.processing.db.repository.EventRepository;
import cz.senslog.processing.db.repository.EventCodeRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.processing.security.UserToken;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
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
public class EventController implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final static String PREFIX_CONTROLLER = "/event";
    private final static String EVENT_CREATE = "event.state.unprocessed";
    private EnumItemEntity EVENT_UNPROCESSED;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCodeRepository eventCodeRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private EnumItemRepository enumItemRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void afterPropertiesSet() throws Exception {
        EVENT_UNPROCESSED = enumItemRepository.findOneByCode(EVENT_CREATE);
    }

    /***
     * /alertEvent/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(
                             @AuthenticationPrincipal UserToken token,
                             @RequestBody List<EventCreate> events
    ){
        LOGGER.info("> client: {}, alertReceive {} ", token, events);

        for(EventCreate event : events){

            UnitEntity unitEntity = unitRepository.findOne(event.getUnitId());

            if( unitEntity == null ){
                LOGGER.warn("Unit id: \'{}\' does not exists!", event.getUnitId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            EventCodeEntity eventCodeEntity = eventCodeRepository.findOneByCode(event.getCode());
            if( eventCodeEntity == null ){
                LOGGER.warn("EventCode: {} does not exists!", event.getCode());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
            eventEntity.setEventCode(eventCodeEntity);
            eventEntity.setUnit(unitEntity);
            eventEntity.setEnumItem(EVENT_UNPROCESSED);

            eventRepository.save(eventEntity);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


