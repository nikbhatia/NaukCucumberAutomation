package com.naukri.automation.util;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility file to connect through Kafka Queue as a consumer
 * 
 * @author rachit.mehrotra
 *
 */
public class KafkaConsumerUtil {

	@SuppressWarnings({ "unchecked" })
	public static Map<String, String> kafkaConsumer(String connectionIP, String topicName) throws Exception {

		// Configuring Kafka Consumer
		final Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, connectionIP);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test123");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100");

		// Creating Kafka Consumer with desired properties 
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
		TestNGLogUtility.info("Kafka Consumer Connected on " + connectionIP);

		/*
		 * Using singleton list as subscribing to a single topic and it will take topic
		 * name as the parameter from kafkaConfig.yml
		 */
		kafkaConsumer.subscribe(Collections.singleton(topicName));
		TestNGLogUtility.info("Subscribed to topic " + topicName);
		
		while (true) {
			Duration duration = Duration.ofMillis(10000);
			ConsumerRecords<String, String> records = kafkaConsumer.poll(duration);
			Iterator<ConsumerRecord<String, String>> i = records.iterator();
			System.out.println("no of polled records " + records.count());
			for (ConsumerRecord<String, String> record : records) {
				//Logging done to increase debuggability
				TestNGLogUtility.info(" Value : " + record.value() + " Partition: " + record.partition() + " Offset: "
						+ record.offset());
				ObjectMapper obj = new ObjectMapper();
				Map<String, String> consumedMessage = obj.readValue(record.value(), Map.class);
				//using thread.sleep as to provide some duration as a gap for polling next record in QUEUE
				Thread.sleep(5000);
			}
		}
	}
}