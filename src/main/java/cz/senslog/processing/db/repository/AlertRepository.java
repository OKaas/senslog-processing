package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EventCodeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "alert", path = "alert")
public interface AlertRepository extends PagingAndSortingRepository<EventCodeEntity, Long>, JpaSpecificationExecutor {

    EventCodeEntity findOneByCode(String code);
}
