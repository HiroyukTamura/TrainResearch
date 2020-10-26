/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.util.DisplayMetrics
 *  android.util.JsonWriter
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import com.mixpanel.android.b.n;
import com.mixpanel.android.b.p;
import com.mixpanel.android.b.s;
import com.mixpanel.android.b.t;
import com.mixpanel.android.b.w;
import com.mixpanel.android.b.z;
import com.mixpanel.android.c.g;
import com.mixpanel.android.d.c;
import com.mixpanel.android.d.e;
import com.mixpanel.android.d.f;
import com.mixpanel.android.d.j;
import com.mixpanel.android.d.k;
import com.mixpanel.android.d.l;
import com.mixpanel.android.d.n;
import com.mixpanel.android.d.o;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(value=16)
public class m
implements j,
l,
o.i {
    private final com.mixpanel.android.b.k a;
    private final Context b;
    private final com.mixpanel.android.b.n c;
    private final com.mixpanel.android.d.b d;
    private final com.mixpanel.android.d.d e;
    private final z f;
    private final Map<String, String> g;
    private final f h;
    private final float i;
    private final Set<p> j;

    public m(Context context, String string2, com.mixpanel.android.b.n n2, z z2) {
        this.a = com.mixpanel.android.b.k.a(context);
        this.b = context;
        this.e = new com.mixpanel.android.d.d();
        this.f = z2;
        this.g = n2.d();
        this.i = Resources.getSystem().getDisplayMetrics().scaledDensity;
        this.j = Collections.newSetFromMap(new ConcurrentHashMap());
        z2 = new HandlerThread(m.class.getCanonicalName());
        z2.setPriority(10);
        z2.start();
        this.h = new f(context, string2, z2.getLooper(), this);
        this.d = new com.mixpanel.android.d.b(n2, this.h);
        this.c = n2;
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new c());
        this.f.a(new z.a(){});
    }

    static /* synthetic */ float f(m m2) {
        return m2.i;
    }

    static /* synthetic */ Map g(m m2) {
        return m2.g;
    }

    @Override
    public void a() {
        this.h.a();
        this.b();
    }

    @Override
    public void a(o.e e2) {
        Message message = this.h.obtainMessage();
        message.what = 12;
        message.obj = e2;
        this.h.sendMessage(message);
    }

    @Override
    public void a(String string2) {
        Message message = this.h.obtainMessage();
        message.what = 7;
        message.obj = string2;
        this.h.sendMessage(message);
    }

    @Override
    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message message = this.h.obtainMessage(13);
            message.obj = jSONArray;
            this.h.sendMessage(message);
        }
    }

    @Override
    public void b() {
        this.h.sendMessage(this.h.obtainMessage(0));
    }

    @Override
    public void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message message = this.h.obtainMessage(5);
            message.obj = jSONArray;
            this.h.sendMessage(message);
        }
    }

    @Override
    public void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message message = this.h.obtainMessage(9);
            message.obj = jSONArray;
            this.h.sendMessage(message);
        }
    }

    private class a
    implements e.a {
        private a() {
        }

        @Override
        public void a() {
            Message message = m.this.h.obtainMessage(4);
            m.this.h.sendMessage(message);
        }

        @Override
        public void a(JSONObject jSONObject) {
            Message message = m.this.h.obtainMessage(2);
            message.obj = jSONObject;
            m.this.h.sendMessage(message);
        }

        @Override
        public void b() {
            Message message = m.this.h.obtainMessage(8);
            m.this.h.sendMessage(message);
        }

        @Override
        public void b(JSONObject jSONObject) {
            Message message = m.this.h.obtainMessage(3);
            message.obj = jSONObject;
            m.this.h.sendMessage(message);
        }

        @Override
        public void c(JSONObject jSONObject) {
            Message message = m.this.h.obtainMessage(10);
            message.obj = jSONObject;
            m.this.h.sendMessage(message);
        }

        @Override
        public void d(JSONObject jSONObject) {
            Message message = m.this.h.obtainMessage(6);
            message.obj = jSONObject;
            m.this.h.sendMessage(message);
        }

        @Override
        public void e(JSONObject jSONObject) {
            Message message = m.this.h.obtainMessage(11);
            message.obj = jSONObject;
            m.this.h.sendMessage(message);
        }
    }

    private class b
    implements Runnable {
        private volatile boolean b = true;

        public void a() {
            this.b = false;
            m.this.h.post((Runnable)this);
        }

        public void b() {
            this.b = true;
            m.this.h.removeCallbacks((Runnable)this);
        }

        @Override
        public void run() {
            if (!this.b) {
                Message message = m.this.h.obtainMessage(1);
                m.this.h.sendMessage(message);
            }
            m.this.h.postDelayed((Runnable)this, 30000L);
        }
    }

    private class c
    implements Application.ActivityLifecycleCallbacks,
    f.a {
        private final com.mixpanel.android.d.f b = new com.mixpanel.android.d.f(this);
        private final b c;

        public c() {
            this.c = new b();
        }

        private void a(Activity activity) {
            if (this.b() && !m.this.a.f()) {
                this.c.a();
                return;
            }
            if (!m.this.a.e()) {
                activity = (SensorManager)activity.getSystemService("sensor");
                Sensor sensor = activity.getDefaultSensor(1);
                activity.registerListener((SensorEventListener)this.b, sensor, 3);
            }
        }

        private void b(Activity activity) {
            if (this.b() && !m.this.a.f()) {
                this.c.b();
                return;
            }
            if (!m.this.a.e()) {
                ((SensorManager)activity.getSystemService("sensor")).unregisterListener((SensorEventListener)this.b);
            }
        }

        private boolean b() {
            if (!Build.HARDWARE.toLowerCase().equals("goldfish") && !Build.HARDWARE.toLowerCase().equals("ranchu")) {
                return false;
            }
            if (!(Build.BRAND.toLowerCase().startsWith("generic") || Build.BRAND.toLowerCase().equals("android") || Build.BRAND.toLowerCase().equals("google"))) {
                return false;
            }
            if (!Build.DEVICE.toLowerCase().startsWith("generic")) {
                return false;
            }
            if (!Build.PRODUCT.toLowerCase().contains("sdk")) {
                return false;
            }
            return Build.MODEL.toLowerCase(Locale.US).contains("sdk");
        }

        @Override
        public void a() {
            m.this.c.b("$ab_gesture3");
            Message message = m.this.h.obtainMessage(1);
            m.this.h.sendMessage(message);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            m.this.e.b(activity);
            this.b(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.a(activity);
            m.this.e.a(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    private static class d {
        public final String a;
        public final String b;
        public final JSONObject c;
        public final g<Integer, Integer> d;

        public d(String string2, String string3, JSONObject jSONObject, g<Integer, Integer> g2) {
            this.a = string2;
            this.b = string3;
            this.c = jSONObject;
            this.d = g2;
        }

        public boolean equals(Object object) {
            boolean bl2;
            boolean bl3 = object instanceof d;
            boolean bl4 = bl2 = false;
            if (bl3) {
                bl4 = bl2;
                if (object.hashCode() == this.hashCode()) {
                    bl4 = true;
                }
            }
            return bl4;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private static class e {
        public final String a;
        public final JSONObject b;
        public final g<Integer, Integer> c;

        public e(String string2, JSONObject jSONObject, g<Integer, Integer> g2) {
            this.a = string2;
            this.b = jSONObject;
            this.c = g2;
        }

        public boolean equals(Object object) {
            boolean bl2;
            boolean bl3 = object instanceof e;
            boolean bl4 = bl2 = false;
            if (bl3) {
                bl4 = bl2;
                if (object.hashCode() == this.hashCode()) {
                    bl4 = true;
                }
            }
            return bl4;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private class f
    extends Handler {
        private com.mixpanel.android.d.e b;
        private n c;
        private final String d;
        private final Lock e;
        private final com.mixpanel.android.d.c f;
        private final com.mixpanel.android.c.d g;
        private final Map<String, g<String, JSONObject>> h;
        private final Map<String, g<String, Object>> i;
        private final List<String> j;
        private final Map<String, g<String, JSONObject>> k;
        private final Set<d> l;
        private final Set<e> m;
        private final Set<g<Integer, Integer>> n;
        private final Set<g<String, JSONObject>> o;
        private final Set<g<String, JSONObject>> p;
        private final Set<g<Integer, Integer>> q;

        public f(Context context, String string2, Looper looper, o.i i2) {
            super(looper);
            this.d = string2;
            this.c = null;
            string2 = ((m)m.this).a.B();
            m.this = string2;
            if (string2 == null) {
                m.this = context.getPackageName();
            }
            m.this = new t.a((String)m.this, context);
            this.g = new com.mixpanel.android.c.d(context, "ViewCrawler");
            this.f = new com.mixpanel.android.d.c(context, (s)m.this, this.g, i2);
            this.p = new HashSet<g<String, JSONObject>>();
            this.h = new HashMap<String, g<String, JSONObject>>();
            this.i = new HashMap<String, g<String, Object>>();
            this.j = new ArrayList<String>();
            this.k = new HashMap<String, g<String, JSONObject>>();
            this.l = new HashSet<d>();
            this.m = new HashSet<e>();
            this.n = new HashSet<g<Integer, Integer>>();
            this.o = new HashSet<g<String, JSONObject>>();
            this.q = new HashSet<g<Integer, Integer>>();
            this.e = new ReentrantLock();
            this.e.lock();
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void a(o.e e2) {
            Throwable throwable2222;
            if (this.b == null) return;
            if (!this.b.a()) return;
            if (!this.b.b()) {
                return;
            }
            JsonWriter jsonWriter = new JsonWriter((Writer)new OutputStreamWriter(this.b.c()));
            jsonWriter.beginObject();
            jsonWriter.name("type").value("layout_error");
            jsonWriter.name("exception_type").value(e2.a());
            jsonWriter.name("cid").value(e2.b());
            jsonWriter.endObject();
            jsonWriter.close();
            return;
            {
                catch (IOException iOException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
                    return;
                }
                catch (Throwable throwable2222) {
                }
                catch (IOException iOException) {}
                {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", iOException);
                }
                jsonWriter.close();
                return;
            }
            try {
                jsonWriter.close();
                throw throwable2222;
            }
            catch (IOException iOException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
            }
            throw throwable2222;
        }

        private void a(String string2) {
            if (string2 != null) {
                int n2;
                try {
                    string2 = new JSONArray(string2);
                    this.o.clear();
                    n2 = 0;
                }
                catch (JSONException jSONException) {
                    com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", (Throwable)jSONException);
                    SharedPreferences.Editor editor = this.g().edit();
                    editor.remove("mixpanel.viewcrawler.bindings");
                    editor.apply();
                }
                do {
                    if (n2 < string2.length()) {
                        JSONObject jSONObject = string2.getJSONObject(n2);
                        String string3 = com.mixpanel.android.c.e.a(jSONObject, "target_activity");
                        this.o.add(new g<String, JSONObject>(string3, jSONObject));
                        ++n2;
                        continue;
                    }
                    break;
                } while (true);
            }
        }

        private void a(String string2, boolean bl2) {
            if (string2 != null) {
                string2 = new JSONArray(string2);
                int n2 = string2.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    JSONObject jSONObject = string2.getJSONObject(i2);
                    int n3 = jSONObject.getInt("id");
                    g<Integer, Integer> g2 = new g<Integer, Integer>(jSONObject.getInt("experiment_id"), n3);
                    Object object = jSONObject.getJSONArray("actions");
                    int n4 = object.length();
                    for (n3 = 0; n3 < n4; ++n3) {
                        Object object2 = object.getJSONObject(n3);
                        String string3 = com.mixpanel.android.c.e.a(object2, "target_activity");
                        object2 = new d(object2.getString("name"), string3, (JSONObject)object2, g2);
                        this.l.add((d)object2);
                        continue;
                    }
                    jSONObject = jSONObject.getJSONArray("tweaks");
                    int n5 = jSONObject.length();
                    for (n3 = 0; n3 < n5; ++n3) {
                        object = jSONObject.getJSONObject(n3);
                        object = new e(object.getString("name"), (JSONObject)object, g2);
                        this.m.add((e)object);
                        continue;
                    }
                    if (!bl2) {
                        this.q.add(g2);
                    }
                    if (n5 != 0 || n4 != 0) continue;
                    try {
                        this.n.add(g2);
                    }
                    catch (JSONException jSONException) {
                        com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", (Throwable)jSONException);
                        SharedPreferences.Editor editor = this.g().edit();
                        editor.remove("mixpanel.viewcrawler.changes");
                        editor.apply();
                        break;
                    }
                    continue;
                }
            }
        }

        private void a(Set<g<Integer, Integer>> object) {
            if (object != null && object.size() > 0) {
                final JSONObject jSONObject = new JSONObject();
                try {
                    object = object.iterator();
                    while (object.hasNext()) {
                        g g2 = (g)((Object)object.next());
                        int n2 = (Integer)g2.first;
                        int n3 = (Integer)g2.second;
                        g2 = new JSONObject();
                        g2.put("$experiment_id", n2);
                        g2.put("$variant_id", n3);
                        jSONObject.put(Integer.toString(n2), n3);
                        m.this.c.c().a("$experiments", jSONObject);
                        m.this.c.a(new w(){

                            @Override
                            public JSONObject a(JSONObject jSONObject2) {
                                try {
                                    jSONObject2.put("$experiments", (Object)jSONObject);
                                    return jSONObject2;
                                }
                                catch (JSONException jSONException) {
                                    com.mixpanel.android.c.f.f("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", (Throwable)jSONException);
                                    return jSONObject2;
                                }
                            }
                        });
                        m.this.c.a("$experiment_started", (JSONObject)g2);
                    }
                }
                catch (JSONException jSONException) {
                    com.mixpanel.android.c.f.f("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", (Throwable)jSONException);
                }
            }
        }

        private void a(JSONArray jSONArray) {
            SharedPreferences.Editor editor = this.g().edit();
            editor.putString("mixpanel.viewcrawler.changes", jSONArray.toString());
            editor.apply();
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void a(JSONObject object) {
            Throwable throwable2222;
            long l2;
            block13 : {
                l2 = System.currentTimeMillis();
                object = object.getJSONObject("payload");
                if (object.has("config")) {
                    this.c = this.f.b((JSONObject)object);
                    com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
                }
                if (this.c != null) break block13;
                this.b("No snapshot configuration (or a malformed snapshot configuration) was sent.");
                com.mixpanel.android.c.f.d("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
                return;
            }
            BufferedOutputStream bufferedOutputStream = this.b.c();
            object = new OutputStreamWriter(bufferedOutputStream);
            ((Writer)object).write("{");
            ((Writer)object).write("\"type\": \"snapshot_response\",");
            ((Writer)object).write("\"payload\": {");
            ((Writer)object).write("\"activities\":");
            ((OutputStreamWriter)object).flush();
            this.c.a(m.this.e, bufferedOutputStream);
            long l3 = System.currentTimeMillis();
            ((Writer)object).write(",\"snapshot_time_millis\": ");
            ((Writer)object).write(Long.toString(l3 - l2));
            ((Writer)object).write("}");
            ((Writer)object).write("}");
            ((OutputStreamWriter)object).close();
            return;
            {
                catch (IOException iOException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
                    return;
                }
            }
            catch (c.a a2) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", a2);
                this.b(a2.getMessage());
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", (Throwable)jSONException);
                this.b("Payload with snapshot config required with snapshot request");
                return;
            }
            {
                catch (Throwable throwable2222) {
                }
                catch (IOException iOException) {}
                {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", iOException);
                }
                ((OutputStreamWriter)object).close();
                return;
            }
            try {
                ((OutputStreamWriter)object).close();
                throw throwable2222;
            }
            catch (IOException iOException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
            }
            throw throwable2222;
        }

        private void b() {
            Object object = this.g();
            String string2 = object.getString("mixpanel.viewcrawler.changes", null);
            object = object.getString("mixpanel.viewcrawler.bindings", null);
            this.l.clear();
            this.m.clear();
            this.q.clear();
            this.a(string2, false);
            this.o.clear();
            this.a((String)object);
            this.f();
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void b(String object) {
            Throwable throwable2222;
            if (this.b == null) return;
            if (!this.b.a()) return;
            if (!this.b.b()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", object);
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", (Throwable)jSONException);
            }
            object = new OutputStreamWriter(this.b.c());
            ((Writer)object).write("{\"type\": \"error\", ");
            ((Writer)object).write("\"payload\": ");
            ((Writer)object).write(jSONObject.toString());
            ((Writer)object).write("}");
            ((OutputStreamWriter)object).close();
            return;
            {
                catch (IOException iOException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", iOException);
                    return;
                }
                catch (Throwable throwable2222) {
                }
                catch (IOException iOException) {}
                {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't write error message to editor", iOException);
                }
                ((OutputStreamWriter)object).close();
                return;
            }
            try {
                ((OutputStreamWriter)object).close();
                throw throwable2222;
            }
            catch (IOException iOException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", iOException);
            }
            throw throwable2222;
        }

        private void b(JSONArray jSONArray) {
            this.a(jSONArray);
            this.a(jSONArray.toString(), true);
            this.f();
        }

        private void b(JSONObject jSONObject) {
            jSONObject = jSONObject.getJSONObject("payload").getJSONArray("actions");
            int n2 = 0;
            do {
                if (n2 >= jSONObject.length()) break;
                JSONObject jSONObject2 = jSONObject.getJSONObject(n2);
                String string2 = com.mixpanel.android.c.e.a(jSONObject2, "target_activity");
                String string3 = jSONObject2.getString("name");
                this.h.put(string3, new g<String, JSONObject>(string2, jSONObject2));
                ++n2;
                continue;
                break;
            } while (true);
            try {
                this.f();
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad change request received", (Throwable)jSONException);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void c() {
            void var2_9;
            Object object;
            void var1_5;
            StringBuilder stringBuilder;
            block8 : {
                block7 : {
                    block6 : {
                        com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", "connecting to editor");
                        if (this.b == null || !this.b.a()) break block6;
                        object = "There is already a valid connection to an events editor.";
                        break block7;
                    }
                    object = m.this.a.C();
                    if (object != null) break block8;
                    object = "SSL is not available on this device, no connection will be attempted to the events editor.";
                }
                com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", (String)object);
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(com.mixpanel.android.b.k.a(m.this.b).r());
            stringBuilder2.append(this.d);
            String string2 = stringBuilder2.toString();
            try {
                object = ((SocketFactory)object).createSocket();
                this.b = new com.mixpanel.android.d.e(new URI(string2), new a(), (Socket)object);
                return;
            }
            catch (IOException iOException) {
                com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", iOException);
                return;
            }
            catch (e.c c2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error connecting to URI ");
            }
            catch (URISyntaxException uRISyntaxException) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error parsing URI ");
                stringBuilder.append(string2);
                String string3 = " for editor websocket";
            }
            stringBuilder.append((String)var2_9);
            com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", stringBuilder.toString(), (Throwable)var1_5);
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private void c(String string2) {
            Throwable throwable2222;
            if (this.b == null) return;
            if (!this.b.a()) return;
            if (!this.b.b()) {
                return;
            }
            JsonWriter jsonWriter = new JsonWriter((Writer)new OutputStreamWriter(this.b.c()));
            jsonWriter.beginObject();
            jsonWriter.name("type").value("track_message");
            jsonWriter.name("payload");
            jsonWriter.beginObject();
            jsonWriter.name("event_name").value(string2);
            jsonWriter.endObject();
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
            return;
            {
                catch (IOException iOException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
                    return;
                }
                catch (Throwable throwable2222) {
                }
                catch (IOException iOException) {}
                {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", iOException);
                }
                jsonWriter.close();
                return;
            }
            try {
                jsonWriter.close();
                throw throwable2222;
            }
            catch (IOException iOException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", iOException);
            }
            throw throwable2222;
        }

        private void c(JSONArray jSONArray) {
            SharedPreferences.Editor editor = this.g().edit();
            editor.putString("mixpanel.viewcrawler.bindings", jSONArray.toString());
            editor.apply();
            this.a(jSONArray.toString());
            this.f();
        }

        private void c(JSONObject jSONObject) {
            int n2;
            try {
                jSONObject = jSONObject.getJSONObject("payload").getJSONArray("actions");
                n2 = 0;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad clear request received", (Throwable)jSONException);
            }
            do {
                if (n2 < jSONObject.length()) {
                    String string2 = jSONObject.getString(n2);
                    this.h.remove(string2);
                    ++n2;
                    continue;
                }
                break;
            } while (true);
            this.f();
        }

        /*
         * Exception decompiling
         */
        private void d() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:478)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:328)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:462)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
            // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        private void d(JSONObject jSONObject) {
            jSONObject = jSONObject.getJSONObject("payload").getJSONArray("tweaks");
            int n2 = jSONObject.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    Object object = jSONObject.getJSONObject(i2);
                    object = this.f.c((JSONObject)object);
                    this.i.put((String)object.first, (g<String, Object>)((Object)object));
                    continue;
                }
                catch (c.a | JSONException a2) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", a2);
                    break;
                }
            }
            this.f();
        }

        private void e() {
            this.h.clear();
            this.k.clear();
            this.i.clear();
            this.o.addAll(this.p);
            this.p.clear();
            this.c = null;
            com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
            this.f();
            for (String string2 : this.j) {
                this.g.c(string2);
            }
        }

        private void e(JSONObject jSONObject) {
            try {
                jSONObject = jSONObject.getJSONObject("payload").getJSONArray("events");
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad event bindings received", (Throwable)jSONException);
                return;
            }
            int n2 = jSONObject.length();
            this.k.clear();
            if (!this.o.isEmpty() && this.p.isEmpty()) {
                this.p.addAll(this.o);
                for (g jSONException : this.o) {
                    try {
                        this.k.put(((JSONObject)jSONException.second).get("path").toString(), jSONException);
                    }
                    catch (JSONException jSONException2) {
                        jSONException2.printStackTrace();
                    }
                }
                this.o.clear();
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(i2);
                    String string2 = com.mixpanel.android.c.e.a(jSONObject2, "target_activity");
                    this.k.put(jSONObject2.get("path").toString(), new g<String, Object>(string2, (Object)jSONObject2));
                    continue;
                }
                catch (JSONException jSONException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Bad event binding received from editor in ");
                    stringBuilder.append(jSONObject.toString());
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", stringBuilder.toString(), (Throwable)jSONException);
                }
            }
            this.f();
            return;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void f() {
            Iterator<Object> iterator;
            ArrayList<g<Object, o>> arrayList = new ArrayList<g<Object, o>>();
            HashSet<g<Integer, Integer>> hashSet = new HashSet<g<Integer, Integer>>();
            HashSet<String> hashSet2 = new HashSet<String>();
            for (d d2 : this.l) {
                try {
                    c.c c2 = this.f.a(d2.c);
                    arrayList.add(new g<String, o>(d2.b, c2.a));
                    if (this.q.contains(d2.d)) continue;
                    hashSet.add(d2.d);
                }
                catch (c.a a2) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", a2);
                }
                catch (c.d d3) {
                    com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", d3.getMessage());
                }
                catch (c.b b2) {
                    com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", b2);
                }
            }
            for (e e2 : this.m) {
                try {
                    g<String, Object> g2;
                    block38 : {
                        block37 : {
                            block36 : {
                                g2 = this.f.c(e2.b);
                                if (this.q.contains(e2.c)) break block36;
                                hashSet.add(e2.c);
                                iterator = g2.first;
                                break block37;
                            }
                            if (!m.this.f.b((String)g2.first, g2.second)) break block38;
                            iterator = g2.first;
                        }
                        hashSet2.add((String)((Object)iterator));
                    }
                    if (!m.this.f.a().containsKey(g2.first)) {
                        iterator = z.b.a(e2.b);
                        m.this.f.a((String)g2.first, (z.b)((Object)iterator));
                        continue;
                    }
                    m.this.f.a((String)g2.first, g2.second);
                }
                catch (c.a a3) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", a3);
                }
            }
            if (this.m.size() == 0) {
                for (Map.Entry entry : m.this.f.b().entrySet()) {
                    z.b b3 = (z.b)entry.getValue();
                    String string2 = (String)entry.getKey();
                    if (!m.this.f.b(string2, b3.g())) continue;
                    m.this.f.a(string2, b3.g());
                    hashSet2.add(string2);
                }
            }
            for (g g3 : this.h.values()) {
                try {
                    c.c c3 = this.f.a((JSONObject)g3.second);
                    arrayList.add(new g<Object, o>(g3.first, c3.a));
                    this.j.addAll(c3.b);
                }
                catch (c.a a4) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", a4);
                }
                catch (c.d d4) {
                    com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", d4.getMessage());
                }
                catch (c.b b4) {
                    com.mixpanel.android.c.f.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", b4);
                }
            }
            for (g g4 : this.i.values()) {
                if (m.this.f.b((String)g4.first, g4.second)) {
                    hashSet2.add((String)g4.first);
                }
                m.this.f.a((String)g4.first, g4.second);
            }
            if (this.k.size() == 0 && this.p.size() == 0) {
                for (g<String, JSONObject> g5 : this.o) {
                    try {
                        o o2 = this.f.a((JSONObject)g5.second, m.this.d);
                        arrayList.add(new g<Object, o>(g5.first, o2));
                    }
                    catch (c.a a5) {
                        com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", a5);
                    }
                    catch (c.d d5) {
                        com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", d5.getMessage());
                    }
                }
            }
            for (g<String, JSONObject> g6 : this.k.values()) {
                try {
                    o o3 = this.f.a((JSONObject)g6.second, m.this.d);
                    arrayList.add(new g<Object, o>(g6.first, o3));
                }
                catch (c.a a6) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", a6);
                }
                catch (c.d d6) {
                    com.mixpanel.android.c.f.c("MixpanelAPI.ViewCrawler", d6.getMessage());
                }
            }
            HashMap<String, List<o>> hashMap = new HashMap<String, List<o>>();
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                g g7 = (g)((Object)arrayList.get(i2));
                if (hashMap.containsKey(g7.first)) {
                    iterator = (List)hashMap.get(g7.first);
                } else {
                    iterator = new ArrayList();
                    hashMap.put((String)g7.first, (List<o>)((Object)iterator));
                }
                iterator.add(g7.second);
            }
            m.this.e.a(hashMap);
            for (g<Integer, Integer> g8 : this.n) {
                if (this.q.contains(g8)) continue;
                hashSet.add(g8);
            }
            this.q.addAll(hashSet);
            this.a(hashSet);
            this.n.clear();
            if (hashSet2.size() > 0) {
                iterator = m.this.j.iterator();
                while (iterator.hasNext()) {
                    ((p)iterator.next()).a(hashSet2);
                }
            }
        }

        private SharedPreferences g() {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("mixpanel.viewcrawler.changes");
            charSequence.append(this.d);
            charSequence = charSequence.toString();
            return m.this.b.getSharedPreferences((String)charSequence, 0);
        }

        public void a() {
            this.e.unlock();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void handleMessage(Message message) {
            this.e.lock();
            try {
                switch (message.what) {
                    case 13: {
                        this.a((JSONArray)message.obj);
                        break;
                    }
                    case 12: {
                        this.a((o.e)message.obj);
                        break;
                    }
                    case 11: {
                        this.d((JSONObject)message.obj);
                        break;
                    }
                    case 10: {
                        this.c((JSONObject)message.obj);
                        break;
                    }
                    case 9: {
                        this.b((JSONArray)message.obj);
                        break;
                    }
                    case 8: {
                        this.e();
                        break;
                    }
                    case 7: {
                        this.c((String)message.obj);
                        break;
                    }
                    case 6: {
                        this.e((JSONObject)message.obj);
                        break;
                    }
                    case 5: {
                        this.c((JSONArray)message.obj);
                        break;
                    }
                    case 4: {
                        this.d();
                        break;
                    }
                    case 3: {
                        this.b((JSONObject)message.obj);
                        break;
                    }
                    case 2: {
                        this.a((JSONObject)message.obj);
                        break;
                    }
                    case 1: {
                        this.c();
                        break;
                    }
                    case 0: {
                        this.b();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                this.e.unlock();
                return;
            }
            catch (Throwable throwable) {
                this.e.unlock();
                throw throwable;
            }
        }

    }

}

