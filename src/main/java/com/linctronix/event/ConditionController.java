package com.linctronix.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.linctronix.event.actor.TheOneActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

@Controller
public class ConditionController {

	@RequestMapping("/greeting")
	@ResponseBody
	public String hello() {
		Map<String, Object> data = new HashMap<>();
		data.put("partition", 1);
		data.put("offset", 2);
		data.put("value", "ok");
		System.out.println(data);
		return "hello,world";
	}
	
	@RequestMapping("/start")
	@ResponseBody
	public String start() {

		int numConsumers = 3;
		String groupId = "taskGroup";
		List<String> topics = Arrays.asList("collection");
		ExecutorService executor = Executors.newFixedThreadPool(numConsumers);
		
		ActorSystem actor_system = ActorSystem.create("hello-world");
		ActorRef theOneActor = actor_system.actorOf(Props.create(TheOneActor.class), "the-one");
		
		final List<ConsumerLoop> consumers = new ArrayList<>();
		for (int i = 0; i < numConsumers; i++) {
			ConsumerLoop consumer = new ConsumerLoop(i, groupId, topics);
			consumer.setActor(theOneActor);
			consumers.add(consumer);
			executor.submit(consumer);
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				for (ConsumerLoop consumer: consumers) {
					consumer.shutdown();
				}
				executor.shutdown();
				try {
					executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		return "OK";
	}
}
