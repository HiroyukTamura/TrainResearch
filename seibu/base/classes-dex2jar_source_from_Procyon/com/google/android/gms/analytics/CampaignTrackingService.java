// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzaoc;
import com.google.android.gms.internal.zzctz;
import com.google.android.gms.internal.zzank;
import android.text.TextUtils;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzamj;
import android.os.IBinder;
import android.content.Intent;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import android.os.Handler;
import android.app.Service;

public class CampaignTrackingService extends Service
{
    private static Boolean zzadu;
    private Handler mHandler;
    
    public static boolean zzad(final Context context) {
        zzbo.zzu(context);
        if (CampaignTrackingService.zzadu != null) {
            return CampaignTrackingService.zzadu;
        }
        final boolean zzw = zzaos.zzw(context, "com.google.android.gms.analytics.CampaignTrackingService");
        CampaignTrackingService.zzadu = zzw;
        return zzw;
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public void onCreate() {
        super.onCreate();
        zzamj.zzaf((Context)this).zzkr().zzbo("CampaignTrackingService is starting up");
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public void onDestroy() {
        zzamj.zzaf((Context)this).zzkr().zzbo("CampaignTrackingService is shutting down");
        super.onDestroy();
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public int onStartCommand(final Intent intent, int zzlp, final int i) {
        Object o = null;
        zzamj zzaf = null;
        zzaoc zzkr = null;
        Handler mHandler = null;
    Label_0115_Outer:
        while (true) {
            while (true) {
                while (true) {
                    try {
                        o = CampaignTrackingReceiver.zzuF;
                        synchronized (o) {
                            final zzctz zzads = CampaignTrackingReceiver.zzads;
                            if (zzads != null && zzads.isHeld()) {
                                zzads.release();
                            }
                            // monitorexit(o)
                            zzaf = zzamj.zzaf((Context)this);
                            zzkr = zzaf.zzkr();
                            o = null;
                            if (intent != null) {
                                o = intent.getStringExtra("referrer");
                            }
                            if ((mHandler = this.mHandler) == null) {
                                mHandler = new Handler(this.getMainLooper());
                                this.mHandler = mHandler;
                            }
                            if (!TextUtils.isEmpty((CharSequence)o)) {
                                break;
                            }
                            if (intent == null) {
                                zzkr.zzbr("CampaignTrackingService received null intent");
                                zzaf.zzkt().zzf(new zzc(this, zzkr, mHandler, i));
                                return 2;
                            }
                        }
                    }
                    catch (SecurityException o) {
                        continue Label_0115_Outer;
                    }
                    break;
                }
                zzkr.zzbr("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
                continue;
            }
        }
        zzlp = zzank.zzlp();
        if (((String)o).length() > zzlp) {
            zzkr.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", ((String)o).length(), zzlp);
            o = ((String)o).substring(0, zzlp);
        }
        zzkr.zza("CampaignTrackingService called. startId, campaign", i, o);
        zzaf.zzkv().zza((String)o, new zzd(this, zzkr, mHandler, i));
        return 2;
    }
    
    protected final void zza(final zzaoc zzaoc, final Handler handler, final int n) {
        handler.post((Runnable)new zze(this, n, zzaoc));
    }
}
