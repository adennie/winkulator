package com.affectiva.android.affdex.sdk.samples.wink;

import android.app.Application;
import android.content.Intent;

/**
 * Manages the lifetime of the DetectorService so that it is running whenever there is a
 * started Activity, but is shutdown when there are no started Activities.
 */
public class WinkApplication extends Application {
    public static final String LOG_TAG = "Wink";
    private int startedActivityCount;

    public void onActivityStarted() {
        // when the number of started activities transitions from 0 to 1, start the service
        if (++startedActivityCount == 1) {
            startService(new Intent(this, DetectorService.class));
        }
    }

    public void onActivityStopped() {
        // when the number of started activities transitions from 1 to 0, stop the service
        if (--startedActivityCount == 0) {
            stopService(new Intent(this, DetectorService.class));
        }
    }
}
