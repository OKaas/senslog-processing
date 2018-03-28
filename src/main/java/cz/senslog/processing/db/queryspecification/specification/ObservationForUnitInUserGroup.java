package cz.senslog.processing.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.ObservationEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by OK on 1/20/2018.
 */
public class ObservationForUnitInUserGroup {

    public static Specification<EntityQueryable> matchObservationForUnitInUserGroup(final Long groupId){
        return (root, query, builder) -> {
            final Path<ObservationEntity> group = root.join("sensor").join("unit").join("unitToGroups").join("userGroup").get("id");
            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


