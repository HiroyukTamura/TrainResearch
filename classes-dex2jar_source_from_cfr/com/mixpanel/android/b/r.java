/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.mixpanel.android.b.w;
import com.mixpanel.android.c.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint(value={"CommitPrefEdits"})
class r {
    private static Integer m;
    private static Boolean n;
    private static boolean o = true;
    private static final Object p;
    private final Future<SharedPreferences> a;
    private final Future<SharedPreferences> b;
    private final Future<SharedPreferences> c;
    private final Future<SharedPreferences> d;
    private final SharedPreferences.OnSharedPreferenceChangeListener e;
    private JSONObject f;
    private Map<String, String> g;
    private boolean h;
    private String i;
    private String j;
    private JSONArray k;
    private Boolean l;

    static {
        p = new Object();
    }

    public r(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.b = future;
        this.a = future2;
        this.c = future3;
        this.d = future4;
        this.f = null;
        this.g = null;
        this.h = false;
        this.e = new SharedPreferences.OnSharedPreferenceChangeListener(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onSharedPreferenceChanged(SharedPreferences object, String string2) {
                object = p;
                synchronized (object) {
                    r.this.n();
                    o = false;
                    return;
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONArray a(SharedPreferences sharedPreferences) {
        String string2;
        String string3;
        block7 : {
            block6 : {
                string3 = sharedPreferences.getString("people_distinct_id", null);
                string2 = sharedPreferences.getString("waiting_array", null);
                if (string2 == null || string3 == null) break block6;
                try {}
                catch (JSONException jSONException) {}
                break block7;
                f.e("MixpanelAPI.PIdentity", "Waiting people records were unreadable.");
            }
            return null;
        }
        JSONArray jSONArray = new JSONArray(string2);
        string2 = new JSONArray();
        int n2 = 0;
        do {
            if (n2 >= jSONArray.length()) {
                sharedPreferences = sharedPreferences.edit();
                sharedPreferences.remove("waiting_array");
                r.a((SharedPreferences.Editor)sharedPreferences);
                return string2;
            }
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(n2);
                jSONObject.put("$distinct_id", (Object)string3);
                string2.put((Object)jSONObject);
            }
            catch (JSONException jSONException) {
                f.e("MixpanelAPI.PIdentity", "Unparsable object found in waiting people records", (Throwable)jSONException);
            }
            ++n2;
        } while (true);
    }

    private static void a(SharedPreferences.Editor editor) {
        editor.apply();
    }

    private void i(String string2) {
        Object object;
        block4 : {
            try {
                object = this.d.get();
                break block4;
            }
            catch (InterruptedException interruptedException) {
            }
            catch (ExecutionException executionException) {
                object = executionException.getCause();
            }
            f.e("MixpanelAPI.PIdentity", "Cannot read opt out flag from sharedPreferences.", (Throwable)object);
            object = null;
        }
        if (object == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("opt_out_");
        stringBuilder.append(string2);
        this.l = object.getBoolean(stringBuilder.toString(), false);
    }

    private void j(String string2) {
        Throwable throwable;
        try {
            SharedPreferences.Editor editor = this.d.get().edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("opt_out_");
            stringBuilder.append(string2);
            editor.putBoolean(stringBuilder.toString(), this.l.booleanValue());
            r.a(editor);
            return;
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            throwable = executionException.getCause();
        }
        f.e("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", throwable);
    }

    private JSONObject l() {
        if (this.f == null) {
            this.m();
        }
        return this.f;
    }

    /*
     * Exception decompiling
     */
    private void m() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    private void n() {
        block4 : {
            Throwable throwable;
            this.g = new HashMap<String, String>();
            try {
                SharedPreferences sharedPreferences = this.b.get();
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.e);
                sharedPreferences.registerOnSharedPreferenceChangeListener(this.e);
                for (Map.Entry entry : sharedPreferences.getAll().entrySet()) {
                    String string2 = (String)entry.getKey();
                    entry = entry.getValue();
                    this.g.put(string2, entry.toString());
                }
                break block4;
            }
            catch (InterruptedException interruptedException) {
            }
            catch (ExecutionException executionException) {
                throwable = executionException.getCause();
            }
            f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", throwable);
        }
    }

    private void o() {
        Throwable throwable;
        if (this.f == null) {
            f.e("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String string2 = this.f.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Storing Super Properties ");
        stringBuilder.append(string2);
        f.a("MixpanelAPI.PIdentity", stringBuilder.toString());
        try {
            stringBuilder = this.a.get().edit();
            stringBuilder.putString("super_properties", string2);
            r.a((SharedPreferences.Editor)stringBuilder);
            return;
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            throwable = executionException.getCause();
        }
        f.e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void p() {
        block9 : {
            void var1_7;
            block8 : {
                void var1_5;
                try {
                    SharedPreferences sharedPreferences = this.a.get();
                    break block8;
                }
                catch (InterruptedException interruptedException) {
                }
                catch (ExecutionException executionException) {
                    Throwable throwable = executionException.getCause();
                }
                f.e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", (Throwable)var1_5);
                Object var1_6 = null;
            }
            if (var1_7 == null) {
                return;
            }
            this.i = var1_7.getString("events_distinct_id", null);
            this.j = var1_7.getString("people_distinct_id", null);
            this.k = null;
            String string2 = var1_7.getString("waiting_array", null);
            if (string2 != null) {
                try {
                    this.k = new JSONArray(string2);
                    break block9;
                }
                catch (JSONException jSONException) {}
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not interpret waiting people JSON record ");
                stringBuilder.append(string2);
                f.e("MixpanelAPI.PIdentity", stringBuilder.toString());
            }
        }
        if (this.i == null) {
            this.i = UUID.randomUUID().toString();
            this.q();
        }
        this.h = true;
    }

    private void q() {
        Throwable throwable;
        try {
            SharedPreferences.Editor editor = this.a.get().edit();
            editor.putString("events_distinct_id", this.i);
            editor.putString("people_distinct_id", this.j);
            if (this.k == null) {
                editor.remove("waiting_array");
            } else {
                editor.putString("waiting_array", this.k.toString());
            }
            r.a(editor);
            return;
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            throwable = executionException.getCause();
        }
        f.e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map<String, String> a() {
        Object object = p;
        synchronized (object) {
            if (o || this.g == null) {
                this.n();
                o = false;
            }
            return this.g;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(w w2) {
        synchronized (this) {
            JSONObject jSONObject = this.l();
            JSONObject jSONObject2 = new JSONObject();
            try {
                Iterator iterator = jSONObject.keys();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    jSONObject2.put(string2, jSONObject.get(string2));
                }
            }
            catch (JSONException jSONException) {
                f.e("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", (Throwable)jSONException);
                return;
            }
            if ((w2 = w2.a(jSONObject2)) == null) {
                f.d("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
                return;
            }
            this.f = w2;
            this.o();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(Integer object) {
        // MONITORENTER : this
        Object object2 = this.a.get();
        SharedPreferences.Editor editor = object2.edit();
        object2 = object2.getString("seen_campaign_ids", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append(object);
        stringBuilder.append(",");
        editor.putString("seen_campaign_ids", stringBuilder.toString());
        r.a(editor);
        return;
        catch (InterruptedException interruptedException) {
            Throwable throwable3;
            block6 : {
                object = "Can't write campaign id to shared preferences";
                break block6;
                catch (ExecutionException executionException) {
                    object = "Can't write campaign d to shared preferences";
                    throwable3 = executionException.getCause();
                }
            }
            f.e("MixpanelAPI.PIdentity", (String)object, throwable3);
            return;
        }
    }

    public void a(String string2) {
        synchronized (this) {
            if (!this.h) {
                this.p();
            }
            this.i = string2;
            this.q();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(JSONObject jSONObject) {
        synchronized (this) {
            JSONObject jSONObject2 = this.l();
            Iterator iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                try {
                    jSONObject.put(string2, jSONObject2.get(string2));
                }
                catch (JSONException string22) {
                    f.e("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", (Throwable)string22);
                    continue;
                }
                break;
            }
            return;
        }
    }

    public void a(boolean bl2, String string2) {
        synchronized (this) {
            this.l = bl2;
            this.j(string2);
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean a(boolean bl2) {
        block5 : {
            Boolean bl3;
            block6 : {
                // MONITORENTER : this
                Boolean bl4 = n;
                if (bl4 != null) break block5;
                try {
                    bl4 = this.d.get().getBoolean("has_launched", false) ? Boolean.valueOf(false) : Boolean.valueOf(bl2 ^ true);
                    n = bl4;
                    break block5;
                }
                catch (ExecutionException executionException) {}
                bl3 = false;
                break block6;
                catch (InterruptedException interruptedException) {}
                bl3 = false;
            }
            n = bl3;
        }
        bl2 = n;
        // MONITOREXIT : this
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b() {
        var2_1 = r.p;
        // MONITORENTER : var2_1
        var1_2 = this.b.get().edit();
        var1_2.clear();
        r.a(var1_2);
        return;
        catch (InterruptedException var1_4) {}
        ** GOTO lbl-1000
        catch (ExecutionException var1_6) {
            var1_5 = var1_6.getCause();
        }
lbl-1000: // 2 sources:
        {
            f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", var1_5);
            return;
        }
    }

    public void b(String string2) {
        synchronized (this) {
            if (!this.h) {
                this.p();
            }
            this.j = string2;
            this.q();
            return;
        }
    }

    public void b(JSONObject jSONObject) {
        synchronized (this) {
            if (!this.h) {
                this.p();
            }
            if (this.k == null) {
                this.k = new JSONArray();
            }
            this.k.put((Object)jSONObject);
            this.q();
            return;
        }
    }

    public String c() {
        synchronized (this) {
            if (!this.h) {
                this.p();
            }
            String string2 = this.i;
            return string2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void c(String var1_1) {
        // MONITORENTER : this
        var2_6 = this.a.get().edit();
        var2_6.putString("push_id", var1_1);
        r.a(var2_6);
        return;
        catch (InterruptedException var1_3) {}
        ** GOTO lbl-1000
        catch (ExecutionException var1_5) {
            var1_4 = var1_5.getCause();
        }
lbl-1000: // 2 sources:
        {
            f.e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", var1_4);
            return;
        }
    }

    public String d() {
        synchronized (this) {
            if (!this.h) {
                this.p();
            }
            String string2 = this.j;
            return string2;
        }
    }

    public void d(String string2) {
        try {
            SharedPreferences.Editor editor = this.c.get().edit();
            editor.remove(string2);
            r.a(editor);
            return;
        }
        catch (ExecutionException executionException) {
            executionException.printStackTrace();
            return;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public JSONArray e() {
        Object object;
        JSONArray jSONArray;
        block9 : {
            block10 : {
                // MONITORENTER : this
                object = null;
                JSONArray jSONArray2 = null;
                jSONArray = r.a(this.a.get());
                try {
                    this.p();
                    return jSONArray;
                }
                catch (InterruptedException interruptedException) {
                    break block9;
                }
                catch (ExecutionException executionException) {
                    break block10;
                }
                catch (InterruptedException interruptedException) {
                    jSONArray = jSONArray2;
                    break block9;
                }
                catch (ExecutionException executionException) {
                    jSONArray = object;
                    object = executionException;
                }
            }
            object = ((Throwable)object).getCause();
        }
        f.e("MixpanelAPI.PIdentity", "Couldn't read waiting people records from shared preferences.", (Throwable)object);
        return jSONArray;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean e(String string2) {
        // MONITORENTER : this
        return this.d.get().getBoolean(string2, false);
        catch (InterruptedException interruptedException) {
            Throwable throwable3;
            block6 : {
                string2 = "Couldn't read internal Mixpanel from shared preferences.";
                break block6;
                catch (ExecutionException executionException) {
                    string2 = "Couldn't read internal Mixpanel shared preferences.";
                    throwable3 = executionException.getCause();
                }
            }
            f.e("MixpanelAPI.PIdentity", string2, throwable3);
        }
        boolean bl2 = false;
        // MONITOREXIT : this
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        synchronized (this) {
            try {
                try {
                    SharedPreferences.Editor editor = this.a.get().edit();
                    editor.clear();
                    r.a(editor);
                    this.m();
                    this.p();
                    return;
                }
                catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException.getCause());
                }
                catch (ExecutionException executionException) {
                    throw new RuntimeException(executionException.getCause());
                }
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void f(String string2) {
        // MONITORENTER : this
        SharedPreferences.Editor editor = this.d.get().edit();
        editor.putBoolean(string2, true);
        r.a(editor);
        return;
        catch (InterruptedException interruptedException) {
            Throwable throwable3;
            block6 : {
                string2 = "Couldn't write internal Mixpanel from shared preferences.";
                break block6;
                catch (ExecutionException executionException) {
                    string2 = "Couldn't write internal Mixpanel shared preferences.";
                    throwable3 = executionException.getCause();
                }
            }
            f.e("MixpanelAPI.PIdentity", string2, throwable3);
            return;
        }
    }

    public void g() {
        try {
            SharedPreferences.Editor editor = this.c.get().edit();
            editor.clear();
            r.a(editor);
            return;
        }
        catch (ExecutionException executionException) {
            executionException.printStackTrace();
            return;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean g(String object) {
        // MONITORENTER : this
        if (object == null) {
            // MONITOREXIT : this
            return false;
        }
        object = Integer.valueOf((String)object);
        try {
            SharedPreferences.Editor editor;
            if (m == null && (m = Integer.valueOf(this.d.get().getInt("latest_version_code", -1))) == -1) {
                m = object;
                editor = this.d.get().edit();
                editor.putInt("latest_version_code", ((Integer)object).intValue());
                r.a(editor);
            }
            if (m >= (Integer)object) return false;
            {
                editor = this.d.get().edit();
                editor.putInt("latest_version_code", ((Integer)object).intValue());
                r.a(editor);
                // MONITOREXIT : this
                return true;
            }
        }
        catch (InterruptedException interruptedException) {
            Throwable throwable;
            block8 : {
                object = "Couldn't write internal Mixpanel from shared preferences.";
                break block8;
                catch (ExecutionException executionException) {
                    object = "Couldn't write internal Mixpanel shared preferences.";
                    throwable = executionException.getCause();
                }
            }
            f.e("MixpanelAPI.PIdentity", (String)object, throwable);
            return false;
        }
    }

    public Map<String, Long> h() {
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        try {
            for (Map.Entry entry : this.c.get().getAll().entrySet()) {
                hashMap.put((String)entry.getKey(), Long.valueOf(entry.getValue().toString()));
            }
        }
        catch (ExecutionException executionException) {
            executionException.printStackTrace();
            return hashMap;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return hashMap;
    }

    public boolean h(String string2) {
        synchronized (this) {
            if (this.l == null) {
                this.i(string2);
            }
            boolean bl2 = this.l;
            return bl2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void i() {
        // MONITORENTER : this
        var1_1 = this.d.get().edit();
        var1_1.putBoolean("has_launched", true);
        r.a(var1_1);
        return;
        catch (InterruptedException var1_3) {}
        ** GOTO lbl-1000
        catch (ExecutionException var1_5) {
            var1_4 = var1_5.getCause();
        }
lbl-1000: // 2 sources:
        {
            f.e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", var1_4);
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public HashSet<Integer> j() {
        // MONITORENTER : this
        var2_1 = new HashSet<Integer>();
        try {
            var1_2 = new StringTokenizer(this.a.get().getString("seen_campaign_ids", ""), ",");
            while (var1_2.hasMoreTokens()) {
                var2_1.add(Integer.valueOf(var1_2.nextToken()));
            }
            return var2_1;
        }
        catch (InterruptedException var1_3) {}
        ** GOTO lbl-1000
        catch (ExecutionException var1_5) {
            var1_4 = var1_5.getCause();
        }
lbl-1000: // 2 sources:
        {
            f.e("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", var1_4);
            return var2_1;
        }
    }

}

