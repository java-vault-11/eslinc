package com.linctronix.service;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.linctronix.event" })
public class EventServiceApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
}
/*
public class ConsumerExample {
    // Event handler that prints records to stdout
    static class MyEventHandler implements SimpleEventHandler<MyEventRecord> {
        @Override
        public void handle(MyEventRecord event) throws Exception {
            System.out.println(event);
        }
    }

    // Supplier of event handler instances
    static class MyEventHandlerSupplier implements Supplier<SimpleEventHandler<MyEventRecord>> {
        @Override
        public SimpleEventHandler<MyEventRecord> get() {
            return new MyEventHandler();
        }
    }

    public static void main(String[] args) {
        // Create the consumer
        // MyEventRecord is generated by the Avro Java code generator
        DivolteKafkaConsumer<MyEventRecord> consumer = DivolteKafkaConsumer.createConsumerWithSimpleHandler(
                "divolte",                             // Kafka topic
                "zk1:2181,zk2:2181,zk3:2181",          // Zookeeper quorum hosts + ports
                "my-consumer-group",                   // Kafka consumer group ID
                2,                                     // Number of threads for this consumer instance
                new MyEventHandlerSupplier(),          // Supplier of event handler instances
                MyEventRecord.getClassSchema());       // Avro schema

        // Add a shutdown hook that stops the consumer
        // This handles CTRL+C or kill
        Runtime.getRuntime().addShutdownHook(new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        consumer.shutdownConsumer();
                    }
                }));

        // Start the consumer
        consumer.startConsumer();
    }
}
*/