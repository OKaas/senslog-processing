package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EventStatusEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OK on 6/12/2017.
 */
public interface EventStatusRepository extends JpaRepository<EventStatusEntity, Long>, JpaSpecificationExecutor, RestRepository {

    /**
     * Find EventCode description by code
     *
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    EventStatusEntity findOneByCode(String code);
}
