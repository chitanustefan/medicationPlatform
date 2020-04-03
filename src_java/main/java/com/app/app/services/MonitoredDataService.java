package com.app.app.services;

import com.app.app.entities.MonitoredData2;
import com.app.app.repository.MonitoredData2Repository;
import com.app.app.services.interfaces.IMonitoredData2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoredDataService implements IMonitoredData2Service {

    @Autowired
    MonitoredData2Repository monitoredDataRepository;

    @Override
    public List<MonitoredData2> getAllMonitoredData() {
        List<MonitoredData2> list = monitoredDataRepository.findAll();
        return list;
    }

    @Override
    public MonitoredData2 saveMonitoredData(MonitoredData2 monitoredData) {
        MonitoredData2 monitoredData1 = this.monitoredDataRepository.save(monitoredData);
        return monitoredData1;
    }

    @Override
    public MonitoredData2 updateMonitoredData(Long id, MonitoredData2 monitoredData) {
        MonitoredData2 optionalUser = monitoredDataRepository.findById(id).get();
        MonitoredData2 result = monitoredDataRepository.save(optionalUser);
        return result;
    }

    @Override
    public void deleteMonitoredData(Long id) {
        monitoredDataRepository.deleteById(id);

    }
}
