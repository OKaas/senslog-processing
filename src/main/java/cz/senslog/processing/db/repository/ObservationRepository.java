package cz.senslog.processing.db.repository;

import cz.senslog.model.db.ObservationEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "observation", path = "observation")
public interface ObservationRepository extends PagingAndSortingRepository<ObservationEntity, Long>, JpaSpecificationExecutor {
}
