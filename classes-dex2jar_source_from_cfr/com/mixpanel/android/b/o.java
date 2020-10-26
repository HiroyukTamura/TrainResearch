/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Intent
 *  android.os.BadParcelableException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.b.k;
import com.mixpanel.android.b.n;
import com.mixpanel.android.d.g;
import java.text.NumberFormat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(value=14)
class o
implements Application.ActivityLifecycleCallbacks {
    private static Double e;
    private Handler a = new Handler(Looper.getMainLooper());
    private Runnable b;
    private boolean c = true;
    private boolean d = true;
    private final n f;
    private final k g;

    public o(n n2, k k2) {
        this.f = n2;
        this.g = k2;
        if (e == null) {
            e = System.currentTimeMillis();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(Intent var1_1) {
        block5 : {
            if (var1_1 == null) {
                return;
            }
            try {
                block6 : {
                    if (var1_1.hasExtra("mp_campaign_id") == false) return;
                    if (var1_1.hasExtra("mp_message_id") == false) return;
                    var3_3 = var1_1.getStringExtra("mp_campaign_id");
                    var4_4 = var1_1.getStringExtra("mp_message_id");
                    var2_5 = var1_1.getStringExtra("mp");
                    if (var2_5 == null) ** GOTO lbl13
                    var2_5 = new JSONObject(var2_5);
                    break block6;
lbl13: // 1 sources:
                    var2_5 = new JSONObject();
                }
                var2_5.put("campaign_id", Integer.valueOf(var3_3).intValue());
                var2_5.put("message_id", Integer.valueOf(var4_4).intValue());
                var2_5.put("message_type", (Object)"push");
                this.f.a("$app_open", (JSONObject)var2_5);
                break block5;
            }
            catch (BadParcelableException var1_2) {
                return;
            }
            catch (JSONException var2_6) {}
        }
        var1_1.removeExtra("mp_campaign_id");
        var1_1.removeExtra("mp_message_id");
        var1_1.removeExtra("mp");
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        Runnable runnable;
        this.d = true;
        if (this.b != null) {
            this.a.removeCallbacks(this.b);
        }
        activity = this.a;
        this.b = runnable = new Runnable(){

            @Override
            public void run() {
                if (o.this.c && o.this.d) {
                    o.this.c = false;
                    try {
                        double d2 = (double)System.currentTimeMillis() - e;
                        if (d2 >= (double)o.this.g.v() && d2 < (double)o.this.g.w()) {
                            Object object = NumberFormat.getNumberInstance(Locale.ENGLISH);
                            ((NumberFormat)object).setMaximumFractionDigits(1);
                            object = ((NumberFormat)object).format(((double)System.currentTimeMillis() - e) / 1000.0);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$ae_session_length", object);
                            o.this.f.a("$ae_session", jSONObject, true);
                        }
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                    o.this.f.h();
                }
            }
        };
        activity.postDelayed(runnable, 500L);
    }

    public void onActivityResumed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16 && this.g.q()) {
            this.f.c().d();
        }
        this.d = false;
        boolean bl2 = this.c;
        this.c = true;
        if (this.b != null) {
            this.a.removeCallbacks(this.b);
        }
        if (bl2 ^ true) {
            e = System.currentTimeMillis();
            this.f.i();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.a(activity.getIntent());
        if (Build.VERSION.SDK_INT >= 16 && this.g.q()) {
            this.f.c().a(activity);
        }
        new g(this.f, activity);
    }

    public void onActivityStopped(Activity activity) {
    }

}

