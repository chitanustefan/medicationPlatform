package com.app.app.controller;

import com.app.app.entities.MonitoredData2;
import com.app.app.entities.Recommendation;
import com.app.app.services.MonitoredDataService;
import com.app.app.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MonitoredDataController {


    @Autowired
    MonitoredDataService monitoredDataService = new MonitoredDataService();

    @Autowired
    RecommendationService recommendationService = new RecommendationService();

    @PostMapping("{id}/{date}/doctor/recomandation")
    public Recommendation postRecomandation(@RequestBody String reco, @PathVariable("id") int id, @PathVariable("date") String date) throws ParseException {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date dateReco = new Date(System.currentTimeMillis());
        System.out.println("Recomandation: "+reco);
        Recommendation r = new Recommendation();
        r.setDesc(reco);
        r.setId_patient(id);
        r.setDateReco(dateReco);
        Recommendation rNou = recommendationService.saveRecommendation(r);
        return rNou;

    }

    @GetMapping("{id}/doctor/activity-list")
    public List<MonitoredData2> getAllActivitysById(@PathVariable("id") int id){
        List<MonitoredData2> list = monitoredDataService.getAllMonitoredData();
        List<MonitoredData2> finalList = new ArrayList<>();
        for (MonitoredData2 activity: list){
            if (activity.getPatient().getId_patient() == id){
                finalList.add(activity);
            }
        }
        return finalList;
    }

    @GetMapping("{id}/{date}/doctor/activity-time")
    public List<Long> getAllDurationById(@PathVariable("id") int id, @PathVariable("date") String date){
        SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(date);
        List<MonitoredData2> list = monitoredDataService.getAllMonitoredData();
        List<Long> durations = new ArrayList<>();
        long toiletingTime = 0;
        long showeringTime = 0;
        long breakfastTime = 0;
        long groomingTime = 0;
        long spareTime = 0;
        long leavingTime = 0;
        long lunchTime = 0;
        long snackTime = 0;
        for (MonitoredData2 activity: list){
            if (activity.getPatient().getId_patient() == id){
                String dateAct = formatter.format(activity.getStartTime().toLocalDate());
                //System.out.println(dateAct);
                if (dateAct.equals(date)){
                    if(activity.getAct().equals("Toileting")){
                        //System.out.println(activity.getDuration());
                        toiletingTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Showering")){
                        showeringTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Breakfast")){
                        breakfastTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Grooming")){
                        groomingTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Spare_Time/TV")){
                        spareTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Leaving")){
                        leavingTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Lunch")){
                        lunchTime += activity.getDuration().toMinutes();
                    }
                    if(activity.getAct().equals("Snack")){
                        snackTime += activity.getDuration().toMinutes();
                    }
                }
                }
            }
        durations.add(toiletingTime);
        durations.add(showeringTime);
        durations.add(breakfastTime);
        durations.add(groomingTime);
        durations.add(spareTime);
        durations.add(leavingTime);
        durations.add(lunchTime);
        durations.add(snackTime);
        return durations;
    }

}
