// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zzeu implements zzex
{
    zzeu(final zzet zzet) {
    }
    
    @Override
    public final ScheduledExecutorService zzBH() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
