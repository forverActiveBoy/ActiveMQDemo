package com.yunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class ProviderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final String mes){
        MessageCreator messageCreator = new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(mes);
                return textMessage;
            }
        };
        jmsTemplate.send(messageCreator);
    }
}
