package com.github.daggerok.mp12kee;


import com.github.daggerok.mp12kee.config.ConfigTestController;


import com.github.daggerok.mp12kee.resilient.ResilienceController;


import com.github.daggerok.mp12kee.metric.MetricController;


import com.github.daggerok.mp12kee.secure.ProtectedController;
import com.kumuluz.ee.jwt.auth.feature.JWTRolesAllowedDynamicFeature;
import com.kumuluz.ee.jwt.auth.filter.JWTAuthorizationFilter;
import org.eclipse.microprofile.auth.LoginConfig;


import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 *
 */
@ApplicationPath("/data")

@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"protected"})

public class Mp12keeRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        
        // microprofile jwt auth filters
        classes.add(JWTAuthorizationFilter.class);
        classes.add(JWTRolesAllowedDynamicFeature.class);
        

        // resources
        classes.add(HelloController.class);
        
        classes.add(ConfigTestController.class);
        
        
        classes.add(ResilienceController.class);
        
        
        classes.add(MetricController.class);
        
        
        classes.add(ProtectedController.class);
        

        return classes;
    }

}
