/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Produit;

/**
 *
 * @author steeltitanunbrk
 */
public class ProduitService {
    
    private static List<Produit> liste = new LinkedList<>();
    private static ProduitService instance = null;

    public ProduitService() {
    }
    
    public synchronized static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }
    
    public void ajouter(Produit p) {
        liste.add(p);
    }
    
    public void modifier(Produit p) {
        int i = liste.indexOf(p);
        if (i >= 0) {
            liste.set(i, p);
        }
    }
    
    public void supprimer(Long id) {
        Produit p2 = this.trouver(id);
        if (p2 != null) {
            liste.remove(p2);
        }
    }
    
    public Produit trouver(Long id) {
        for (Produit produit : liste) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Produit> lister() {
        return liste;
    }
}
