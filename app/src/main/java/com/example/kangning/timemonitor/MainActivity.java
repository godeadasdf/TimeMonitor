package com.example.kangning.timemonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeMonitorManager.getInstance().getMonitor(TimeMonitor.APPLICATION_START_RECORD).recordTagMonitor("MainActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        TimeMonitorManager.getInstance().getMonitor(TimeMonitor.APPLICATION_START_RECORD).endRecord("MainActivity onStart()",false);
    }
}
