package com.app.app.controller;

import com.app.app.entities.*;
import com.app.app.services.MedicationPlanService;
import com.app.app.services.MedicationService;
import com.app.app.services.MedicationTakenService;
import com.app.app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicationController {


    @Autowired
    MedicationPlanService medicationPlanService = new MedicationPlanService();

    @Autowired
    MedicationService medicationService = new MedicationService();

    @Autowired
    PatientService patientService = new PatientService();

    @Autowired
    MedicationTakenService medicationTakenService = new MedicationTakenService();

    public MedicationController() {
    }

    @PostMapping("{id_patient}/{intake}/{period}/add/medplan")
    public MedicationPlan addMedicationPlan(@RequestBody List<Medication> medication, @PathVariable("id_patient") int id_patient,
                                            @PathVariable("intake") int intake, @PathVariable("period") int period)  {

        MedicationPlan medPlan = new MedicationPlan();
        System.out.println(id_patient);
        System.out.println(intake);
        System.out.println(period);
        for(Medication m : medication)
            System.out.println(m.getName());

        List<Patient > patientList = patientService.getAllPatient();
        Patient patient = new Patient();
        for(Patient p: patientList){
            if(p.getId_patient() == id_patient)
                patient = p;
        }
        List<MedicationPerPlan> mp = new ArrayList<>();

        for(Medication m: medication){
            MedicationPerPlan medperPlan = new MedicationPerPlan();
            medperPlan.setMedication(m);
            medperPlan.setMedicationPlan(medPlan);
            mp.add(medperPlan);
        }


        medPlan.setPatient(patient);
        medPlan.setIntake_intervals(Integer.toString(intake));
        medPlan.setPeriod(Integer.toString(period));
        medPlan.setMedicationPerPlans(mp);

        return medicationPlanService.saveMedicationPlan(medPlan);

    }

    @PostMapping("/doctor/medication-list")
    public Medication editMedication(@RequestBody Medication medication){
        System.out.println(medication.getName());
        return medicationService.updateMedication(medication.getId_medication(), medication);

    }

    @PostMapping("/delete/medication")
    public void deleteMedication(@RequestBody int id_medication) {
        System.out.println("Delete: " + id_medication);
        Long id = (long) id_medication;
        medicationService.deleteMedication(id);

    }

    @GetMapping("/doctor/medication-list")
    public List<Medication> getAllMedications(){
        List<Medication> list = medicationService.getAllMedications();
        return list;
    }

    @GetMapping("/doctor/medication-plan-byid/{id_patient}")
    public List<Medication> getAllMedicationPlans(@PathVariable("id_patient") int id_patient){
        List<MedicationPlan> list = medicationPlanService.getAllMedicationPlans();
        List<Medication> mpList = new ArrayList<>();
        for(MedicationPlan mp : list){
            if(mp.getPatient().getId_patient() == id_patient){
                for(MedicationPerPlan mpp: mp.getMedicationPerPlans()){
                    mpList.add(mpp.getMedication());
                }
            }
        }
        return mpList;
    }

    @GetMapping("/doctor/medication-taken/{id_patient}/{date}")
    public List<MedicationTaken> getAllMedicationTaken(@PathVariable("id_patient") int id_patient,@PathVariable("date") String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<MedicationTaken> list = medicationTakenService.getAllMedicationsTaken();
        List<MedicationTaken> mpList = new ArrayList<>();
        for(MedicationTaken mt : list){
            String dateTaken = formatter.format(mt.getDateTaken());
            if(mt.getMedicationPlan() == 1 && dateTaken.equals(date)){
                System.out.println("Date: "+ date);
                System.out.println("Date taken: " + dateTaken);
                mpList.add(mt);
            }
        }
        return mpList;
    }

    @PostMapping("/add/medication")
    public Medication addMedication(@RequestBody Medication medication) throws ParseException {

        System.out.println(medication.getSideEffects());
        return  medicationService.saveMedication(medication);

    }

    @GetMapping("/doctor/taken-list-by-day")
    public List<Medication> getAllMedicationsTaken(){
        List<Medication> list = medicationService.getAllMedications();
        return list;
    }

    @PostMapping("/taken")
    public MedicationTaken addMedicationTaken(@RequestParam String date, @RequestParam String med) throws ParseException { ;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date2 = formatter.parse(date);

        MedicationTaken medicationTaken = new MedicationTaken();
        medicationTaken.setDateTaken(date2);
        medicationTaken.setMedicationPlan(1);
        medicationTaken.setMedication(med);
        //medicationTaken.setId_medication_taken((long) 1);

        System.out.println("ID: " + medicationTaken.getId_medication_taken());
        System.out.println("Data: "+ medicationTaken.getDateTaken());
        System.out.println("Med: " + medicationTaken.getMedication());
        System.out.println("ID PLAN: "+medicationTaken.getMedicationPlan());

        MedicationTaken saved = medicationTakenService.saveMedicationTaken(medicationTaken);
        return  saved;

    }


//    @PostMapping("/updatemp")
//    public MedicationPlan updateMedicationPlan() throws ParseException {
//        Date start = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2019-12-10");
//        Date finish = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2020-02-12");
//        System.out.println(start);
//        System.out.println(finish);
//        MedicationPlan mp = new MedicationPlan();
//        List<MedicationPlan> mpList = new ArrayList<>();
//        mpList = medicationPlanService.getAllMedicationPlans();
//        for(MedicationPlan medPlan : mpList){
//            if(medPlan.getIdMedicationPlan() == 1){
//                medPlan.setStartPeriod(start);
//                medPlan.setFinishPeriod(finish);
//                mp = medPlan;
//            }
//        }
//        return  medicationPlanService.updateMedicationPlan(mp.getIdMedicationPlan(),mp);
//
//    }

}
