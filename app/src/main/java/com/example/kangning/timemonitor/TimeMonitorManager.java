package com.example.kangning.timemonitor;

import android.util.SparseArray;

/**
 * Created by kangning on 2017/7/8.
 */

public class TimeMonitorManager {

    private SparseArray<TimeMonitor> monitors;


    private static class TimeMonitorHolder {
        private static TimeMonitorManager timeMonitor = new TimeMonitorManager();
    }

    private TimeMonitorManager(){
        monitors = new SparseArray<>();
    }

    public static TimeMonitorManager getInstance(){
        return TimeMonitorHolder.timeMonitor;
    }

    public void resetTimeMonitor(int id){
        if (monitors.get(id)!=null){
            monitors.remove(id);
        }
        getMonitor(id);
    }

    public TimeMonitor getMonitor(int id){
        if (monitors.get(id)!= null){
            return monitors.get(id);
        }
        TimeMonitor timeMonitor = new TimeMonitor(id);
        monitors.put(id, timeMonitor);
        return timeMonitor;
    }
}
