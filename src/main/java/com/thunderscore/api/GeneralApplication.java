package com.thunderscore.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * General application.
 */
@ApplicationPath("/")

public class GeneralApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(CarSearch.class );
        h.add(CountryAPI.class);
        h.add(ColorAPI.class);
        h.add(DriveTrainAPI.class);
        h.add(TransmissionAPI.class);
        h.add(BrandAPI.class);
        h.add(ModelAPI.class);
        h.add(EngineAPI.class);
        h.add(TrimAPI.class);
        return h;
    }

}
