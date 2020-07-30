package com.tfg.maceteros.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Configuracion para CORS
 */
@Component
@ConfigurationProperties(prefix="cors")
public class CorsConfig {

    private List<Mapping> mappings = Collections.emptyList();

    /**
     * Obtiene la lista de mappins
     * @return lista de mappings
     */
    public List<Mapping> getMappings() {
        return new ArrayList<>(mappings);
    }

    /**
     * Establece la lista de mappings
     * @param mappings lista de mappins
     */
    public void setMappings(List<Mapping> mappings) {
        this.mappings = new ArrayList<>(mappings);
    }

    /**
     * Mappings para la configuración de CORS
     */
    public static class Mapping {

        private static final List<String> DEFAULT_PERMIT_ALL = Collections.singletonList("*");
        private static final List<String> DEFAULT_PERMIT_METHODS =
                Collections.unmodifiableList(Arrays.asList(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name()));
        private static final Long DEFAULT_MAX_AGE = 3600L;

        private String pathPattern;
        private List<String> allowedOrigins = DEFAULT_PERMIT_ALL;
        private List<String> allowedMethods = DEFAULT_PERMIT_METHODS;
        private List<String> allowedHeaders = DEFAULT_PERMIT_ALL;
        private List<String> exposedHeaders = Collections.emptyList();
        private Boolean allowCredentials;
        private Long maxAge = DEFAULT_MAX_AGE;

        /**
         * Devuelve el patron para el path
         * @return patron de path
         */
        public String getPathPattern() {
            return pathPattern;
        }

        /**
         * Establece el patron de path
         * @param pathPattern patron de path
         */
        public void setPathPattern(String pathPattern) {
            this.pathPattern = pathPattern;
        }

        /**
         * Devuelve la lista de origenes permitidos
         * @return  lista de origenes permitidos
         */
        public List<String> getAllowedOrigins() {
            return new ArrayList<>(allowedOrigins);
        }

        /**
         * Establece la lista de origenes permitidos
         * @param allowedOrigins lista de origenes permitidos
         */
        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = new ArrayList<>(allowedOrigins);
        }

        /**
         * Devuelve los métodos permitidos
         * @return lista de método permitidos
         */
        public List<String> getAllowedMethods() {
            return new ArrayList<>(allowedMethods);
        }

        /**
         * Establece los métodos permitidos
         * @param allowedMethods lista de métodos permitidos
         */
        public void setAllowedMethods(List<String> allowedMethods) {
            this.allowedMethods = new ArrayList<>(allowedMethods);
        }

        /**
         * Obtiener las cabeceras permitidas
         * @return lista de cabeceras permitidas
         */
        public List<String> getAllowedHeaders() {
            return new ArrayList<>(allowedHeaders);
        }

        /**
         * Establece las cabeceras permitidas
         * @param allowedHeaders lista de cabeceras permitidas
         */
        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = new ArrayList<>(allowedHeaders);
        }

        /**
         * Obtiene las cabeceras de respuesta
         * @return lista de cabeceras respuesta
         */
        public List<String> getExposedHeaders() {
            return new ArrayList<>(exposedHeaders);
        }

        /**
         * Establece las cabeceras de respuesta
         * @param exposedHeaders lista de cabeceras de respuesta
         */
        public void setExposedHeaders(List<String> exposedHeaders) {
            this.exposedHeaders = new ArrayList<>(exposedHeaders);
        }

        /**
         * Devuelve si las credenciales están permitidas
         * @return true si las credenciales están permitidas. false en caso contrario
         */
        public Boolean getAllowCredentials() {
            return allowCredentials;
        }

        /**
         * Establece si las credenciales están permitidas
         * @param allowCredentials  true si las credenciales están permitidas. false en caso contrario.
         */
        public void setAllowCredentials(Boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }

        /**
         * Devuelve la edad máxima
         * @return edad máxima
         */
        public Long getMaxAge() {
            return maxAge;
        }

        /**
         * Establece la edad máxima
         * @param maxAge edad máxima
         */
        public void setMaxAge(Long maxAge) {
            this.maxAge = maxAge;
        }

        /**
         * Devuelve la lista de origenes permitidos en formato Array
         * @return Array de origenes permitidos
         */
        public String[] getAllowedOriginsArray() {
            return listToArray(this.allowedOrigins);
        }

        /**
         * Devuelve la lista de métodos permitidos en formato Array
         * @return Array de métodos permitidos
         */
        public String[] getAllowedMethodsArray() {
            return listToArray(this.allowedMethods);
        }

        /**
         * Devuelve la lista de cabeceras permitadas en formato Array
         * @return Array de cabeceras permitidas
         */
        public String[] getAllowedHeadersArray() {
            return listToArray(this.allowedHeaders);
        }

        /**
         * Devuelve la lista de cabeceras de respuesta en formato Array
         * @return Array de cabeceras de respuesta
         */
        public String[] getExposedHeadersArray() {
            return listToArray(this.exposedHeaders);
        }

        private static String[] listToArray(List<String> list) {
            String[] resultado = new String[0];
            if (list != null) {
                resultado = list.toArray(new String[0]);
            }
            return resultado;
        }
    }

}