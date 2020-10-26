/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.iid.InstanceID
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.mixpanel.android.b.f;
import com.mixpanel.android.b.k;
import com.mixpanel.android.b.l;
import com.mixpanel.android.b.n;
import com.mixpanel.android.b.x;
import com.mixpanel.android.c.h;
import com.mixpanel.android.c.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

class a {
    private static final Map<Context, a> d = new HashMap<Context, a>();
    protected final Context a;
    protected final k b;
    private final e c;

    a(Context context) {
        this.a = context;
        this.b = this.c(context);
        this.c = this.a();
        this.b().a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(Context object) {
        Map<Context, a> map = d;
        synchronized (map) {
            Context context = object.getApplicationContext();
            if (d.containsKey((Object)context)) return d.get((Object)context);
            object = new a(context);
            d.put(context, (a)object);
            return object;
        }
    }

    private void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (Thread ");
        stringBuilder.append(Thread.currentThread().getId());
        stringBuilder.append(")");
        com.mixpanel.android.c.f.a("MixpanelAPI.Messages", stringBuilder.toString());
    }

    private void a(String string2, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (Thread ");
        stringBuilder.append(Thread.currentThread().getId());
        stringBuilder.append(")");
        com.mixpanel.android.c.f.a("MixpanelAPI.Messages", stringBuilder.toString(), throwable);
    }

    protected e a() {
        return new e();
    }

    public void a(a a2) {
        Message message = Message.obtain();
        message.what = 1;
        message.obj = a2;
        this.c.a(message);
    }

    public void a(b b2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public void a(c c2) {
        Message message = Message.obtain();
        message.what = 6;
        message.obj = c2;
        this.c.a(message);
    }

    public void a(d d2) {
        Message message = Message.obtain();
        message.what = 0;
        message.obj = d2;
        this.c.a(message);
    }

    public void a(f f2) {
        Message message = Message.obtain();
        message.what = 12;
        message.obj = f2;
        this.c.a(message);
    }

    protected l b(Context context) {
        return l.a(context);
    }

    protected i b() {
        return new com.mixpanel.android.c.c();
    }

    protected k c(Context context) {
        return k.a(context);
    }

    static class a
    extends c {
        private final String a;
        private final JSONObject b;
        private final JSONObject c;
        private final boolean d;

        public a(String string2, JSONObject jSONObject, String string3) {
            this(string2, jSONObject, string3, false, new JSONObject());
        }

        public a(String string2, JSONObject jSONObject, String string3, boolean bl2, JSONObject jSONObject2) {
            super(string3);
            this.a = string2;
            this.b = jSONObject;
            this.d = bl2;
            this.c = jSONObject2;
        }

        public String a() {
            return this.a;
        }

        public JSONObject b() {
            return this.b;
        }

        public JSONObject c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }
    }

    static class b
    extends c {
        private final boolean a;

        public b(String string2) {
            this(string2, true);
        }

        protected b(String string2, boolean bl2) {
            super(string2);
            this.a = bl2;
        }

        public boolean a() {
            return this.a;
        }
    }

    static class c {
        private final String a;

        public c(String string2) {
            this.a = string2;
        }

        public String e() {
            return this.a;
        }
    }

    static class d
    extends c {
        private final JSONObject a;

        public d(JSONObject jSONObject, String string2) {
            super(string2);
            this.a = jSONObject;
        }

        public JSONObject a() {
            return this.a;
        }

        public String toString() {
            return this.a.toString();
        }
    }

    class e {
        private final Object b = new Object();
        private Handler c = this.a();
        private long d = 0L;
        private long e = 0L;
        private long f = -1L;
        private x g;

        static /* synthetic */ Handler a(e e2, Handler handler) {
            e2.c = handler;
            return handler;
        }

        static /* synthetic */ void a(e e2) {
            e2.b();
        }

        static /* synthetic */ Object b(e e2) {
            return e2.b;
        }

        private void b() {
            long l2 = System.currentTimeMillis();
            long l3 = this.d + 1L;
            if (this.f > 0L) {
                this.e = (l2 - this.f + this.e * this.d) / l3;
                long l4 = this.e / 1000L;
                com.mixpanel.android.b.a a2 = a.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Average send frequency approximately ");
                stringBuilder.append(l4);
                stringBuilder.append(" seconds.");
                a2.a(stringBuilder.toString());
            }
            this.f = l2;
            this.d = l3;
        }

        static /* synthetic */ x c(e e2) {
            return e2.g;
        }

        protected Handler a() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            return new a(handlerThread.getLooper());
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a(Message message) {
            Object object = this.b;
            synchronized (object) {
                if (this.c == null) {
                    com.mixpanel.android.b.a a2 = a.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Dead mixpanel worker dropping a message: ");
                    stringBuilder.append(message.what);
                    a2.a(stringBuilder.toString());
                } else {
                    this.c.sendMessage(message);
                }
                return;
            }
        }

        class a
        extends Handler {
            private l b;
            private final com.mixpanel.android.b.e c;
            private final long d;
            private long e;
            private long f;
            private int g;

            public a(Looper looper) {
                super(looper);
                this.b = null;
                e.this.g = x.a(a.this.a);
                this.c = this.a();
                this.d = a.this.b.b();
            }

            private JSONObject a(com.mixpanel.android.b.a$a a2) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = a2.b();
                JSONObject jSONObject3 = this.b();
                jSONObject3.put("token", (Object)a2.e());
                if (jSONObject2 != null) {
                    Iterator iterator = jSONObject2.keys();
                    while (iterator.hasNext()) {
                        String string2 = (String)iterator.next();
                        jSONObject3.put(string2, jSONObject2.get(string2));
                    }
                }
                jSONObject.put("event", (Object)a2.a());
                jSONObject.put("properties", (Object)jSONObject3);
                jSONObject.put("$mp_metadata", (Object)a2.c());
                return jSONObject;
            }

            private void a(l l2, String string2) {
                if (!a.this.b().a(a.this.a, a.this.b.D())) {
                    a.this.a("Not flushing data to Mixpanel because the device is not connected to the internet.");
                    return;
                }
                this.a(l2, string2, l.b.a, a.this.b.k());
                this.a(l2, string2, l.b.b, a.this.b.m());
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            private void a(l object, String charSequence, l.b b2, String string2) {
                i i2 = a.this.b();
                Object object2 = this.c.b((String)charSequence);
                boolean bl2 = object2 != null && ((f)object2).e() != null;
                Object object3 = ((l)object).a(b2, (String)charSequence, bl2);
                object2 = 0;
                Object object4 = object3;
                if (object3 != null) {
                    object2 = Integer.valueOf(object3[2]);
                    object4 = object3;
                }
                do {
                    boolean bl3;
                    String string3;
                    block18 : {
                        Object object5;
                        block23 : {
                            block20 : {
                                block19 : {
                                    block22 : {
                                        boolean bl4 = false;
                                        boolean bl5 = false;
                                        bl3 = false;
                                        if (object4 == null) return;
                                        if ((Integer)object2 <= 0) return;
                                        string3 = object4[0];
                                        object4 = object4[1];
                                        object3 = com.mixpanel.android.c.b.a((String)object4);
                                        object5 = new HashMap<String, Object>();
                                        object5.put("data", object3);
                                        if (k.a) {
                                            object5.put("verbose", "1");
                                        }
                                        try {
                                            block21 : {
                                                block17 : {
                                                    object3 = i2.a(string2, (Map<String, Object>)object5, a.this.b.C());
                                                    if (object3 != null) break block17;
                                                    try {
                                                        object4 = a.this;
                                                        object3 = new StringBuilder();
                                                        ((StringBuilder)object3).append("Response was null, unexpected failure posting to ");
                                                        ((StringBuilder)object3).append(string2);
                                                        ((StringBuilder)object3).append(".");
                                                        ((com.mixpanel.android.b.a)object4).a(((StringBuilder)object3).toString());
                                                        bl3 = bl5;
                                                        break block18;
                                                    }
                                                    catch (MalformedURLException malformedURLException) {
                                                        break block19;
                                                    }
                                                    catch (OutOfMemoryError outOfMemoryError) {
                                                        bl3 = bl4;
                                                        break block20;
                                                    }
                                                }
                                                try {
                                                    object3 = new String((byte[])object3, "UTF-8");
                                                    if (this.g <= 0) break block21;
                                                    this.g = 0;
                                                }
                                                catch (UnsupportedEncodingException unsupportedEncodingException) {
                                                    throw new RuntimeException("UTF not supported on this platform?", unsupportedEncodingException);
                                                }
                                                this.removeMessages(2, (Object)charSequence);
                                            }
                                            object5 = a.this;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Successfully posted to ");
                                            stringBuilder.append(string2);
                                            stringBuilder.append(": \n");
                                            stringBuilder.append((String)object4);
                                            ((com.mixpanel.android.b.a)object5).a(stringBuilder.toString());
                                            object4 = a.this;
                                            object5 = new StringBuilder();
                                            ((StringBuilder)object5).append("Response was ");
                                            ((StringBuilder)object5).append((String)object3);
                                            ((com.mixpanel.android.b.a)object4).a(((StringBuilder)object5).toString());
                                            bl3 = true;
                                            break block18;
                                        }
                                        catch (IOException iOException) {
                                            object3 = a.this;
                                            object5 = new StringBuilder();
                                        }
                                        catch (SocketTimeoutException socketTimeoutException) {
                                            object3 = a.this;
                                            object5 = new StringBuilder();
                                        }
                                        ((StringBuilder)object5).append("Cannot post message to ");
                                        ((StringBuilder)object5).append(string2);
                                        ((StringBuilder)object5).append(".");
                                        ((com.mixpanel.android.b.a)object3).a(((StringBuilder)object5).toString(), (Throwable)object4);
                                        break block22;
                                        catch (i.a a2) {
                                            object3 = a.this;
                                            object5 = new StringBuilder();
                                            ((StringBuilder)object5).append("Cannot post message to ");
                                            ((StringBuilder)object5).append(string2);
                                            ((StringBuilder)object5).append(".");
                                            ((com.mixpanel.android.b.a)object3).a(((StringBuilder)object5).toString(), a2);
                                            this.f = a2.a() * 1000;
                                        }
                                    }
                                    bl3 = false;
                                    break block18;
                                    catch (MalformedURLException malformedURLException) {
                                        bl3 = true;
                                    }
                                }
                                object3 = new StringBuilder();
                                ((StringBuilder)object3).append("Cannot interpret ");
                                ((StringBuilder)object3).append(string2);
                                object5 = " as a URL.";
                                break block23;
                                catch (OutOfMemoryError outOfMemoryError) {
                                    bl3 = true;
                                }
                            }
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append("Out of memory when posting to ");
                            ((StringBuilder)object3).append(string2);
                            object5 = ".";
                        }
                        ((StringBuilder)object3).append((String)object5);
                        com.mixpanel.android.c.f.e("MixpanelAPI.Messages", ((StringBuilder)object3).toString(), (Throwable)object4);
                    }
                    if (!bl3) {
                        this.removeMessages(2, (Object)charSequence);
                        this.f = Math.max((long)Math.pow(2.0, this.g) * 60000L, this.f);
                        this.f = Math.min(this.f, 600000L);
                        object = Message.obtain();
                        ((Message)object).what = 2;
                        ((Message)object).obj = charSequence;
                        this.sendMessageDelayed((Message)object, this.f);
                        ++this.g;
                        object = a.this;
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Retrying this batch of events in ");
                        ((StringBuilder)charSequence).append(this.f);
                        ((StringBuilder)charSequence).append(" ms");
                        ((com.mixpanel.android.b.a)object).a(((StringBuilder)charSequence).toString());
                        return;
                    }
                    a.this.a("Not retrying this batch of events, deleting them from DB.");
                    ((l)object).a(string3, b2, (String)charSequence, bl2);
                    object4 = ((l)object).a(b2, (String)charSequence, bl2);
                    if (object4 == null) continue;
                    object2 = Integer.valueOf(object4[2]);
                } while (true);
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            private void a(final String string2) {
                try {
                    block6 : {
                        try {
                            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(a.this.a) == 0) break block6;
                            com.mixpanel.android.c.f.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play Services are not installed.");
                            return;
                        }
                        catch (RuntimeException runtimeException) {}
                    }
                    string2 = InstanceID.getInstance((Context)a.this.a).getToken(string2, "GCM", null);
                    n.a(new n.a(){

                        @Override
                        public void a(n n2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Using existing pushId ");
                            stringBuilder.append(string2);
                            com.mixpanel.android.c.f.a("MixpanelAPI.Messages", stringBuilder.toString());
                            n2.c().c(string2);
                        }
                    });
                    return;
                    com.mixpanel.android.c.f.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play services are not configured.");
                    return;
                }
                catch (IOException iOException) {}
                com.mixpanel.android.c.f.c("MixpanelAPI.Messages", "Exception when trying to register for GCM", iOException);
                return;
                catch (NoClassDefFoundError noClassDefFoundError) {}
                com.mixpanel.android.c.f.d("MixpanelAPI.Messages", "Google play services were not part of this build, push notifications cannot be registered or delivered");
            }

            /*
             * Exception decompiling
             */
            private JSONObject b() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

            protected com.mixpanel.android.b.e a() {
                return new com.mixpanel.android.b.e(a.this.a, a.this.b);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            public void handleMessage(Message var1_1) {
                block31 : {
                    block34 : {
                        block33 : {
                            if (this.b == null) {
                                this.b = e.this.a.this.b(e.this.a.this.a);
                                this.b.a(System.currentTimeMillis() - e.this.a.this.b.c(), l.b.a);
                                this.b.a(System.currentTimeMillis() - e.this.a.this.b.c(), l.b.b);
                            }
                            var2_5 = -3;
                            try {
                                var4_6 = var1_1.what;
                                var3_7 = 0;
                                if (var4_6 == 0) {
                                    var9_8 = (d)var1_1.obj;
                                    com.mixpanel.android.b.a.a(e.this.a.this, "Queuing people record for sending later");
                                    var1_1 = e.this.a.this;
                                    var10_13 = new StringBuilder();
                                    var10_13.append("    ");
                                    var10_13.append(var9_8.toString());
                                    com.mixpanel.android.b.a.a((com.mixpanel.android.b.a)var1_1, var10_13.toString());
                                    var1_1 = var9_8.e();
                                    var2_5 = this.b.a(var9_8.a(), (String)var1_1, l.b.b, false);
                                    break block31;
                                }
                                if (var1_1.what == 1) {
                                    block32 : {
                                        var10_13 = (com.mixpanel.android.b.a$a)var1_1.obj;
                                        var9_8 = this.a((com.mixpanel.android.b.a$a)var10_13);
                                        com.mixpanel.android.b.a.a(e.this.a.this, "Queuing event for sending later");
                                        var1_1 = e.this.a.this;
                                        var11_14 = new StringBuilder();
                                        var11_14.append("    ");
                                        var11_14.append(var9_8.toString());
                                        com.mixpanel.android.b.a.a((com.mixpanel.android.b.a)var1_1, var11_14.toString());
                                        var1_1 = var10_13.e();
                                        try {
                                            var11_14 = this.c.b((String)var1_1);
                                            if (var11_14 != null && var10_13.d() && !var11_14.f()) {
                                                return;
                                            }
                                            var2_5 = var3_7 = this.b.a((JSONObject)var9_8, (String)var1_1, l.b.a, var10_13.d());
                                            break block31;
                                        }
                                        catch (JSONException var9_9) {
                                            break block32;
                                        }
                                        catch (JSONException var9_10) {
                                            var1_1 = null;
                                        }
                                    }
                                    var11_14 = new StringBuilder();
                                    var11_14.append("Exception tracking event ");
                                    var11_14.append(var10_13.a());
                                    com.mixpanel.android.c.f.e("MixpanelAPI.Messages", var11_14.toString(), (Throwable)var9_8);
                                    break block31;
                                }
                                if (var1_1.what == 2) {
                                    com.mixpanel.android.b.a.a(e.this.a.this, "Flushing queue due to scheduled or forced flush");
                                    e.a(e.this);
                                    var9_8 = (String)var1_1.obj;
                                    if (var1_1.arg1 == 1) {
                                        var3_7 = 1;
                                    }
                                    this.a(this.b, (String)var9_8);
                                    if (var3_7 != 0 && (var5_15 = SystemClock.elapsedRealtime()) >= (var7_16 = this.e)) {
                                        try {
                                            this.c.a((String)var9_8, e.this.a.this.b());
                                        }
                                        catch (i.a var1_2) {
                                            this.e = SystemClock.elapsedRealtime() + (long)(var1_2.a() * 1000);
                                        }
                                    }
                                    break block33;
                                }
                                if (var1_1.what == 12) {
                                    com.mixpanel.android.b.a.a(e.this.a.this, "Installing a check for in-app notifications");
                                    var1_1 = (f)var1_1.obj;
                                    this.c.a((f)var1_1);
                                    var5_15 = SystemClock.elapsedRealtime();
                                    var7_16 = this.e;
                                    if (var5_15 >= var7_16) {
                                        try {
                                            this.c.a(var1_1.a(), e.this.a.this.b());
                                        }
                                        catch (i.a var1_3) {
                                            this.e = SystemClock.elapsedRealtime() + (long)(var1_3.a() * 1000);
                                        }
                                    }
                                    break block34;
                                }
                                if (var1_1.what == 13) {
                                    this.a((String)var1_1.obj);
                                    break block34;
                                }
                                if (var1_1.what == 6) {
                                    var1_1 = ((c)var1_1.obj).e();
                                    this.b.a(l.b.a, (String)var1_1);
                                    this.b.a(l.b.b, (String)var1_1);
                                    break block31;
                                }
                                if (var1_1.what != 5) ** GOTO lbl-1000
                                var1_1 = new StringBuilder();
                                var1_1.append("Worker received a hard kill. Dumping all events and force-killing. Thread id ");
                                var1_1.append(Thread.currentThread().getId());
                                com.mixpanel.android.c.f.d("MixpanelAPI.Messages", var1_1.toString());
                                var1_1 = e.b(e.this);
                                // MONITORENTER : var1_1
                            }
                            catch (RuntimeException var9_11) {
                                com.mixpanel.android.c.f.e("MixpanelAPI.Messages", "Worker threw an unhandled exception", var9_11);
                                var1_1 = e.b(e.this);
                                // MONITORENTER : var1_1
                                e.a(e.this, null);
                                try {
                                    Looper.myLooper().quit();
                                    com.mixpanel.android.c.f.e("MixpanelAPI.Messages", "Mixpanel will not process any more analytics messages", var9_11);
                                    return;
                                }
                                catch (Exception var9_12) {
                                    com.mixpanel.android.c.f.e("MixpanelAPI.Messages", "Could not halt looper", var9_12);
                                }
                                return;
                            }
                            this.b.a();
                            e.a(e.this, null);
                            Looper.myLooper().quit();
                            // MONITOREXIT : var1_1
                            break block34;
lbl-1000: // 1 sources:
                            {
                                var9_8 = new StringBuilder();
                                var9_8.append("Unexpected message received by Mixpanel worker: ");
                                var9_8.append(var1_1);
                                com.mixpanel.android.c.f.e("MixpanelAPI.Messages", var9_8.toString());
                                break block34;
                            }
                        }
                        var1_1 = var9_8;
                        break block31;
                    }
                    var1_1 = null;
                }
                if ((var2_5 >= e.this.a.this.b.a() || var2_5 == -2) && this.g <= 0 && var1_1 != null) {
                    var9_8 = e.this.a.this;
                    var10_13 = new StringBuilder();
                    var10_13.append("Flushing queue due to bulk upload limit (");
                    var10_13.append(var2_5);
                    var10_13.append(") for project ");
                    var10_13.append((String)var1_1);
                    com.mixpanel.android.b.a.a((com.mixpanel.android.b.a)var9_8, var10_13.toString());
                    e.a(e.this);
                    this.a(this.b, (String)var1_1);
                    var5_15 = SystemClock.elapsedRealtime();
                    var7_16 = this.e;
                    if (var5_15 < var7_16) return;
                    try {
                        this.c.a((String)var1_1, e.this.a.this.b());
                        return;
                    }
                    catch (i.a var1_4) {
                        this.e = SystemClock.elapsedRealtime() + (long)(var1_4.a() * 1000);
                        return;
                    }
                }
                if (var2_5 <= 0) return;
                if (this.hasMessages(2, var1_1) != false) return;
                var9_8 = e.this.a.this;
                var10_13 = new StringBuilder();
                var10_13.append("Queue depth ");
                var10_13.append(var2_5);
                var10_13.append(" - Adding flush in ");
                var10_13.append(this.d);
                com.mixpanel.android.b.a.a((com.mixpanel.android.b.a)var9_8, var10_13.toString());
                if (this.d < 0L) return;
                var9_8 = Message.obtain();
                var9_8.what = 2;
                var9_8.obj = var1_1;
                var9_8.arg1 = 1;
                this.sendMessageDelayed((Message)var9_8, this.d);
            }

        }

    }

}

