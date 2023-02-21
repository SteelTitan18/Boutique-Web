/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.web;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import tg.univlome.epl.boutique.entites.Produit;
import tg.univlome.epl.boutique.messages.ProduitMessage;
import tg.univlome.epl.boutique.service.ProduitService;

/**
 *
 * @author steeltitanunbrk
 */

@Named
@RequestScoped
public class ProduitBean implements MessageListener {

    @Inject
    @JMSConnectionFactory("jms/boutiqueConnectionFactory")
    private JMSContext context;
    
    @Resource(lookup = "jms/produitQueue")
    private Queue queue;
    
    private ProduitService service;

    private String texte;
    private List<Produit> liste;
    
    public ProduitBean() {
        this.service = ProduitService.getInstance();
    }
    
    @PostConstruct
    public void init() {  //Après le déploiement de l'apk
        JMSConsumer consumer = this.context.createConsumer(this.queue);
        Message msg = consumer.receive();
        try {
            ProduitMessage message = msg.getBody(ProduitMessage.class);
            this.texte = message.toString();
            switch (message.getType()) {
                case AJOUTER:
                    this.service.ajouter(message.getEntite());
                    break;
                case COMPTER:
                    this.service.compter();
                    break;
                case LISTER:
                    this.service.lister();
                    break;
                case MODIFIER:
                    this.service.modifier(message.getEntite());
                    break;
                case SUPPRIMER:
                    this.service.supprimer(message.getEntite().getId());
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (JMSException ex) {
            Logger.getLogger(ProduitBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.liste = this.service.lister();
    }

    @Override
    public void onMessage(Message msg) {
        try {
            ProduitMessage message = msg.getBody(ProduitMessage.class);
            this.texte = message.toString();
            switch (message.getType()) {
                case AJOUTER:
                    this.service.ajouter(message.getEntite());
                    break;
                case COMPTER:
                    this.service.compter();
                    break;
                case LISTER:
                    this.service.lister();
                    break;
                case MODIFIER:
                    this.service.modifier(message.getEntite());
                    break;
                case SUPPRIMER:
                    this.service.supprimer(message.getEntite().getId());
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (JMSException ex) {
            Logger.getLogger(ProduitBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Produit> getListe() {
        return liste;
    }

    public void setListe(List<Produit> liste) {
        this.liste = liste;
    }
    
    
}
