package com.app.app;

import com.app.app.controller.MedicationController;
import com.app.app.entities.MedicationPerPlan;
import com.app.app.entities.MedicationPlan;
import com.app.app.entities.MedicationTaken;
import com.app.app.services.MedicationPerPlanService;
import com.app.app.services.MedicationPlanService;
import com.app.app.services.MedicationTakenService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class gRPCServer implements CommandLineRunner{

    @Autowired
    private MedicationPerPlanService medicationPerPlanService;

    @Autowired
    private MedicationPlanService medicationPlanService;


    public static List<String> medicationList = new ArrayList<>();
    public static String intake_interval;


    @Override
    public void run(String... args) throws Exception {

        List<MedicationPerPlan> mppList = medicationPerPlanService.getAllMedicationPerPlans();
        List<MedicationPlan> mpList = medicationPlanService.getAllMedicationPlans();
        for(MedicationPlan mp: mpList){
           // System.out.println(mp.getIdMedicationPlan());
            if(mp.getPatient().getId_patient() == 5){
                for(MedicationPerPlan mpp: mppList){
                    if(mpp.getMedicationPlan().getIdMedicationPlan().equals(mp.getIdMedicationPlan())){
                        medicationList.add(mpp.getMedication().getName());
                        intake_interval = mp.getIntake_intervals();
                    }
                }
            }
        }

    }
}
