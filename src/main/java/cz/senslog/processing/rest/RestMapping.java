package cz.senslog.processing.rest;

import org.springframework.http.HttpStatus;

/**
 * Created by OK on 9/11/2017.
 */
// TODO this should be moved to application properties
public class RestMapping {

//    public static final String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mi:ss";
    public static final String PATTERN_TIMESTAMP = "yyyy-MM-dd";

    public static final String PATH_INSERT = "/insert";

    public static final String FILTER_CALL = "filter";

    /* --- HTTP STATUS --- */
    public static final HttpStatus STATUS_CREATED = HttpStatus.CREATED;
    public static final HttpStatus STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;
    public static final HttpStatus STATUS_NOT_ACCETABLE = HttpStatus.NOT_ACCEPTABLE;




    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


