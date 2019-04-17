package com.talan.cep.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talan.cep.service.KafkaService;

@RestController
@RequestMapping(value = "/kafka/")
public class KafkaController {

	@Autowired
	KafkaService kafkaService;
	
	@GetMapping(value = "/producer22")
	public String producer() {
		kafkaService.run();
		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
}
