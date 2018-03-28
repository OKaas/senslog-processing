package cz.senslog.processing.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Created by OK on 7/4/2017.
 */
@Component
public class Mapper extends ModelMapper {

    /* --- Collaborates --- */
    @Override
    public <D> D map(Object source, Class<D> destinationType)
    {
        if (source == null)
            return null;

        return super.map(source, destinationType);
    }

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


