package com.talan.cep.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.talan.cep.domain.Event;


@Service
public class KafkaService implements Runnable {
	
    private static final Logger LOG = LoggerFactory.getLogger(KafkaService.class);
    
    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topic;

    private static final long INCOMING_DATA_INTERVAL = 500;

    /*public void serviceSend(){
    	//ici je dois implémenter le script sui genere des données aléatoirement
    	
      //  LOG.info("sending message='{}' to topic='{}'", message, topic);
        //kafkaTemplate.send(topic, message);
    	 String[] namesArray={"CompX1", "CompX2", "CompX3"};
         String[] probsArray={"EVT_C_MBUSCOMMERRORCH1", "EVT_B_BATTERIEFAIBLE", "EVT_C_MBUSCOMMERRORCH2"};

         Random r=new Random();
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  
         for (int i = 0; i < 5; i++) {
             Event eventData = new Event();
             eventData.setId(i);
         	Date date = new Date();
             eventData.setEventDate(dateFormat.format(date));
             eventData.setEventName(namesArray[r.nextInt(namesArray.length)]);
             eventData.setEventProb(probsArray[r.nextInt(probsArray.length)]);
             
             String key = UUID.randomUUID().toString();
             Event value = eventData;

             
             //LOGGER.warn("Random events generated: {}: {}", key, value);
             
           //  ProducerRecord<String, Event> record = new ProducerRecord<>(topic, key, value);
             //producer.send(record);

             LOG.info("sending message='{}' to topic='{}'", value, topic);
             kafkaTemplate.send(topic, value);
             

             }
    }*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
		  //getting random item from an namesArray
        String[] namesArray={"CompX1", "CompX2", "CompX3"};
        String[] probsArray={"EVT_C_MBUSCOMMERRORCH1", "EVT_B_BATTERIEFAIBLE", "EVT_C_MBUSCOMMERRORCH2"};

        Random r=new Random();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 
        for (int i = 0; i <Integer.MAX_VALUE; i++) {
            Event eventData = new Event();
            eventData.setId(i);
        	Date date = new Date();
            eventData.setEventDate(dateFormat.format(date));
            eventData.setEventName(namesArray[r.nextInt(namesArray.length)]);
            eventData.setEventProb(probsArray[r.nextInt(probsArray.length)]);
            
            String key = UUID.randomUUID().toString();
            Event value = eventData;

            
            //LOGGER.warn("Random events generated: {}: {}", key, value);
            
          //  ProducerRecord<String, Event> record = new ProducerRecord<>(topic, key, value);
            //producer.send(record);

            LOG.info("sending message='{}' to topic='{}'", value, topic);
            kafkaTemplate.send(topic, value);
            
            try {
                if (INCOMING_DATA_INTERVAL > 0) {
                    Thread.sleep(INCOMING_DATA_INTERVAL);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
		
	}


}
