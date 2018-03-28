package cz.senslog.processing.db.repository;


import cz.senslog.model.db.PositionEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "positon", path = "position")
public interface PositionRepository extends PagingAndSortingRepository<PositionEntity, Long>, JpaSpecificationExecutor {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


