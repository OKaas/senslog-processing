package cz.senslog.processing.db.repository;

import cz.senslog.model.db.UnitEntity;
//import cz.hsrs.maplog.security.UserToken;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 7/4/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface UnitRepository extends PagingAndSortingRepository<UnitEntity, Long>, JpaSpecificationExecutor {

}


