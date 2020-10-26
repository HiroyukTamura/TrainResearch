// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.GoogleAnalytics;
import android.content.Context;

public final class zzgg
{
    private Context mContext;
    private GoogleAnalytics zzadB;
    private Tracker zzadz;
    
    public zzgg(final Context mContext) {
        this.mContext = mContext;
    }
    
    private final void zzfw(final String s) {
        synchronized (this) {
            if (this.zzadB == null) {
                (this.zzadB = GoogleAnalytics.getInstance(this.mContext)).setLogger(new zzgh());
                this.zzadz = this.zzadB.newTracker(s);
            }
        }
    }
    
    public final Tracker zzfv(final String s) {
        this.zzfw(s);
        return this.zzadz;
    }
}
