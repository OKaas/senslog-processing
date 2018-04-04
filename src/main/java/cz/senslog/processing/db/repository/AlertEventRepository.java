package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EventEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 04-Apr-18.
 */
@RepositoryRestResource(collectionResourceRel = "alertevent", path = "alertevent")
public interface AlertEventRepository extends PagingAndSortingRepository<EventEntity, Long>, JpaSpecificationExecutor {
}
