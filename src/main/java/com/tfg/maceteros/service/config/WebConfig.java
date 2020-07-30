package com.tfg.maceteros.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CorsConfig corsConfig;

    /**
     * Método para la configuración de CORS
     *
     * @param registry
     *         mappings de CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (corsConfig != null && corsConfig.getMappings() != null && ! corsConfig.getMappings().isEmpty()) {
            corsConfig.getMappings().forEach(item -> {
                CorsRegistration reg = registry.addMapping(item.getPathPattern()).allowedOrigins(item.getAllowedOriginsArray())
                        .allowedMethods(item.getAllowedMethodsArray()).allowedHeaders(item.getAllowedHeadersArray())
                        .exposedHeaders(item.getExposedHeadersArray()).maxAge(item.getMaxAge());
                if (item.getAllowCredentials() != null) {
                    reg.allowCredentials(item.getAllowCredentials());
                }
            });
        }
    }

}