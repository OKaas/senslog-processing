package cz.senslog.processing.db.repository;

import cz.senslog.model.db.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OK on 7/3/2017.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @Transactional(readOnly = true)
    UserEntity findByNameEquals(@Param("name") String name);
}


