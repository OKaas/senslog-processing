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
import cz.senslog.processing.util.QueryBuilder;
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
    public List<Position> getPosition(
                                      @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                      Pageable pageable){

//        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
//                token.toString(), filter, pageable);

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
    public HttpStatus insertPosition(
                                     @AuthenticationPrincipal UserToken token,
                                     @RequestBody List<PositionCreate> unitPositionCreate
    ){

        LOGGER.info("> clientId {}, unitPositionCreate {}", token, unitPositionCreate);

        for( PositionCreate toCreate : unitPositionCreate ) {

            UnitEntity unitEntity = unitRepository.findOne(toCreate.getUnitId());

            if( unitEntity == null ){
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


