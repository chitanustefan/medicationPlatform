package com.app.app.services.interfaces;

import com.app.app.entities.MonitoredData2;

import java.util.List;

public interface IMonitoredData2Service {

    List<MonitoredData2> getAllMonitoredData();
    MonitoredData2 saveMonitoredData(MonitoredData2 monitoredData);
    MonitoredData2 updateMonitoredData(Long id, MonitoredData2 monitoredData);
    void deleteMonitoredData(Long id);

}
