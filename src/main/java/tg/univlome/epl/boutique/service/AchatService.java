/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Achat;

/**
 *
 * @author steeltitanunbrk
 */
public class AchatService {
    
    private static List<Achat> liste = new LinkedList<>();
    private static AchatService instance = null;

    public AchatService() {
    }
    
    public synchronized static AchatService getInstance() {
        if (instance == null) {
            instance = new AchatService();
            liste.add(new Achat(1, LocalDate.now(), 0, null, null));
        }
        return instance;
    }
    
    public void ajouter(Achat a) {
        liste.add(a);
    }
    
    public void modifier(Achat a) {
        int i = liste.indexOf(a);
        if (i >= 0) {
            liste.set(i, a);
        }
    }
    
    public void supprimer(long id) {
        Achat a2 = this.trouver(id);
        if (a2 != null) {
            liste.remove(a2);
        }
    }
    
    public Achat trouver(long id) {
        for (Achat achat : liste) {
            if (achat.getId() == id) {
                return achat;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Achat> lister() {
        return liste;
    }
}
