/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Categorie;

/**
 *
 * @author steeltitanunbrk
 */
public class CategorieService {
    
    private static List<Categorie> liste = new LinkedList<>();
    private static CategorieService instance = null;

    public CategorieService() {
    }
    
    public synchronized static CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }
    
    public void ajouter(Categorie c) {
        liste.add(c);
    }
    
    public void modifier(Categorie c) {
        int i = liste.indexOf(c);
        if (i >= 0) {
            liste.set(i, c);
        }
    }
    
    public void supprimer(Long id) {
        Categorie c2 = this.trouver(id);
        if (c2 != null) {
            liste.remove(c2);
        }
    }
    
    public Categorie trouver(Long id) {
        for (Categorie categorie : liste) {
            if (categorie.getId() == id) {
                return categorie;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Categorie> lister() {
        return liste;
    }
}
