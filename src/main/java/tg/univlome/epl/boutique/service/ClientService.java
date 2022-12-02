/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Client;

/**
 *
 * @author steeltitanunbrk
 */
public class ClientService {
    
    private static List<Client> liste = new LinkedList<>();
    private static ClientService instance = null;

    public ClientService() {
    }
    
    public synchronized static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }
    
    public void ajouter(Client cl) {
        liste.add(cl);
    }
    
    public void modifier(Client cl) {
        int i = liste.indexOf(cl);
        if (i >= 0) {
            liste.set(i, cl);
        }
    }
    
    public void supprimer(Long id) {
        Client cl2 = this.trouver(id);
        if (cl2 != null) {
            liste.remove(cl2);
        }
    }
    
    public Client trouver(Long id) {
        for (Client client : liste) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Client> lister() {
        return liste;
    }
}
