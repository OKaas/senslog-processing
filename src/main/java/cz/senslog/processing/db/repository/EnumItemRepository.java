package cz.senslog.processing.db.repository;

import cz.senslog.model.db.EnumItemEntity;
import cz.senslog.processing.db.RestRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Api(tags = "EnumItemEntity")
@RepositoryRestResource
public interface EnumItemRepository extends PagingAndSortingRepository<EnumItemEntity, Long>, JpaSpecificationExecutor, RestRepository {

    /**
     * Find EnumItem by code
     *
     * @param code
     * @return
     */
    @ApiOperation("Find all by Code")
    @ApiResponses({@ApiResponse(code=201, message="Created", response=EnumItemEntity.class)})
    @Transactional(readOnly = true)
    EnumItemEntity findOneByCode(@Param("code") String code);
}
