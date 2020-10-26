/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.b.n;
import com.mixpanel.android.c.f;
import com.mixpanel.android.d.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class b
implements o.h {
    private static String e = "MixpanelAPI.DynamicEventTracker";
    private final n a;
    private final Handler b;
    private final Runnable c;
    private final Map<b, c> d;

    public b(n n2, Handler handler) {
        this.a = n2;
        this.d = new HashMap<b, c>();
        this.c = new a();
        this.b = handler;
    }

    private static String a(View object) {
        String string2;
        boolean bl2 = object instanceof TextView;
        String string3 = null;
        if (bl2) {
            object = ((TextView)object).getText();
            string2 = string3;
            if (object != null) {
                return object.toString();
            }
        } else {
            string2 = string3;
            if (object instanceof ViewGroup) {
                StringBuilder stringBuilder = new StringBuilder();
                object = (ViewGroup)object;
                int n2 = object.getChildCount();
                boolean bl3 = false;
                for (int i2 = 0; i2 < n2 && stringBuilder.length() < 128; ++i2) {
                    string2 = b.a(object.getChildAt(i2));
                    boolean bl4 = bl3;
                    if (string2 != null) {
                        bl4 = bl3;
                        if (string2.length() > 0) {
                            if (bl3) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(string2);
                            bl4 = true;
                        }
                    }
                    bl3 = bl4;
                }
                if (stringBuilder.length() > 128) {
                    return stringBuilder.substring(0, 128);
                }
                string2 = string3;
                if (bl3) {
                    string2 = stringBuilder.toString();
                }
            }
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(View object, String object2, boolean bl2) {
        long l2 = System.currentTimeMillis();
        Object object3 = new JSONObject();
        try {
            object3.put("$text", (Object)b.a(object));
            object3.put("$from_binding", true);
            object3.put("time", l2 / 1000L);
        }
        catch (JSONException jSONException) {
            f.e(e, "Can't format properties from view due to JSON issue", (Throwable)jSONException);
        }
        if (!bl2) {
            this.a.a((String)object2, (JSONObject)object3);
            return;
        }
        object = new b((View)object, (String)object2);
        object3 = new c((String)object2, (JSONObject)object3, l2);
        object2 = this.d;
        synchronized (object2) {
            bl2 = this.d.isEmpty();
            this.d.put((b)object, (c)object3);
            if (bl2) {
                this.b.postDelayed(this.c, 1000L);
            }
            return;
        }
    }

    private final class a
    implements Runnable {
        private a() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            long l2 = System.currentTimeMillis();
            Map map = b.this.d;
            synchronized (map) {
                Iterator iterator = b.this.d.entrySet().iterator();
                while (iterator.hasNext()) {
                    c c2 = (c)iterator.next().getValue();
                    if (l2 - c2.a <= 1000L) continue;
                    b.this.a.a(c2.b, c2.c);
                    iterator.remove();
                }
                if (!b.this.d.isEmpty()) {
                    b.this.b.postDelayed((Runnable)this, 500L);
                }
                return;
            }
        }
    }

    private static class b {
        private final int a;

        public b(View view, String string2) {
            this.a = view.hashCode() ^ string2.hashCode();
        }

        public boolean equals(Object object) {
            boolean bl2;
            boolean bl3 = object instanceof b;
            boolean bl4 = bl2 = false;
            if (bl3) {
                bl4 = bl2;
                if (this.a == object.hashCode()) {
                    bl4 = true;
                }
            }
            return bl4;
        }

        public int hashCode() {
            return this.a;
        }
    }

    private static class c {
        public final long a;
        public final String b;
        public final JSONObject c;

        public c(String string2, JSONObject jSONObject, long l2) {
            this.b = string2;
            this.c = jSONObject;
            this.a = l2;
        }
    }

}

