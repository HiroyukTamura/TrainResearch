// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote.beacon;

import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import org.altbeacon.beacon.logging.LogManager;
import android.os.Build$VERSION;
import android.content.Context;
import org.altbeacon.beacon.BeaconManager;
import android.support.annotation.NonNull;
import android.annotation.TargetApi;
import android.app.Application$ActivityLifecycleCallbacks;

@TargetApi(18)
public class CustomPowerSaver implements Application$ActivityLifecycleCallbacks
{
    @NonNull
    private static final String TAG = "CustomPowerSaver";
    private int activeActivityCount;
    @NonNull
    private final BeaconManager beaconManager;
    
    public CustomPowerSaver(final Context context) {
        this.activeActivityCount = 0;
        if (Build$VERSION.SDK_INT < 18) {
            LogManager.w("CustomPowerSaver", "CustomPowerSaver requires API 18 or higher.", new Object[0]);
        }
        this.beaconManager = BeaconManager.getInstanceForApplication(context);
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
    }
    
    @Deprecated
    public CustomPowerSaver(final Context context, final boolean b) {
        this(context);
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityDestroyed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
        --this.activeActivityCount;
        LogManager.d("CustomPowerSaver", "activity paused: %s active activities: %s", new Object[] { activity, this.activeActivityCount });
        if (this.activeActivityCount < 1) {
            LogManager.d("CustomPowerSaver", "setting background mode", new Object[0]);
        }
    }
    
    public void onActivityResumed(final Activity activity) {
        ++this.activeActivityCount;
        if (this.activeActivityCount < 1) {
            LogManager.d("CustomPowerSaver", "reset active activity count on resume.  It was %s", new Object[] { this.activeActivityCount });
            this.activeActivityCount = 1;
        }
        this.beaconManager.setBackgroundMode(false);
        LogManager.d("CustomPowerSaver", "activity resumed: %s active activities: %s", new Object[] { activity, this.activeActivityCount });
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
    }
    
    public void onActivityStopped(final Activity activity) {
    }
}
