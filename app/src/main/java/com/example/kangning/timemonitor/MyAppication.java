package com.example.kangning.timemonitor;

import android.app.Application;
import android.content.Context;

/**
 * Created by kangning on 2017/7/8.
 */

public class MyAppication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        TimeMonitorManager.getInstance().resetTimeMonitor(TimeMonitor.APPLICATION_START_RECORD);
    }

    @Override
    public void onCreate() {
        TimeMonitorManager.getInstance().getMonitor(TimeMonitor.APPLICATION_START_RECORD).recordTagMonitor("Application onCreate");
        super.onCreate();
    }
}
