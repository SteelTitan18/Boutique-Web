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
import tg.univlome.epl.boutique.entites.Produit;
import tg.univlome.epl.boutique.service.ProduitService;

/**
 *
 * @author steeltitanunbrk
 */

@Path("/produit")
public class ProduitResource {
    
    private ProduitService service;
    
    public ProduitResource() {
        this.service = ProduitService.getInstance();
    } 
    
    @POST
    @Consumes({"application/json", "application/xml"})
    public void ajouter(Produit p) {
        this.service.ajouter(p);
    }
    
    @PUT
    @Consumes({"application/json", "application/xml"})
    public void modifier(Produit p) {
        this.service.modifier(p);
    }
    
    @DELETE
    @Path("/{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.service.supprimer(id);
    }
    
    @GET
    public List<Produit> lister() {
        return this.service.lister();
    }
    
    @GET
    @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Produit trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }
    
    @GET
    @Path("/taille")
    public int compter() {
        return this.service.compter();
    }
}
