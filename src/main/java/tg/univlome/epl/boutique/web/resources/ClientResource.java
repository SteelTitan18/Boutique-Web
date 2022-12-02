/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.web.resources;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import tg.univlome.epl.boutique.entites.Client;
import tg.univlome.epl.boutique.service.ClientService;

/**
 *
 * @author steeltitanunbrk
 */
public class ClientResource {
    
    private ClientService service;
    
    public ClientResource() {
        this.service = ClientService.getInstance();
    }
    
    @POST
    public void ajouter(Client c) {
        this.service.ajouter(c);
    }
    
    @PUT
    public void modifier(Client c) {
        this.service.modifier(c);
    }
    
    @DELETE
    public void supprimer(Long id) {
        this.service.supprimer(id);
    }
    
    @GET
    public List<Client> lister() {
        return this.service.lister();
    }
    
    @GET
    @Path("/{id}")
    public Client trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }
    
    @GET
    @Path("/taille")
    public int compter() {
        return this.service.compter();
    }
}
