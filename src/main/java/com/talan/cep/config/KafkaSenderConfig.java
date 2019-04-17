package com.talan.cep.config;

import java.util.HashMap;

import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.talan.cep.domain.Event;

@Configuration 
public class KafkaSenderConfig {

	@Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

	@Bean
	public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        //props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
      return props;
    }
	
	@Bean
    public ProducerFactory<String, Event> producerFactory() {
		
		StringSerializer keySerializer = new StringSerializer();

        JsonSerializer<Event> valueJsonSerializer = new JsonSerializer<>();
        valueJsonSerializer.setAddTypeInfo(false);
        valueJsonSerializer.setUseTypeMapperForKey(false);

        
        return new DefaultKafkaProducerFactory<>(producerConfigs(),keySerializer,valueJsonSerializer);
    }
	
	@Bean
    public KafkaTemplate<String, Event> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	/*
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
	    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    return new KafkaAdmin(configs);
	}*/
	
	/*@Bean
	public NewTopic topic1() {
		return new NewTopic("topicname", 1, (short) 1);
	}*/
	
	
}
