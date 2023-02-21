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
import tg.univlome.epl.boutique.entites.Personne;
import tg.univlome.epl.boutique.service.PersonneService;

/**
 *
 * @author steeltitanunbrk
 */

@Path("/personne")
public class PersonneResource {
    
    private PersonneService service;
    
    public PersonneResource() {
        this.service = PersonneService.getInstance();
    }
    
    @POST
    @Consumes({"application/json", "application/xml"})
    public void ajouter(Personne p) {
        this.service.ajouter(p);
    }
    
    @PUT
    @Consumes({"application/json", "application/xml"})
    public void modifier(Personne p) {
        this.service.modifier(p);
    }
    
    @DELETE
    public void supprimer(Long id) {
        this.service.supprimer(id);
    }
    
    @GET
    public List<Personne> lister() {
        return this.service.lister();
    }
    
    @GET
    @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Personne trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }
    
    @GET
    @Path("/taille")
    public int compter() {
        return this.service.compter();
    }
}
