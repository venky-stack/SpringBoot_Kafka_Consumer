package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.constant.AppConstants;

@SpringBootApplication
@KafkaListener(topics = AppConstants.TOPIC, groupId="group_ashokit_order")
public class SpringBootKafkaSubscriber1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaSubscriber1Application.class, args);
	
		System.out.print("*** Msg Recieved From Kafka *** :: ");
		//System.out.println(order);
	}

}
