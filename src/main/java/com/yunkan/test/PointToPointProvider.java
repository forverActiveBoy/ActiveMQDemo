package com.yunkan.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

//消息生产类
public class PointToPointProvider {
    public static void main(String[] args) throws JMSException{
        //创建连接工厂
        String username = "admin";
        String password = "admin";
        String url = "tcp://192.168.74.148:61616";
        //本次采用tcp连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //创建会话------>参数1：开启事务true 参数2：是消息确认机制属性
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //创建目的地   参数的含义是消息的名字
        Destination destination = new ActiveMQQueue("javaQueue");
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        //创建消息    参数的含义是消息的内容
        TextMessage textMessage = session.createTextMessage("hello   ActiveMQ!!!!");
        //发送消息
        producer.send(textMessage);
        //会话提交
        session.commit();
        //关闭会话
        session.close();
        //关闭连接
        connection.close();
    }
}
