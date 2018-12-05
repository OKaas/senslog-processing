package cz.senslog.processing.db.repository;

import cz.senslog.model.db.UnitEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by OK on 7/4/2017.
 */
public interface UnitRepository extends JpaRepository<UnitEntity, Long>, JpaSpecificationExecutor, RestRepository {

}


