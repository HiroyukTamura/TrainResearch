/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.os.Process;
import com.mixpanel.android.b.n;
import org.json.JSONException;
import org.json.JSONObject;

public class g
implements Thread.UncaughtExceptionHandler {
    private static g a;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    public g() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        if (a != null) {
            return;
        }
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            return;
        }
    }

    private void b() {
        try {
            Thread.sleep(400L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Process.killProcess((int)Process.myPid());
        System.exit(10);
    }

    @Override
    public void uncaughtException(Thread thread, final Throwable throwable) {
        n.a(new n.a(){

            @Override
            public void a(n n2) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ae_crashed_reason", (Object)throwable.toString());
                    n2.a("$ae_crashed", jSONObject, true);
                    return;
                }
                catch (JSONException jSONException) {
                    return;
                }
            }
        });
        n.a(new n.a(){

            @Override
            public void a(n n2) {
                n2.n();
            }
        });
        if (this.b != null) {
            this.b.uncaughtException(thread, throwable);
            return;
        }
        this.b();
    }

}

