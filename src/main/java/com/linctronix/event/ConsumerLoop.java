package com.linctronix.event;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import org.apache.kafka.common.TopicPartition;

public class ConsumerLoop implements Runnable {
	private final KafkaConsumer<String, Message> consumer;
	private final List<String> topics;
	private final int id;
	private ActorRef actor;

	public ConsumerLoop(int id, String groupId, List<String> topics) {
		this.id = id;
		this.topics = topics;
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", groupId);
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", JsonDeserializer.class.getName());
		this.consumer = new KafkaConsumer<>(props);
	}

	@Override
	public void run() {
		try{
			consumer.subscribe(topics);
			while (true) {
				ConsumerRecords<String, Message> records = consumer.poll(Long.MAX_VALUE);
				for (ConsumerRecord<String, Message> record: records) {
					/*
					Map<String, Object> data = new HashMap<>();
					data.put("partition", record.partition());
					data.put("offset", record.offset());
					data.put("value", record.value());
					*/
					//System.out.println(this.id + ": " + record.value());
					this.actor.tell(record.value(), null);
				}
			}
		} catch (WakeupException e) {
			// ignore for shutdown
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}

	public void shutdown() {
		consumer.wakeup();
	}

	public void setActor(ActorRef actor) {
		this.actor = actor;
	}
}
