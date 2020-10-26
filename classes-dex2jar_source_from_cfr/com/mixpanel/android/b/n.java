/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.mixpanel.android.b.a;
import com.mixpanel.android.b.f;
import com.mixpanel.android.b.j;
import com.mixpanel.android.b.k;
import com.mixpanel.android.b.l;
import com.mixpanel.android.b.o;
import com.mixpanel.android.b.q;
import com.mixpanel.android.b.r;
import com.mixpanel.android.b.u;
import com.mixpanel.android.b.v;
import com.mixpanel.android.b.w;
import com.mixpanel.android.b.z;
import com.mixpanel.android.d.m;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    private static final Map<String, Map<Context, n>> p = new HashMap<String, Map<Context, n>>();
    private static final v q = new v();
    private static final z r = new z();
    private static Future<SharedPreferences> s;
    private final Context a;
    private final com.mixpanel.android.b.a b;
    private final k c;
    private final String d;
    private final d e;
    private final com.mixpanel.android.d.l f;
    private final r g;
    private final g h;
    private final com.mixpanel.android.d.j i;
    private final com.mixpanel.android.b.d j;
    private final com.mixpanel.android.b.f k;
    private final Map<String, String> l;
    private final Map<String, Long> m;
    private o n;
    private final u o;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    n(Context object, Future<SharedPreferences> object2, String string2, k object3, boolean bl2) {
        HashMap<String, String> hashMap;
        String string3;
        void var1_4;
        void var3_12;
        void var5_15;
        String string4;
        this.a = object;
        this.d = var3_12;
        this.e = new d();
        this.c = string3;
        hashMap = new HashMap<String, String>();
        hashMap.put("$android_lib_version", "5.4.0");
        hashMap.put("$android_os", "Android");
        string3 = Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE;
        hashMap.put("$android_os_version", string3);
        string3 = Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER;
        hashMap.put("$android_manufacturer", string3);
        string3 = Build.BRAND == null ? "UNKNOWN" : Build.BRAND;
        hashMap.put("$android_brand", string3);
        string3 = Build.MODEL == null ? "UNKNOWN" : Build.MODEL;
        hashMap.put("$android_model", string3);
        try {
            string3 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
            hashMap.put("$android_app_version", ((PackageInfo)string3).versionName);
            hashMap.put("$android_app_version_code", Integer.toString(((PackageInfo)string3).versionCode));
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception getting app version name", (Throwable)nameNotFoundException);
        }
        this.l = Collections.unmodifiableMap(hashMap);
        this.o = new u();
        this.f = this.b((Context)object, (String)var3_12);
        this.i = this.l();
        this.g = this.a((Context)object, (Future<SharedPreferences>)((Object)string4), (String)var3_12);
        this.m = this.g.h();
        this.b = this.j();
        if (var5_15 != false) {
            this.e();
        }
        this.h = this.k();
        this.k = this.a((String)var3_12, this.h, this.f);
        this.j = new com.mixpanel.android.b.d(this);
        String string5 = string4 = this.g.d();
        if (string4 == null) {
            String string6 = this.g.c();
        }
        this.k.a((String)var1_4);
        if (this.g.a(l.a(this.a).b().exists())) {
            this.a("$ae_first_open", null, true);
            this.g.i();
        }
        if (!this.c.s()) {
            this.b.a(this.k);
        }
        this.g();
        if (this.m()) {
            this.a("$app_open", null);
        }
        if (!this.g.e(this.d)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", (Object)"Android");
                jSONObject.put("lib", (Object)"Android");
                jSONObject.put("distinct_id", (Object)var3_12);
                jSONObject.put("$lib_version", (Object)"5.4.0");
                a.a a2 = new a.a("Integration", jSONObject, "85053bf24bba75239b16a601d9387e17");
                this.b.a(a2);
                this.b.a(new a.b("85053bf24bba75239b16a601d9387e17", false));
                this.g.f(this.d);
            }
            catch (JSONException jSONException) {}
        }
        if (this.g.g((String)hashMap.get("$android_app_version_code"))) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("$ae_updated_version", hashMap.get("$android_app_version"));
                this.a("$ae_updated", jSONObject, true);
            }
            catch (JSONException jSONException) {}
        }
        this.f.a();
        com.mixpanel.android.b.g.a();
    }

    n(Context context, Future<SharedPreferences> future, String string2, boolean bl2) {
        this(context, future, string2, k.a(context), bl2);
    }

    public static n a(Context context, String string2) {
        return n.a(context, string2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static n a(Context context, String string2, boolean bl2) {
        if (string2 == null) {
            return null;
        }
        if (context == null) {
            return null;
        }
        Map<String, Map<Context, n>> map = p;
        synchronized (map) {
            Context context2 = context.getApplicationContext();
            if (s == null) {
                s = q.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
            }
            Object object = p.get(string2);
            Map<Context, n> map2 = object;
            if (object == null) {
                map2 = new HashMap<Context, n>();
                p.put(string2, map2);
            }
            n n2 = map2.get((Object)context2);
            object = n2;
            if (n2 == null) {
                object = n2;
                if (com.mixpanel.android.b.c.a(context2)) {
                    object = new n(context2, s, string2, bl2);
                    n.a(context, (n)object);
                    map2.put(context2, (n)object);
                }
            }
            n.a(context);
            return object;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(Context object) {
        String string2;
        if (!(object instanceof Activity)) {
            com.mixpanel.android.c.f.b("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
            return;
        }
        try {
            Class<?> class_ = Class.forName("bolts.AppLinks");
            Intent intent = ((Activity)object).getIntent();
            class_.getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, new Object[]{object, intent});
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to detect inbound App Links: ");
            string2 = illegalAccessException.getMessage();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Please install the Bolts library >= 1.1.2 to track App Links: ");
            string2 = noSuchMethodException.getMessage();
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Please install the Bolts library >= 1.1.2 to track App Links: ");
            string2 = classNotFoundException.getMessage();
        }
        ((StringBuilder)object).append(string2);
        com.mixpanel.android.c.f.b("MixpanelAPI.AL", ((StringBuilder)object).toString());
        return;
        catch (InvocationTargetException invocationTargetException) {
            com.mixpanel.android.c.f.b("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", invocationTargetException);
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(Context object, final n n2) {
        String string2;
        try {
            Class<?> class_ = Class.forName("androidx.i.a.a");
            Method method = class_.getMethod("getInstance", Context.class);
            class_.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(method.invoke(null, object), new Object[]{new BroadcastReceiver(){

                public void onReceive(Context context, Intent intent) {
                    context = new JSONObject();
                    Object object = intent.getBundleExtra("event_args");
                    if (object != null) {
                        for (String string2 : object.keySet()) {
                            try {
                                context.put(string2, object.get(string2));
                            }
                            catch (JSONException jSONException) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("failed to add key \"");
                                stringBuilder.append(string2);
                                stringBuilder.append("\" to properties for tracking bolts event");
                                com.mixpanel.android.c.f.e("MixpanelAPI.AL", stringBuilder.toString(), (Throwable)jSONException);
                            }
                        }
                    }
                    object = n2;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("$");
                    stringBuilder.append(intent.getStringExtra("event_name"));
                    ((n)object).a(stringBuilder.toString(), (JSONObject)context);
                }
            }, new IntentFilter("com.parse.bolts.measurement_event")});
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("App Links tracking will not be enabled due to this exception: ");
            string2 = illegalAccessException.getMessage();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("To enable App Links tracking android.support.v4 must be installed: ");
            string2 = noSuchMethodException.getMessage();
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("To enable App Links tracking android.support.v4 must be installed: ");
            string2 = classNotFoundException.getMessage();
        }
        ((StringBuilder)object).append(string2);
        com.mixpanel.android.c.f.b("MixpanelAPI.AL", ((StringBuilder)object).toString());
        return;
        catch (InvocationTargetException invocationTargetException) {
            com.mixpanel.android.c.f.b("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", invocationTargetException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(a a2) {
        Map<String, Map<Context, n>> map = p;
        synchronized (map) {
            Iterator<Map<Context, n>> iterator = p.values().iterator();
            block2 : while (iterator.hasNext()) {
                Iterator<n> iterator2 = iterator.next().values().iterator();
                do {
                    if (!iterator2.hasNext()) continue block2;
                    a2.a(iterator2.next());
                } while (true);
                break;
            }
            return;
        }
    }

    private void a(JSONArray jSONArray) {
        if (this.f()) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                this.b.a(new a.d(jSONObject, this.d));
                continue;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "Malformed people record stored pending identity, will not send it.", (Throwable)jSONException);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        if (this.f()) {
            return;
        }
        if (jSONObject.has("$distinct_id")) {
            this.b.a(new a.d(jSONObject, this.d));
            return;
        }
        this.g.b(jSONObject);
    }

    private void o() {
        if (this.f()) {
            return;
        }
        JSONArray jSONArray = this.g.e();
        if (jSONArray != null) {
            this.a(jSONArray);
        }
    }

    com.mixpanel.android.b.f a(String string2, f.a a2, com.mixpanel.android.d.l l2) {
        return new com.mixpanel.android.b.f(this.a, string2, a2, l2, this.g.j());
    }

    r a(Context context, Future<SharedPreferences> future, String string2) {
        Object object = new v.b(){

            @Override
            public void a(SharedPreferences sharedPreferences) {
                if ((sharedPreferences = r.a(sharedPreferences)) != null) {
                    n.this.a((JSONArray)sharedPreferences);
                }
            }
        };
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("com.mixpanel.android.mpmetrics.MixpanelAPI_");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        object = q.a(context, (String)charSequence, (v.b)object);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        return new r(future, (Future<SharedPreferences>)object, q.a(context, string2, null), q.a(context, "com.mixpanel.android.mpmetrics.Mixpanel", null));
    }

    public void a() {
        if (this.f()) {
            return;
        }
        this.b.a(new a.b(this.d));
    }

    public void a(w w2) {
        if (this.f()) {
            return;
        }
        this.g.a(w2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        if (this.f()) {
            return;
        }
        r r2 = this.g;
        synchronized (r2) {
            String string3;
            this.g.a(string2);
            string2 = string3 = this.g.d();
            if (string3 == null) {
                string2 = this.g.c();
            }
            this.k.a(string2);
            return;
        }
    }

    public void a(String string2, JSONObject jSONObject) {
        if (this.f()) {
            return;
        }
        this.a(string2, jSONObject, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a(String string2, JSONObject object, boolean bl2) {
        Object object2;
        if (this.f()) return;
        if (bl2 && !this.k.f()) {
            return;
        }
        Object object3 = this.m;
        synchronized (object3) {
            object2 = this.m.get(string2);
            this.m.remove(string2);
            this.g.d(string2);
        }
        try {
            object3 = new JSONObject();
            for (Map.Entry<String, String> entry : this.g.a().entrySet()) {
                object3.put(entry.getKey(), (Object)entry.getValue());
            }
            this.g.a((JSONObject)object3);
            double d2 = (double)System.currentTimeMillis() / 1000.0;
            object3.put("time", (long)d2);
            object3.put("distinct_id", (Object)this.b());
            if (object2 != null) {
                object3.put("$duration", d2 - (double)((Long)object2).longValue() / 1000.0);
            }
            if (object != null) {
                object2 = object.keys();
                while (object2.hasNext()) {
                    String string3 = (String)object2.next();
                    if (object.isNull(string3)) continue;
                    object3.put(string3, object.get(string3));
                }
            }
            object = new a.a(string2, (JSONObject)object3, this.d, bl2, this.o.b());
            this.b.a((a.a)object);
            if (this.i == null) return;
            this.i.a(string2);
            return;
        }
        catch (JSONException jSONException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Exception tracking event ");
            ((StringBuilder)object3).append(string2);
            com.mixpanel.android.c.f.e("MixpanelAPI.API", ((StringBuilder)object3).toString(), (Throwable)jSONException);
        }
    }

    com.mixpanel.android.d.l b(Context context, String string2) {
        if (Build.VERSION.SDK_INT < 16) {
            com.mixpanel.android.c.f.c("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            return new b(r);
        }
        if (!this.c.h() && !Arrays.asList(this.c.i()).contains(string2)) {
            return new m(this.a, this.d, this, r);
        }
        com.mixpanel.android.c.f.c("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
        return new b(r);
    }

    public String b() {
        return this.g.c();
    }

    public void b(String string2) {
        if (this.f()) {
            return;
        }
        this.a(string2, null);
    }

    public c c() {
        return this.e;
    }

    public Map<String, String> d() {
        return this.l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        this.j().a(new a.c(this.d));
        if (this.c().c()) {
            this.c().b();
            this.c().a();
        }
        this.g.f();
        Map<String, Long> map = this.m;
        synchronized (map) {
            this.m.clear();
            this.g.g();
        }
        this.g.b();
        this.g.a(true, this.d);
    }

    public boolean f() {
        return this.g.h(this.d);
    }

    @TargetApi(value=14)
    void g() {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.a.getApplicationContext() instanceof Application) {
                Application application = (Application)this.a.getApplicationContext();
                this.n = new o(this, this.c);
                application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.n);
                return;
            }
            com.mixpanel.android.c.f.c("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background.");
        }
    }

    void h() {
        this.a();
        this.f.b();
    }

    void i() {
        this.o.a();
    }

    com.mixpanel.android.b.a j() {
        return com.mixpanel.android.b.a.a(this.a);
    }

    g k() {
        if (Build.VERSION.SDK_INT < 16) {
            com.mixpanel.android.c.f.c("MixpanelAPI.API", "Notifications are not supported on this Android OS Version");
            return new f();
        }
        return new e();
    }

    com.mixpanel.android.d.j l() {
        if (this.f instanceof m) {
            return (com.mixpanel.android.d.j)((Object)this.f);
        }
        return null;
    }

    boolean m() {
        return this.c.g() ^ true;
    }

    protected void n() {
        if (this.f()) {
            return;
        }
        this.b.a(new a.b(this.d, false));
    }

    static interface a {
        public void a(n var1);
    }

    class b
    implements com.mixpanel.android.d.l {
        private final z b;

        public b(z z2) {
            this.b = z2;
        }

        @Override
        public void a() {
        }

        @Override
        public void a(JSONArray jSONArray) {
        }

        @Override
        public void b() {
        }

        @Override
        public void b(JSONArray jSONArray) {
        }

        @Override
        public void c(JSONArray jSONArray) {
        }
    }

    public static interface c {
        public void a();

        public void a(Activity var1);

        public void a(String var1);

        public void a(String var1, j var2, JSONObject var3);

        public void a(String var1, Object var2);

        public void a(String var1, JSONObject var2);

        public void a(JSONObject var1);

        public void b();

        public void b(String var1);

        public void b(String var1, Object var2);

        public void c(String var1);

        public boolean c();

        public c d(String var1);

        public void d();
    }

    private class d
    implements c {
        private d() {
        }

        private void a(final j j2, final Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                com.mixpanel.android.c.f.a("MixpanelAPI.API", "Will not show notifications, os version is too low.");
                return;
            }
            activity.runOnUiThread(new Runnable(){

                /*
                 * Exception decompiling
                 */
                @TargetApi(value=16)
                @Override
                public void run() {
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
                    // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                    // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                    // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                    // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                    // org.benf.cfr.reader.Main.main(Main.java:48)
                    throw new IllegalStateException("Decompilation failed");
                }
            });
        }

        private JSONObject c(String string2, Object object) {
            JSONObject jSONObject = new JSONObject();
            String string3 = this.f();
            jSONObject.put(string2, object);
            jSONObject.put("$token", (Object)n.this.d);
            jSONObject.put("$time", System.currentTimeMillis());
            if (string3 != null) {
                jSONObject.put("$distinct_id", (Object)string3);
            }
            jSONObject.put("$mp_metadata", (Object)n.this.o.c());
            return jSONObject;
        }

        @Override
        public void a() {
            this.b("$transactions");
        }

        @Override
        public void a(Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            this.a(null, activity);
        }

        public void a(j j2) {
            if (j2 == null) {
                return;
            }
            n.this.g.a(j2.b());
            if (n.this.f()) {
                return;
            }
            this.a("$campaign_delivery", j2, null);
            c c2 = n.this.c().d(this.f());
            if (c2 != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                JSONObject jSONObject = j2.a();
                try {
                    jSONObject.put("$time", (Object)simpleDateFormat.format(new Date()));
                }
                catch (JSONException jSONException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception trying to track an in-app notification seen", (Throwable)jSONException);
                }
                c2.b("$campaigns", j2.b());
                c2.b("$notifications", (Object)jSONObject);
                return;
            }
            com.mixpanel.android.c.f.e("MixpanelAPI.API", "No identity found. Make sure to call getPeople().identify() before showing in-app notifications.");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(String string2) {
            if (n.this.f()) {
                return;
            }
            r r2 = n.this.g;
            synchronized (r2) {
                n.this.g.b(string2);
                n.this.k.a(string2);
            }
            n.this.o();
        }

        @Override
        public void a(String string2, j j2, JSONObject jSONObject) {
            if (n.this.f()) {
                return;
            }
            j2 = j2.a();
            if (jSONObject != null) {
                try {
                    Iterator iterator = jSONObject.keys();
                    while (iterator.hasNext()) {
                        String string3 = (String)iterator.next();
                        j2.put(string3, jSONObject.get(string3));
                    }
                }
                catch (JSONException jSONException) {
                    com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception merging provided properties with notification properties", (Throwable)jSONException);
                }
            }
            n.this.a(string2, (JSONObject)j2);
        }

        @Override
        public void a(String string2, Object object) {
            if (n.this.f()) {
                return;
            }
            try {
                this.a(new JSONObject().put(string2, object));
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "set", (Throwable)jSONException);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a(String string2, JSONArray jSONArray) {
            if (n.this.f()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(string2, (Object)jSONArray);
                string2 = this.c("$union", (Object)jSONObject);
                n.this.a((JSONObject)string2);
                return;
            }
            catch (JSONException jSONException) {}
            com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception unioning a property");
        }

        @Override
        public void a(String string2, JSONObject jSONObject) {
            if (n.this.f()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(string2, (Object)jSONObject);
                string2 = this.c("$merge", (Object)jSONObject2);
                n.this.a((JSONObject)string2);
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception merging a property", (Throwable)jSONException);
                return;
            }
        }

        @Override
        public void a(JSONObject jSONObject) {
            if (n.this.f()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(n.this.l);
                Iterator iterator = jSONObject.keys();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    jSONObject2.put(string2, jSONObject.get(string2));
                }
                jSONObject = this.c("$set", (Object)jSONObject2);
                n.this.a(jSONObject);
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception setting people properties", (Throwable)jSONException);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b() {
            try {
                JSONObject jSONObject = this.c("$delete", JSONObject.NULL);
                n.this.a(jSONObject);
                return;
            }
            catch (JSONException jSONException) {}
            com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception deleting a user");
        }

        @Override
        public void b(String string2) {
            if (n.this.f()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object)string2);
                string2 = this.c("$unset", (Object)jSONArray);
                n.this.a((JSONObject)string2);
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception unsetting a property", (Throwable)jSONException);
                return;
            }
        }

        @Override
        public void b(String string2, Object object) {
            if (n.this.f()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(string2, object);
                string2 = this.c("$append", (Object)jSONObject);
                n.this.a((JSONObject)string2);
                return;
            }
            catch (JSONException jSONException) {
                com.mixpanel.android.c.f.e("MixpanelAPI.API", "Exception appending a property", (Throwable)jSONException);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void c(String string2) {
            r r2 = n.this.g;
            synchronized (r2) {
                if (n.this.g.d() == null) {
                    return;
                }
                n.this.g.c(string2);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object)string2);
                this.a("$android_devices", jSONArray);
                return;
            }
        }

        @Override
        public boolean c() {
            return this.f() != null;
        }

        @Override
        public c d(final String string2) {
            if (string2 == null) {
                return null;
            }
            return new d(){

                @Override
                public void a(String string22) {
                    throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
                }

                @Override
                public String f() {
                    return string2;
                }
            };
        }

        @Override
        public void d() {
            JSONArray jSONArray = n.this.k.c();
            n.this.f.c(jSONArray);
        }

        public j e() {
            return n.this.k.a(n.this.c.j());
        }

        public String f() {
            return n.this.g.d();
        }

    }

    private class e
    implements g,
    Runnable {
        private final Set<q> b = Collections.newSetFromMap(new ConcurrentHashMap());
        private final Executor c = Executors.newSingleThreadExecutor();

        private e() {
        }

        @Override
        public void a() {
            this.c.execute(this);
        }

        @Override
        public void b() {
            n.this.j.a(n.this.k.d());
        }

        @Override
        public void run() {
            Iterator<q> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                iterator.next().a();
            }
        }
    }

    private class f
    implements g {
        private f() {
        }

        @Override
        public void a() {
        }

        @Override
        public void b() {
        }
    }

    private static interface g
    extends f.a {
    }

}

