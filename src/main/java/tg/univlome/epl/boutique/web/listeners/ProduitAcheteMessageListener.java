/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.web.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import tg.univlome.epl.boutique.messages.ProduitAcheteMessage;
import tg.univlome.epl.boutique.service.ProduitAcheteService;

/**
 *
 * @author steeltitanunbrk
 */
public class ProduitAcheteMessageListener implements ServletContextListener, MessageListener {

    @Inject
    @JMSConnectionFactory("jms/boutiqueConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/produitAcheteQueue")
    private Queue queue;

    private ProduitAcheteService service;

    public ProduitAcheteMessageListener() {
        this.service = ProduitAcheteService.getInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JMSConsumer consumer = context.createConsumer(this.queue);
        consumer.setMessageListener(this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void onMessage(Message msg) {
        try {
            ProduitAcheteMessage message = msg.getBody(ProduitAcheteMessage.class);
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
                    this.service.supprimer(message.getEntite().getAchat().getId());
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (JMSException ex) {
            Logger.getLogger(ProduitAcheteMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
