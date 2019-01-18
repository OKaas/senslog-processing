package cz.senslog.processing.db.repository;

import cz.senslog.model.db.UserEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OK on 7/3/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, RestRepository {

    @Transactional(readOnly = true)
    UserEntity findByNameEquals(@Param("name") String name);
}


