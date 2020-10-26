// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzaoc;
import android.text.TextUtils;
import com.google.android.gms.internal.zzamj;
import android.content.Intent;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import com.google.android.gms.internal.zzctz;
import android.content.BroadcastReceiver;

public class CampaignTrackingReceiver extends BroadcastReceiver
{
    static zzctz zzads;
    private static Boolean zzadt;
    static Object zzuF;
    
    static {
        CampaignTrackingReceiver.zzuF = new Object();
    }
    
    public static boolean zzac(final Context context) {
        zzbo.zzu(context);
        if (CampaignTrackingReceiver.zzadt != null) {
            return CampaignTrackingReceiver.zzadt;
        }
        final boolean zza = zzaos.zza(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        CampaignTrackingReceiver.zzadt = zza;
        return zza;
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public void onReceive(final Context context, final Intent intent) {
        final zzaoc zzkr = zzamj.zzaf(context).zzkr();
        if (intent == null) {
            zzkr.zzbr("CampaignTrackingReceiver received null intent");
            return;
        }
        final String stringExtra = intent.getStringExtra("referrer");
        final String action = intent.getAction();
        zzkr.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty((CharSequence)stringExtra)) {
            zzkr.zzbr("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        final boolean zzad = CampaignTrackingService.zzad(context);
        if (!zzad) {
            zzkr.zzbr("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        this.zzu(context, stringExtra);
        final Class<? extends CampaignTrackingService> zzjm = this.zzjm();
        zzbo.zzu(zzjm);
        final Intent intent2 = new Intent(context, (Class)zzjm);
        intent2.putExtra("referrer", stringExtra);
        synchronized (CampaignTrackingReceiver.zzuF) {
            context.startService(intent2);
            if (!zzad) {
                return;
            }
        }
        while (true) {
            try {
                if (CampaignTrackingReceiver.zzads == null) {
                    final Context context2;
                    (CampaignTrackingReceiver.zzads = new zzctz(context2, 1, "Analytics campaign WakeLock")).setReferenceCounted(false);
                }
                CampaignTrackingReceiver.zzads.acquire(1000L);
            }
            // monitorexit(intent)
            catch (SecurityException ex) {
                zzkr.zzbr("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                continue;
            }
            break;
        }
    }
    
    protected Class<? extends CampaignTrackingService> zzjm() {
        return CampaignTrackingService.class;
    }
    
    protected void zzu(final Context context, final String s) {
    }
}
