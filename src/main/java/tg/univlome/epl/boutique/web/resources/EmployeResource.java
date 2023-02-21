/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.web.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import tg.univlome.epl.boutique.entites.Employe;
import tg.univlome.epl.boutique.service.EmployeService;

/**
 *
 * @author steeltitanunbrk
 */

@Path("/employé")
public class EmployeResource {
    
    private EmployeService service;
    
    public EmployeResource() {
        this.service = EmployeService.getInstance();
    }
    
    @POST
    @Consumes({"application/json", "application/xml"})
    public void ajouter(Employe e) {
        this.service.ajouter(e);
    }
    
    @PUT
    @Consumes({"application/json", "application/xml"})
    public void modifier(Employe e) {
        this.service.modifier(e);
    }
    
    @DELETE
    public void supprimer(Long id) {
        this.service.supprimer(id);
    }
    
    @GET
    public List<Employe> lister() {
        return this.service.lister();
    }
    
    @GET
    @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Employe trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }
    
    @GET
    @Path("/taille")
    public int compter() {
        return this.service.compter();
    }
}
