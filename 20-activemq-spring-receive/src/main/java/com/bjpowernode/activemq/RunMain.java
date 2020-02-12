package com.bjpowernode.activemq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:RunMain
 * Package:com.bjpowernode.activemq
 * Description:
 *
 * @date:2018/10/18 10:25
 * @author:bjpowernode.com
 */
public class RunMain {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
//        SpringReceive receive= (SpringReceive) context.getBean("springReceive");
//        receive.receive();
    }
}
