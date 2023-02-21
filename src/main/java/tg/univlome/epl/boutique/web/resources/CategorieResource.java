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
import javax.ws.rs.core.MediaType;
import tg.univlome.epl.boutique.entites.Categorie;
import tg.univlome.epl.boutique.service.CategorieService;

/**
 *
 * @author steeltitanunbrk
 */

@Path("/categorie")
public class CategorieResource {
    
    private CategorieService service;
    
    public CategorieResource() {
        this.service = CategorieService.getInstance();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void ajouter(Categorie c) {
        this.service.ajouter(c);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void modifier(Categorie c) {
        this.service.modifier(c);
    }
    
    @DELETE
    public void supprimer(Long id) {
        this.service.supprimer(id);
    }
    
    @GET
    public List<Categorie> lister() {
        return this.service.lister();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public Categorie trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }
    
    @GET
    @Path("/taille")
    public int compter() {
        return this.service.compter();
    }
}
