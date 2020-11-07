/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Juan Carlos Arguello Ortiz
 */
@javax.ws.rs.ApplicationPath("recursos")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.ConsultaMedicaFacadeREST.class);
        resources.add(services.HistorialClinicoFacadeREST.class);
        resources.add(services.HospitalFacadeREST.class);
        resources.add(services.HospitalServicioFacadeREST.class);
        resources.add(services.MedicoFacadeREST.class);
        resources.add(services.PacienteFacadeREST.class);
        resources.add(services.ServicioFacadeREST.class);
    }
    
}
