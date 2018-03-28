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
    public static final String PATH_ALL = "/all";
    public static final String PATH_VALUE = "/value";

    public static final String SEARCH = "search";
    public static final String MOBILE = "mobile";
    public static final String TIME = "time";
    public static final String GROUP_BY = "group";

    public static final String CLIENT_ID = "clientId";
    public static final String PATH_CLIENT_ID = "/{"+CLIENT_ID+"}";

    public static final String UNIT_ID = "unitId";
    public static final String PATH_UNIT_ID = "/{"+UNIT_ID+"}";

    public static final String SENSOR_ID = "sensorId";
    public static final String PATH_SENSOR_ID = "/{"+SENSOR_ID+"}";

    public static final String POSITION_ID = "positionId";
    public static final String PATH_POSITION_ID = "/{"+POSITION_ID+"}";

    public static final String PHENOMENON_ID = "phenomenonId";
    public static final String PATH_PHENOMENON_ID = "/{"+PHENOMENON_ID+"}";

    public static final String PHENOMENON_NAME = "phenomenonName";
    public static final String PATH_PHENOMENON_NAME = "/{"+PHENOMENON_NAME+"}";

    public static final String ALERT_ID = "alertId";
    public static final String PATH_ALERT_ID = "/{"+ALERT_ID+"}";

    public static final String FILTER_CALL = "filter";

    /* --- HTTP STATUS --- */
    public static final HttpStatus STATUS_CREATED = HttpStatus.CREATED;
    public static final HttpStatus STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;
    public static final HttpStatus STATUS_NOT_ACCETABLE = HttpStatus.NOT_ACCEPTABLE;




    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


