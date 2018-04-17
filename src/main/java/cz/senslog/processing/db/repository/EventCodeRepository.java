package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EventCodeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "eventCode", path = "eventCode")
public interface EventCodeRepository extends PagingAndSortingRepository<EventCodeEntity, Long>, JpaSpecificationExecutor {

    /**
     * Find EventCode description by code
     *
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    EventCodeEntity findOneByCode(String code);
}
