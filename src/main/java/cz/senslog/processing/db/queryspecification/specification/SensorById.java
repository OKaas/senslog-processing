package cz.senslog.processing.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by OK on 1/20/2018.
 */
public class SensorById {

    public static Specification<EntityQueryable> matchUnitById(final Long sensorId){
        return (root, query, builder) -> root.get("id").in(sensorId);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


