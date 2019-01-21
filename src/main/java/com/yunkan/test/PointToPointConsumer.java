package com.yunkan.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

//消息消费类
public class PointToPointConsumer {
    public static void main(String[] args) throws JMSException{
        String username = "admin";
        String password = "admin";
        String url = "tcp://192.168.74.148:61616";
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建消费者   指定连接的名字
        Destination destination = new ActiveMQQueue("javaQueue");
        MessageConsumer consumer = session.createConsumer(destination);
        //取消息
        TextMessage receive = (TextMessage) consumer.receive();
        //获取消息的内容
        String text = receive.getText();
        System.out.println(text+"***********");
        //关闭会话
        session.close();
        //关闭连接
        connection.close();
        //关闭消费者
        consumer.close();
    }
}
