package cz.senslog.processing.db.queryspecification;

import cz.senslog.processing.rest.RestMapping;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Timestamp;

/**
 * Created by OK on 12/12/2017.
 */
// TODO this class if fucked-up > reduce toPredicate method
public class QuerySpecification<T> implements Specification<T> {

    private static final String DELIMITER = "\\.";
    private SearchCriteria criteria;

    public QuerySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        String[] tok = criteria.getKey().split(DELIMITER);

        Object obj = criteria.getValue();

        // filter on child object
        // child predicate (something.something.property)
        if(tok.length > 1){

            // dot notation
            // add all join tables from the second
            Join<Object, Object> joins = root.join(tok[0]);
            for(int i = 1; i < tok.length - 1; ++i){
                joins = joins.join( tok[i] );
            }
            Path p = joins.get(tok[ tok.length - 1]);

            // reduce this IF and following code
            if( obj instanceof Timestamp ) {
                if (criteria.getOperation().equalsIgnoreCase(">")) {
                    return builder.greaterThanOrEqualTo(
                            p,
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase("<")) {
                    return builder.lessThanOrEqualTo(
                            p,
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase(":")) {
                    if (p.getJavaType() == String.class) {
                        return builder.like(
                                root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                    } else {
                        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                    }
                }
            }

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return builder.greaterThanOrEqualTo(
                        p, criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return builder.lessThanOrEqualTo(
                        p, criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (p.getJavaType() == String.class) {
                    return builder.like(
                            p, "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(p, criteria.getValue());
                }
            }

        // filter on current object
        } else {
            if( obj instanceof Timestamp ){
                if (criteria.getOperation().equalsIgnoreCase(">")) {
                    return builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()),
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase("<")) {
                    return builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()),
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase(":")) {
                    if (root.get(criteria.getKey()).getJavaType() == String.class) {
                        return builder.like(
                                root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                    } else {
                        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                    }
                }
            }

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    return builder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                }
            }
        }

        return null;
    }
}


