package com.bjpowernode.activemq.map;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ClassName:MapSender
 * Package:com.bjpowernode.activemq.map
 * Description:
 *
 * @date:2018/10/16 9:45
 * @author:bjpowernode.com
 */
public class MapSender {

    public static void main(String[] args) {
        send();
    }

    private static void send() {
        MessageProducer producer=null;
        Session session= null;
        Connection connection=null;
        try {
            //1.根据Broker地址创建连接工厂对象
            ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.31.128:61616");
            //2.创建连接对象
            connection=connectionFactory.createConnection();
            //3.创建Session回话对象，
            // 参数1为是否使用事务性的消息 false表示不使用事务 true表示使用事务
            //参数2表示消息的确认机制，会影响消息的接收方法而不会影响发送方法Session.AUTO_ACKNOWLEDGE表示自动确认
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //4.创建一个目的地对象，createQueue创建一个基于点对点的目的地对象，参数为目的地名称，需要与接收时对应
            Destination destination=session.createQueue("myMap");
            //5.创建一个Map类型的消息
            //Map消息只支持基本数据类型和对应的包装类以及String 其他类型不支持
            MapMessage message=session.createMapMessage();
            message.setInt("age",24);
            message.setString("name","李四");
            message.setLong("id",2L);

            //6.创建消息的发送者 ,并设定消息的发送位置
            producer=session.createProducer(destination);
            //7.发送消息到指定的目的地
            producer.send(message);
            System.out.println("消息发送成功");
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(producer!=null){
                try {
                    producer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if(session!=null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
