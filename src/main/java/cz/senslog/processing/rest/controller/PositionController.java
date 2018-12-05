package cz.senslog.processing.rest.controller;

import cz.senslog.model.db.PositionEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.Position;
import cz.senslog.model.dto.create.PositionCreate;
import cz.senslog.processing.db.repository.PositionRepository;
import cz.senslog.processing.db.repository.UnitRepository;
import cz.senslog.processing.rest.RestMapping;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
@RequestMapping("position")
@Validated
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);
    private final static Type LIST_DTO = new TypeToken<List<Position>>() {}.getType();

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* --- POST CALLS --- */

    /***
     * position/put
     *
     * @return
     */
    @PostMapping
    public HttpStatus post(@Valid @RequestBody List<PositionCreate> unitPositionCreate){

        LOGGER.info("> unitPositionCreate {}", unitPositionCreate);

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


