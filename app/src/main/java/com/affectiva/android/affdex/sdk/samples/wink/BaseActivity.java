package com.affectiva.android.affdex.sdk.samples.wink;

import android.support.v7.app.AppCompatActivity;

/**
 * A base activity for all activities in the app.  It relays start and stop events to
 * WinkApplication, so that it can keep count of the number of started Activities in the app.
 */
class BaseActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        ((WinkApplication)getApplication()).onActivityStarted();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ((WinkApplication)getApplication()).onActivityStopped();
    }
}
