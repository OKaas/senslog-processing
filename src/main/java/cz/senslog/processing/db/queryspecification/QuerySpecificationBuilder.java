package cz.senslog.processing.db.queryspecification;

import cz.senslog.model.db.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK on 12/12/2017.
 */
public class QuerySpecificationBuilder {

    private final List<SearchCriteria> params;

    public QuerySpecificationBuilder() {
        params = new ArrayList<>();
    }

    public QuerySpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<EntityQueryable> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<EntityQueryable>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new QuerySpecification(param));

        }

        Specification<EntityQueryable> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


