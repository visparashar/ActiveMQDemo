package com.vp.activemq.consumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.vp.activemq.producer.HelloWorldProducer;

public class HelloWorldConsumer implements Runnable , javax.jms.ExceptionListener{

	
	public void run() {
		// TODO Auto-generated method stub
		try{
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616/");
			Connection con = factory.createConnection();
			con.start();
			con.setExceptionListener(this);
			
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination des = session.createQueue(HelloWorldProducer.QUEUE_NAME);
			MessageConsumer consumer = session.createConsumer(des);
			 Message message = consumer.receive(1000);
			 
			 if(message instanceof TextMessage){
				 TextMessage textMessage = (TextMessage) message;
                 String text = textMessage.getText();
                 System.out.println("Received: " + text);
			 }else {
                 System.out.println("Received: " + message);
             }
			 consumer.close();
             session.close();
             con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	

	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("some exception occured "+arg0.getErrorCode() );
		
	}
	
	

}
