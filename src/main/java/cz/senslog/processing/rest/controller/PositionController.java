package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.PositionEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.Position;
import cz.senslog.model.dto.create.PositionCreate;
import cz.senslog.processing.db.repository.PositionRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.processing.security.UserToken;
import cz.senslog.processing.util.Mapper;
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
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    private static final String PREFIX_CONTROLLER = "/position";
    private final static Type LIST_DTO = new TypeToken<List<Position>>() {}.getType();

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private Mapper modelMapper;

    /* --- POST CALLS --- */

    /***
     * position/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertPosition(
                                     @AuthenticationPrincipal UserToken token,
                                     @RequestBody List<PositionCreate> unitPositionCreate
    ){

        LOGGER.info("> clientId {}, unitPositionCreate {}", token, unitPositionCreate);

        for( PositionCreate toCreate : unitPositionCreate ) {

            UnitEntity unitEntity = unitRepository.findOne(toCreate.getUnitId());

            if( unitEntity == null ){
                LOGGER.warn("Unit id: \'{}\' does not exists!", toCreate.getUnitId());
                return HttpStatus.BAD_REQUEST;
            }

            PositionEntity toSave = modelMapper.map(toCreate, PositionEntity.class);
            toSave.setUnit(unitEntity);

            positionRepository.save(toSave);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


