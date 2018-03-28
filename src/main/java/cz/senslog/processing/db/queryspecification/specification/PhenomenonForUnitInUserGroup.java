package cz.senslog.processing.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.PhenomenonEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by OK on 1/18/2018.
 */
public class PhenomenonForUnitInUserGroup {

    public static Specification<EntityQueryable> matchPhenomenonForUnitInUserGroup(final Long groupId){
        return (root, query, builder) -> {
            final Path<PhenomenonEntity> group = root.join("sensors").join("unit").join("unitToGroups").join("userGroup").get("id");
            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


