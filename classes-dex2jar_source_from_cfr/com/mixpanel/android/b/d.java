/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.mixpanel.android.b;

import android.os.Handler;
import com.mixpanel.android.b.n;
import com.mixpanel.android.c.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

class d {
    private final n a;
    private String b;
    private int c;

    public d(n n2) {
        this.a = n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a() {
        // MONITORENTER : this
        try {
            Object object = Class.forName("com.urbanairship.UAirship").getMethod("shared", null).invoke(null, new Object[0]);
            object = object.getClass().getMethod("getPushManager", null).invoke(object, new Object[0]);
            object = (String)object.getClass().getMethod("getChannelId", null).invoke(object, new Object[0]);
            if (object != null && !((String)object).isEmpty()) {
                this.c = 0;
                if (this.b != null && this.b.equals(object)) return;
                {
                    this.a.c().a("$android_urban_airship_channel_id", object);
                    this.b = object;
                    return;
                }
            } else {
                ++this.c;
                if (this.c > 3) return;
                {
                    new Handler().postDelayed(new Runnable(){

                        @Override
                        public void run() {
                            d.this.a();
                        }
                    }, 2000L);
                    return;
                }
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            String string2;
            void var1_3;
            block11 : {
                string2 = "method invocation failed";
                break block11;
                catch (ClassNotFoundException classNotFoundException) {
                    f.d("MixpanelAPI.CnctInts", "Urban Airship SDK not found but Urban Airship is integrated on Mixpanel", classNotFoundException);
                }
                // MONITOREXIT : this
                return;
                catch (InvocationTargetException invocationTargetException) {
                    string2 = "method invocation failed";
                    break block11;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    string2 = "Urban Airship SDK class exists but methods do not";
                }
            }
            f.e("MixpanelAPI.CnctInts", string2, (Throwable)var1_3);
            return;
        }
    }

    public void a(Set<String> set) {
        synchronized (this) {
            if (set.contains("urbanairship")) {
                this.a();
            }
            return;
        }
    }

}

