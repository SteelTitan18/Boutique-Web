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
import tg.univlome.epl.boutique.messages.AchatMessage;
import tg.univlome.epl.boutique.service.AchatService;

/**
 *
 * @author steeltitanunbrk
 */
public class AchatMessageListener implements ServletContextListener, MessageListener {

    @Inject
    @JMSConnectionFactory("jms/boutiqueConnectionFactory")
    private JMSContext context;
    
    @Resource(lookup = "jms/achatQueue")
    private Queue queue;
    
    private AchatService service;
    
    public AchatMessageListener() {
        this.service = AchatService.getInstance();
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JMSConsumer consumer = this.context.createConsumer(this.queue);
        consumer.setMessageListener(this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void onMessage(Message msg) {
        try {
            AchatMessage message = msg.getBody(AchatMessage.class);
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
            Logger.getLogger(AchatMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
