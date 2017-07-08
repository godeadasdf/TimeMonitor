package com.example.kangning.timemonitor;

import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kangning on 2017/7/8.
 */

public class TimeMonitor {

    public static final int APPLICATION_START_RECORD = 1;
    // to add your custom monitor id here

    private static final String TAG = "TimeMonitor";
    private int monitorId;
    private ArrayMap<String, Long> tagsTime = new ArrayMap<>();
    private List<String> tagsList = new ArrayList<>();
    private long startTime;

    public TimeMonitor(int monitorId) {
        this.monitorId = monitorId;
        startMonitor();
    }

    public void startMonitor() {
        if (tagsTime.size() > 0) {
            tagsTime.clear();
        }
        startTime = System.currentTimeMillis();
        Log.d(TAG, "monitor " + monitorId + " init" + startTime);
    }


    public void recordTagMonitor(String tag) {
        if (tagsTime.get(tag) != null) {
            tagsTime.remove(tag);
            tagsList.remove(tag);
        }
        tagsTime.put(tag, System.currentTimeMillis() - startTime);
        tagsList.add(tag);
    }

    public void endRecord(String tag, boolean writeToFile) {
        recordTagMonitor(tag);
        endWriteLog(writeToFile);
    }


    private void endWriteLog(boolean writeTofile) {
        if (writeTofile) {
            //record your logs into files
        }
        showLogs();
    }

    private void showLogs() {
        if (tagsTime.size() == 0) {
            Log.d(TAG, "no Tag to show");
            return;
        }
        for (String tag : tagsList) {
            Log.d(TAG, tag + ":" + tagsTime.get(tag));
        }
    }

}
