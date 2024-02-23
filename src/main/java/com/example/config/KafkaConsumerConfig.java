package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.binding.Order;
import com.example.constant.KafkaConstants;

@Configuration
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, Order> consumerFactory(){
		
		Map<String,Object> config =new HashMap<String, Object>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>());
	}
	
	public ConcurrentKafkaListenerContainerFactory<String, Order> KafkaListnerFactory(){		
		ConcurrentKafkaListenerContainerFactory<String,Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}