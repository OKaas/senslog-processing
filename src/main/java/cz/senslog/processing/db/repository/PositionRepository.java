package cz.senslog.processing.db.repository;


import cz.senslog.model.db.PositionEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by OK on 6/12/2017.
 */
@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long>, JpaSpecificationExecutor, RestRepository {
}


