package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EventEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by OK on 04-Apr-18.
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>, JpaSpecificationExecutor, RestRepository {
}
