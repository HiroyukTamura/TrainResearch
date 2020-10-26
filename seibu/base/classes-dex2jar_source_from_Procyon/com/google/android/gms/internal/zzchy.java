// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.net.Uri;
import android.content.Intent;
import android.text.TextUtils;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.MainThread;
import android.annotation.TargetApi;
import android.app.Application$ActivityLifecycleCallbacks;

@TargetApi(14)
@MainThread
final class zzchy implements Application$ActivityLifecycleCallbacks
{
    private /* synthetic */ zzchl zzbtt;
    
    private zzchy(final zzchl zzbtt) {
        this.zzbtt = zzbtt;
    }
    
    public final void onActivityCreated(final Activity activity, Bundle bundle) {
    Label_0183_Outer:
        while (true) {
        Label_0183:
            while (true) {
            Label_0338:
                while (true) {
                    Label_0331: {
                        Label_0284: {
                            try {
                                this.zzbtt.zzwF().zzyD().log("onActivityCreated");
                                final Intent intent = activity.getIntent();
                                if (intent == null) {
                                    break;
                                }
                                final Uri data = intent.getData();
                                if (data == null || !data.isHierarchical()) {
                                    break;
                                }
                                if (bundle == null) {
                                    final Bundle zzq = this.zzbtt.zzwB().zzq(data);
                                    this.zzbtt.zzwB();
                                    if (!zzcjl.zzl(intent)) {
                                        break Label_0331;
                                    }
                                    final String s = "gs";
                                    if (zzq != null) {
                                        this.zzbtt.zzd(s, "_cmp", zzq);
                                    }
                                }
                                final String queryParameter = data.getQueryParameter("referrer");
                                if (TextUtils.isEmpty((CharSequence)queryParameter)) {
                                    return;
                                }
                                if (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) {
                                    break Label_0338;
                                }
                                break Label_0284;
                                while (true) {
                                    this.zzbtt.zzwF().zzyC().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                                    return;
                                    continue Label_0183_Outer;
                                }
                            }
                            // iftrue(Label_0289:, n != 0)
                            catch (Throwable t) {
                                this.zzbtt.zzwF().zzyx().zzj("Throwable caught in onActivityCreated", t);
                            }
                            break;
                        }
                        final int n = 0;
                        continue Label_0183;
                    }
                    final String s = "auto";
                    continue Label_0183_Outer;
                }
                final int n = 1;
                continue Label_0183;
            }
        }
        while (true) {
            final zzchz zzwx = this.zzbtt.zzwx();
            if (bundle != null) {
                bundle = bundle.getBundle("com.google.firebase.analytics.screen_service");
                if (bundle != null) {
                    final zzcic zzq2 = zzwx.zzq(activity);
                    zzq2.zzbol = bundle.getLong("id");
                    zzq2.zzboj = bundle.getString("name");
                    zzq2.zzbok = bundle.getString("referrer_name");
                    return;
                }
            }
            return;
            final String queryParameter;
            Label_0289: {
                this.zzbtt.zzwF().zzyC().zzj("Activity created with referrer", queryParameter);
            }
            if (!TextUtils.isEmpty((CharSequence)queryParameter)) {
                this.zzbtt.zzb("auto", "_ldl", queryParameter);
            }
            continue;
        }
    }
    
    public final void onActivityDestroyed(final Activity activity) {
        this.zzbtt.zzwx().onActivityDestroyed(activity);
    }
    
    @MainThread
    public final void onActivityPaused(final Activity activity) {
        this.zzbtt.zzwx().onActivityPaused(activity);
        final zzcja zzwD = this.zzbtt.zzwD();
        zzwD.zzwE().zzj(new zzcje(zzwD, zzwD.zzkq().elapsedRealtime()));
    }
    
    @MainThread
    public final void onActivityResumed(final Activity activity) {
        this.zzbtt.zzwx().onActivityResumed(activity);
        final zzcja zzwD = this.zzbtt.zzwD();
        zzwD.zzwE().zzj(new zzcjd(zzwD, zzwD.zzkq().elapsedRealtime()));
    }
    
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        this.zzbtt.zzwx().onActivitySaveInstanceState(activity, bundle);
    }
    
    public final void onActivityStarted(final Activity activity) {
    }
    
    public final void onActivityStopped(final Activity activity) {
    }
}
