package cz.senslog.processing.util;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.processing.db.queryspecification.QuerySpecificationBuilder;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OK on 12/12/2017.
 */
@Component
public class QueryBuilder {

    private static final Pattern pattern;

    static {
        // pattern = Pattern.compile("(\\w+?\\.?\\w+?)(:|<|>|~)(\\w+?),");
        pattern = Pattern.compile("([\\w\\.]+)(<|>|:)([\\w\\d- :]+)");
    }

    public static Specification<EntityQueryable> build(String search){
        QuerySpecificationBuilder builder = new QuerySpecificationBuilder();
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {

            // try parse value as boolean
            Object value = BooleanUtils.toBooleanObject(matcher.group(3));
            if( value == null ){
                // try parse as long
                try {
                    value = Long.valueOf(matcher.group(3));
                } catch (NumberFormatException e){
                    try {
                        value = Timestamp.valueOf(matcher.group(3));
                    } catch (IllegalArgumentException ee){
                        // just string
                        value = matcher.group(3);
                    }
                }
            }

            builder.with(matcher.group(1), matcher.group(2), value != null ? value : matcher.group(3));
        }

        return builder.build();
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


