package com.yunkan.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;
import javax.xml.soap.Text;

public class PubAndSubConsumer {
    public static void main(String[] args) throws JMSException{
        //获取连接工厂
        String username = "admin";
        String password = "admin";
        String url= "tcp://192.168.74.148:61616";
        TopicConnectionFactory topicConnectionFactory = new ActiveMQConnectionFactory(username,password,url);
        TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
        topicConnection.start();
        TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = topicSession.createTopic("javaTopic");
        TopicSubscriber subscriber = topicSession.createSubscriber(topic);
        while (true){
            TextMessage receive = (TextMessage) subscriber.receive();
            String text = receive.getText();
            System.out.println(text+"********");
        }
    }
}
