// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver
{
    @Override
    protected final Class<? extends CampaignTrackingService> zzjm() {
        return InstallReferrerService.class;
    }
    
    @Override
    protected final void zzu(final Context context, final String s) {
        zzcx.zzfn(s);
        zzcx.zzK(context, s);
    }
}
