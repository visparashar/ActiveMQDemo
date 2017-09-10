package com.vp.activemq;

import com.vp.activemq.consumer.HelloWorldConsumer;
import com.vp.activemq.producer.HelloWorldProducer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
       /*thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       thread(new HelloWorldProducer(),false);
       Thread.sleep(1000);*/
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       thread(new HelloWorldConsumer(),false);
       
    }
    
    public static void thread(Runnable run , boolean flag){
    	Thread blockThread = new Thread(run);
    	blockThread.setDaemon(flag);
    	blockThread.start();
    }
    
    
}
