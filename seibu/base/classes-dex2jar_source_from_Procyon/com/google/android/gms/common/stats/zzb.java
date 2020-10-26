// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import android.content.ComponentName;

public final class zzb
{
    private static int LOG_LEVEL_OFF;
    public static final ComponentName zzaJf;
    private static int zzaJg;
    private static int zzaJh;
    private static int zzaJi;
    private static int zzaJj;
    private static int zzaJk;
    private static int zzaJl;
    private static int zzaJm;
    
    static {
        zzaJf = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
        zzb.LOG_LEVEL_OFF = 0;
        zzb.zzaJg = 1;
        zzb.zzaJh = 2;
        zzb.zzaJi = 4;
        zzb.zzaJj = 8;
        zzb.zzaJk = 16;
        zzb.zzaJl = 32;
        zzb.zzaJm = 1;
    }
}
