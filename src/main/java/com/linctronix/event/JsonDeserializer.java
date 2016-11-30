package com.linctronix.event;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializer implements Deserializer<Message> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message deserialize(String topic, byte[] data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(data, Message.class);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
