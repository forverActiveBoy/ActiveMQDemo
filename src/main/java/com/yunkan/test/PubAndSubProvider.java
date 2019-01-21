package com.yunkan.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class PubAndSubProvider {
    public static void main(String[] args) throws JMSException{
        //获取连接工厂
        String username = "admin";
        String password = "admin";
        String url= "tcp://192.168.74.148:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
        //获取连接对象
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //获取会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //创建生产者
        Topic topic = session.createTopic("javaTopic");
        MessageProducer producer = session.createProducer(topic);
        Message message = session.createTextMessage("hello  topic");
        producer.send(message);
        //关流
        session.commit();
        session.close();
        connection.close();
    }
}
