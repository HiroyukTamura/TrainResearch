// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.android;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.content.Context;

public final class InactivityTimer
{
    private static final long INACTIVITY_DELAY_MS = 300000L;
    private static final String TAG;
    private Runnable callback;
    private final Context context;
    private Handler handler;
    private boolean onBattery;
    private final BroadcastReceiver powerStatusReceiver;
    private boolean registered;
    
    static {
        TAG = InactivityTimer.class.getSimpleName();
    }
    
    public InactivityTimer(final Context context, final Runnable callback) {
        this.registered = false;
        this.context = context;
        this.callback = callback;
        this.powerStatusReceiver = new PowerStatusReceiver();
        this.handler = new Handler();
    }
    
    private void cancelCallback() {
        this.handler.removeCallbacksAndMessages((Object)null);
    }
    
    private void onBattery(final boolean onBattery) {
        this.onBattery = onBattery;
        if (this.registered) {
            this.activity();
        }
    }
    
    private void registerReceiver() {
        if (!this.registered) {
            this.context.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.registered = true;
        }
    }
    
    private void unregisterReceiver() {
        if (this.registered) {
            this.context.unregisterReceiver(this.powerStatusReceiver);
            this.registered = false;
        }
    }
    
    public void activity() {
        this.cancelCallback();
        if (this.onBattery) {
            this.handler.postDelayed(this.callback, 300000L);
        }
    }
    
    public void cancel() {
        this.cancelCallback();
        this.unregisterReceiver();
    }
    
    public void start() {
        this.registerReceiver();
        this.activity();
    }
    
    private final class PowerStatusReceiver extends BroadcastReceiver
    {
        public void onReceive(final Context context, final Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                InactivityTimer.this.handler.post((Runnable)new Runnable() {
                    final /* synthetic */ boolean val$onBatteryNow = intent.getIntExtra("plugged", -1) <= 0;
                    
                    @Override
                    public void run() {
                        InactivityTimer.this.onBattery(this.val$onBatteryNow);
                    }
                });
            }
        }
    }
}
