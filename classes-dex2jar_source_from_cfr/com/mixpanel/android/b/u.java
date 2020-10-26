/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import com.mixpanel.android.b.c;
import com.mixpanel.android.c.f;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class u {
    private long a;
    private long b;
    private long c;
    private String d;
    private Random e;

    u() {
        this.a();
        this.e = new Random();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject a(boolean bl2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$mp_event_id", (Object)Long.toHexString(this.e.nextLong()));
            jSONObject.put("$mp_session_id", (Object)this.d);
            long l2 = bl2 ? this.a : this.b;
            jSONObject.put("$mp_session_seq_id", l2);
            jSONObject.put("$mp_session_start_sec", this.c);
            if (bl2) {
                ++this.a;
                return jSONObject;
            }
            ++this.b;
            return jSONObject;
        }
        catch (JSONException jSONException) {
            f.e(c.a, "Cannot create session metadata JSON object", (Throwable)jSONException);
            return jSONObject;
        }
    }

    protected void a() {
        this.a = 0L;
        this.b = 0L;
        this.d = Long.toHexString(new Random().nextLong());
        this.c = System.currentTimeMillis() / 1000L;
    }

    public JSONObject b() {
        return this.a(true);
    }

    public JSONObject c() {
        return this.a(false);
    }
}

