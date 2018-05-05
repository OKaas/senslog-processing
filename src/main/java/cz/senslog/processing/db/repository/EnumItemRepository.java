package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EnumItemEntity;
import cz.senslog.model.db.EventCodeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "enumItem", path = "enumItem")
public interface EnumItemRepository extends PagingAndSortingRepository<EnumItemEntity, Long>, JpaSpecificationExecutor {


    /**
     * Find EnumItem by code
     *
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    EnumItemEntity findOneByCode(String code);
}
