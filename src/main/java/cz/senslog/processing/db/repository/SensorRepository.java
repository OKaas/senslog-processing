package cz.senslog.processing.db.repository;

import cz.senslog.model.db.SensorEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by OK on 9/14/2017.
 */
@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long>, JpaSpecificationExecutor, RestRepository {
}
