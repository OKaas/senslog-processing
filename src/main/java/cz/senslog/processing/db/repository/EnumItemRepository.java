package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EnumItemEntity;
import cz.senslog.processing.db.RestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnumItemRepository extends JpaRepository<EnumItemEntity, Long>, JpaSpecificationExecutor, RestRepository {


    /**
     * Find EnumItem by code
     *
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    EnumItemEntity findOneByCode(String code);
}
