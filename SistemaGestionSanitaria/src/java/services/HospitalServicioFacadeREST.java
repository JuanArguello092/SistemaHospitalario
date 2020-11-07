/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.HospitalServicio;
import entities.HospitalServicioPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author user
 */
@javax.ejb.Stateless
@Path("hospitalservicio")
public class HospitalServicioFacadeREST extends AbstractFacade<HospitalServicio> {

    @PersistenceContext(unitName = "SistemaGestionSanitariaPU")
    private EntityManager em;

    private HospitalServicioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codhospital=codhospitalValue;idservicio=idservicioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.HospitalServicioPK key = new entities.HospitalServicioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codhospital = map.get("codhospital");
        if (codhospital != null && !codhospital.isEmpty()) {
            key.setCodhospital(new java.lang.Integer(codhospital.get(0)));
        }
        java.util.List<String> idservicio = map.get("idservicio");
        if (idservicio != null && !idservicio.isEmpty()) {
            key.setIdservicio(new java.lang.Integer(idservicio.get(0)));
        }
        return key;
    }

    public HospitalServicioFacadeREST() {
        super(HospitalServicio.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(HospitalServicio entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, HospitalServicio entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.HospitalServicioPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public HospitalServicio find(@PathParam("id") PathSegment id) {
        entities.HospitalServicioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<HospitalServicio> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<HospitalServicio> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        em = Persistence.createEntityManagerFactory("SistemaGestionSanitariaPU").createEntityManager();
        return em;
    }
    
}
