/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.LinkedList;
import java.util.List;
import tg.univlome.epl.boutique.entites.Employe;

/**
 *
 * @author steeltitanunbrk
 */
public class EmployeService {
    
    private static List<Employe> liste = new LinkedList<>();
    private static EmployeService instance = null;

    public EmployeService() {
    }
    
    public synchronized static EmployeService getInstance() {
        if (instance == null) {
            instance = new EmployeService();
        }
        return instance;
    }
    
    public void ajouter(Employe e) {
        liste.add(e);
    }
    
    public void modifier(Employe e) {
        int i = liste.indexOf(e);
        if (i >= 0) {
            liste.set(i, e);
        }
    }
    
    public void supprimer(Long id) {
        Employe e2 = this.trouver(id);
        if (e2 != null) {
            liste.remove(e2);
        }
    }
    
    public Employe trouver(Long id) {
        for (Employe employe : liste) {
            if (employe.getId() == id) {
                return employe;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Employe> lister() {
        return liste;
    }
}
