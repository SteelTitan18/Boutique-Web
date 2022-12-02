/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Personne;

/**
 *
 * @author steeltitanunbrk
 */
public class PersonneService {
    
    private static List<Personne> liste = new LinkedList<>();
    private static PersonneService instance = null;

    public PersonneService() {
    }
    
    public synchronized static PersonneService getInstance() {
        if (instance == null) {
            instance = new PersonneService();
        }
        return instance;
    }
    
    public void ajouter(Personne p) {
        liste.add(p);
    }
    
    public void modifier(Personne p) {
        int i = liste.indexOf(p);
        if (i >= 0) {
            liste.set(i, p);
        }
    }
    
    public void supprimer(Long id) {
        Personne p2 = this.trouver(id);
        if (p2 != null) {
            liste.remove(p2);
        }
    }
    
    public Personne trouver(Long id) {
        for (Personne personne : liste) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Personne> lister() {
        return liste;
    }
}
