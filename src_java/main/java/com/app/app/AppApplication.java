package com.app.app;

import com.app.app.controller.MedicationController;
import com.app.app.entities.Medication;
import com.app.app.entities.MedicationPlan;
import com.app.app.services.MedicationPlanService;
import com.app.app.services.MedicationService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class AppApplication {

	static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "activities";

	@Bean
	org.springframework.amqp.core.Queue queue() {
		return new org.springframework.amqp.core.Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Consumer receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(AppApplication.class, args);

		Server server = ServerBuilder.forPort(9090).addService(new MedProtoService()).build();
		server.start();
		System.out.println("Server Started at " + server.getPort());
		server.awaitTermination();

//		getMedications();
//		List<MedicationPlan> medList = medicationPlanService.getAllMedicationPlans();
//		List<Medication> list = medicationController.getAllMedications();
//		for (Medication m: list){
//			System.out.println(m.getName());
//		}
//		System.out.println();
//
//		for(MedicationPlan mp: medList){
//			if(mp.getPatient().getId_patient()==5)
//				System.out.println(mp.getPatient().getUser().getName());
//		}

/*		Server server = ServerBuilder.forPort(9090).addService(new MedProtoService()).build();

		server.start();

		System.out.println("Server Started at " + server.getPort());

		server.awaitTermination();*/


	}

}
