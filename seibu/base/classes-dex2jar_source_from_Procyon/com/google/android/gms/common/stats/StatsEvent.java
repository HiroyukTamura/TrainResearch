// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class StatsEvent extends zza implements ReflectedParcelable
{
    public abstract int getEventType();
    
    public abstract long getTimeMillis();
    
    @Override
    public String toString() {
        final long timeMillis = this.getTimeMillis();
        final String value = String.valueOf("\t");
        final int eventType = this.getEventType();
        final String value2 = String.valueOf("\t");
        final long zzrV = this.zzrV();
        final String value3 = String.valueOf(this.zzrW());
        return new StringBuilder(String.valueOf(value).length() + 51 + String.valueOf(value2).length() + String.valueOf(value3).length()).append(timeMillis).append(value).append(eventType).append(value2).append(zzrV).append(value3).toString();
    }
    
    public abstract long zzrV();
    
    public abstract String zzrW();
}
