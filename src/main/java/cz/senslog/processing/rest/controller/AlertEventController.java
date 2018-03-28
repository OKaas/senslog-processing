package cz.senslog.processing.rest.controller;

import cz.senslog.processing.db.repository.AlertRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.model.dto.create.AlertEventCreate;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.model.dto.AlertEvent;
import cz.senslog.processing.security.UserToken;
import cz.senslog.processing.util.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class AlertEventController implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertEventController.class);

    private final static String PREFIX_CONTROLLER = "/alertEvent";
    private final static Type LIST_DTO = new TypeToken<List<AlertEvent>>() {}.getType();

    @Value("${enum.alert.event}")
    private String DEFAULT_ALERT_EVENT_NAME;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
//        DEFAULT_ALERT_EVENT = (EnumItemEntity) enumItemRepository.findOne(EnumItemByName.matchEnumItemByName(DEFAULT_ALERT_EVENT_NAME));
//        if( DEFAULT_ALERT_EVENT == null ){
//            LOGGER.error("Cannot find default enum item: {}", DEFAULT_ALERT_EVENT_NAME );
//        }
    }

    /***
     * /alertEvent/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(@AuthenticationPrincipal UserToken token,
                             @RequestBody List<AlertEventCreate> alerts){

        LOGGER.info("> client: {}, alertReceive {} ", token, alerts);

//        for(AlertEventReceive alertEvent : alerts){
//
//            UnitEntity unitEntity = (UnitEntity) unitRepository.findOne(
//                                        Specifications.where(UnitById.matchUnitById(alertEvent.getUnit()))
//                                                      .and(UnitInUserGroup.matchUnitInUserGroup(token.getGroup()))
//            );
//
//            if( unitEntity == null ){ return RestMapping.STATUS_BAD_REQUEST; }
//
//            AlertEntity alertEntity = alertRepository.findOne(alertEvent.getAlert());
//            if( alertEntity == null ){ return RestMapping.STATUS_BAD_REQUEST; }
//
//            AlertEventEntity alertEventEntity = modelMapper.map(alertEvent, AlertEventEntity.class);
//            alertEventEntity.setUnit(unitEntity);
//            alertEventEntity.setAlert(alertEntity);
//            alertEventEntity.setEnumItem(DEFAULT_ALERT_EVENT);
//
//            alertEventRepository.save(alertEventEntity);
//        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


