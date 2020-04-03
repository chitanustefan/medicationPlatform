package com.app.app;

import com.app.app.entities.MonitoredData;
import com.app.app.entities.MonitoredData2;
import com.app.app.entities.Patient;
import com.app.app.repository.PatientRepository;
import com.app.app.services.MonitoredDataService;
import com.app.app.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Consumer {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    PatientService patientService = new PatientService();

    @Autowired
    MonitoredDataService monitoredDataService = new MonitoredDataService();

    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    private static final String SENDING_URL = "/topic/server-broadcaster";
    private static final String RECEIVING_URL = "/server-receiver";

    @Autowired
    private final SimpMessageSendingOperations template;
    private AtomicLong counter = new AtomicLong(0);

    private String message = "";

    @Autowired
    public Consumer(SimpMessageSendingOperations template) {
        this.template = template;
    }

    @MessageMapping(RECEIVING_URL)
    public void onReceivedMessage(String message) {
        System.out.println("New message received : " + message);
    }

    @SubscribeMapping(SENDING_URL)
    public String onSubscribe() {
        return "SUBSCRIBED : " + message;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage(String notify) {
        template.convertAndSend(SENDING_URL, notify);
    }

    private String buildNextMessage() {
        message = "Test" + counter.getAndIncrement();
        System.out.println("Send message " + message);
        return message;
    }


    public void receiveMessage(String message) throws IOException {
        MonitoredData monitoredData = mapper.readValue(message, MonitoredData.class);
        MonitoredData2 data2 = new MonitoredData2();

        data2.setAct(monitoredData.getAct());
        data2.setFinishTime(monitoredData.getFinishTime());
        data2.setStartTime(monitoredData.getStartTime());

        Patient p = new Patient();

        p = patientService.getPatientByID(5);

        data2.setPatient(p);

//        System.out.println("ID: " + data2.getId_monitoredata2());
//        System.out.println("Patient: " + data2.getPatient().getId_patient());
//        System.out.println("Act: " + data2.getAct());
//        System.out.println("Start:" + data2.getStartTime());
//        System.out.println("Finish: " + data2.getFinishTime());

        data2.setDifference(monitoredData.getDuration().toHours());

        MonitoredData2 saved = monitoredDataService.saveMonitoredData(data2);

        if(monitoredData.getAct().equals("Sleeping") && monitoredData.getDuration().toHours() > 12) {
            sendMessage("slept for more than 12h");
            System.out.println("Sleep period > 12h");
        }
        if(monitoredData.getAct().equals("Leaving") && monitoredData.getDuration().toHours() > 12){
            System.out.println("Leaving period > 12h");
        }
        if(monitoredData.getAct().equals("Showering") && monitoredData.getDuration().toHours() > 1) {
            System.out.println("In bath period > 12h");
        }
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
