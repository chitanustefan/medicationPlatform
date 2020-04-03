package com.app.app;

import com.app.app.controller.MedicationController;
import com.app.app.entities.MedicationPerPlan;
import com.app.app.entities.MedicationPlan;
import com.app.app.entities.MedicationTaken;
import com.app.app.services.MedicationPerPlanService;
import com.app.app.services.MedicationPlanService;
import com.app.app.services.MedicationTakenService;
import io.grpc.stub.StreamObserver;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MedProtoService
        extends MedicationGrpc.MedicationImplBase {


    @Override
    public void sendMedication(Empty request, StreamObserver<MedicationList> responseObserver) {
        System.out.println("ALL MEDICATION LIST");

        MedicationList.Builder response = MedicationList.newBuilder();
        med.Builder med = com.app.app.med.newBuilder();

        for (String medication: com.app.app.gRPCServer.medicationList){
            med.setMedName(medication);
            response.addMed(med);
            response.setIntake(gRPCServer.intake_interval);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void medicationTaken(MedicationID request, StreamObserver<MedicationResponse> responseObserver) throws UnsupportedEncodingException {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));

        MedicationResponse.Builder response = MedicationResponse.newBuilder();

        String me = request.getAllMedication();

        String dataString = formatter.format(date);


//        MedicationTaken medicationTaken = new MedicationTaken();
//        medicationTaken.setDateTaken(date);
//        medicationTaken.setMedicationPlan(1);
//        medicationTaken.setMedication(me);
//
//        System.out.println(medicationTaken.getId_medication_taken());
//        System.out.println(medicationTaken.getDateTaken());
//        System.out.println(medicationTaken.getMedication());
//        System.out.println(medicationTaken.getMedicationPlan());
//
//        MedicationTaken saved = medicationTakenService.saveMedicationTaken(medicationTaken);


        HttpPost post = new HttpPost("http://localhost:8080/taken");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("date", dataString));
        urlParameters.add(new BasicNameValuePair("med", me));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response1 = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response1.getEntity()));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Pacient took " + mt.getMedication());
        if(Integer.parseInt(request.getTotalMed())==0){
            response.setMessage("Pacient took all medicine");
            System.out.println("Pacient took all medicine");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
