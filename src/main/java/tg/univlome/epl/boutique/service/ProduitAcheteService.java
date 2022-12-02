/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.ProduitAchete;

/**
 *
 * @author steeltitanunbrk
 */
public class ProduitAcheteService {
    
    private static List<ProduitAchete> liste = new LinkedList<>();
    private static ProduitAcheteService instance = null;

    public ProduitAcheteService() {
    }
    
    public synchronized static ProduitAcheteService getInstance() {
        if (instance == null) {
            instance = new ProduitAcheteService();
        }
        return instance;
    }
    
    public void ajouter(ProduitAchete pa) {
        liste.add(pa);
    }
    
    public void modifier(ProduitAchete pa) {
        int i = liste.indexOf(pa);
        if (i >= 0) {
            liste.set(i, pa);
        }
    }
    
    public void supprimer(Long id) {
        ProduitAchete pa2 = this.trouver(id);
        if (pa2 != null) {
            liste.remove(pa2);
        }
    }
    
    public ProduitAchete trouver(Long id) {
        for (ProduitAchete produitAchete : liste) {
            if (produitAchete.getAchat().getId() == id) {
                return produitAchete;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<ProduitAchete> lister() {
        return liste;
    }
}
