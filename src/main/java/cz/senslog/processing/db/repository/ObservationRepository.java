package cz.senslog.processing.db.repository;

import cz.senslog.model.db.ObservationEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by OK on 6/12/2017.
 */
public interface ObservationRepository extends JpaRepository<ObservationEntity, Long>, JpaSpecificationExecutor, RestRepository {
}
