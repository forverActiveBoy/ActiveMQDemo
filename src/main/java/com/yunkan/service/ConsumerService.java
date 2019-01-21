package com.yunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class ConsumerService {
    @Autowired
    private JmsTemplate jmsTemplate;
    public TextMessage receive(){
        Destination defaultDestination = jmsTemplate.getDefaultDestination();
        TextMessage message = (TextMessage)jmsTemplate.receive(defaultDestination);
        return message;
    }
}
