package cz.senslog.processing.rest.controller;

import cz.senslog.model.dto.create.PositionCreate;
import cz.senslog.processing.db.repository.PositionRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import cz.senslog.processing.security.UserToken;
import cz.senslog.processing.util.Mapper;
import cz.senslog.processing.util.QueryBuilder;
import cz.senslog.model.dto.Position;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

//import cz.hsrs.maplog.security.UserToken;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;

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
    private QueryBuilder queryBuilder;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private Mapper modelMapper;

    /* --- GET calls --- */

    /***

     * /position?unitId=
     *
     * http://localhost:8080/position
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPosition(@AuthenticationPrincipal UserToken token,
                                      @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                      Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                positionRepository.findAll(
                        queryBuilder.build(filter),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- POST CALLS --- */

    /***
     * position/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertPosition(@AuthenticationPrincipal UserToken token,
                                     @RequestBody PositionCreate unitPositionCreate){

        LOGGER.info("> clientId {}, unitPositionCreate {}", token.getUsername(), unitPositionCreate);

        return RestMapping.STATUS_CREATED;

        // Get all units in user group
//        List<UnitEntity> unitEntities = unitRepository.findAll(
//                        Specifications.where(UnitInUserGroup.matchUnitInUserGroup(token.getGroup()))
//                                .and( UnitById.matchUnitById(token.getUserGroupEntity().getId()))
//        );
//
//        // save only if unit is attached to UserToken's user group
//        if( unitEntities.stream().anyMatch( e -> e.getId().equals(unitPositionCreate.getUnitId())) ){
//            PositionEntity toSave = modelMapper.map(unitPositionCreate, PositionEntity.class);
//            // toSave.setTimeReceived( new Timestamp(System.currentTimeMillis()) );
//            positionRepository.save(toSave);
//            return RestMapping.STATUS_CREATED;
//        } else {
//            LOGGER.info("User does not have unit: {}", unitPositionCreate.getUnitId());
//            return RestMapping.STATUS_NOT_ACCETABLE;
//        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


