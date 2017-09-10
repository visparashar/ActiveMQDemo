package com.vp.activemq.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldProducer implements Runnable {
	
	public static  final String QUEUE_NAME="producer.vp";

	public void run() {
		// TODO Auto-generated method stub
		try{
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616/");
			Connection con =factory.createConnection();
			con.start();
			
//			create session
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
//			create destination
			Destination destination = session.createQueue(QUEUE_NAME);
			
//			create messageproducer 
			MessageProducer producer =session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
//			create the message
			String message ="Hello World Producer Message  from "+Thread.currentThread().getName() +" "+this.hashCode();
			TextMessage m = session.createTextMessage(message);
//			tell the producer to send the message
			System.out.println("Sent Message "+this.hashCode()+ " by "+Thread.currentThread().getName());
			producer.send(m);
			
			
             session.close();
             con.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
