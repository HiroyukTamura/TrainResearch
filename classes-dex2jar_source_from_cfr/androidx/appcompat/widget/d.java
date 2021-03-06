/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.database.DataSetObservable
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d
extends DataSetObservable {
    static final String a = "d";
    private static final Object e = new Object();
    private static final Map<String, d> f = new HashMap<String, d>();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    private boolean a(c c2) {
        boolean bl2 = this.i.add(c2);
        if (bl2) {
            this.n = true;
            this.h();
            this.c();
            this.e();
            this.notifyChanged();
        }
        return bl2;
    }

    private void c() {
        if (this.m) {
            if (!this.n) {
                return;
            }
            this.n = false;
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList<c>(this.i), this.c});
            }
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void d() {
        boolean bl2 = this.f();
        boolean bl3 = this.g();
        this.h();
        if (bl2 | bl3) {
            this.e();
            this.notifyChanged();
        }
    }

    private boolean e() {
        if (this.k != null && this.j != null && !this.h.isEmpty() && !this.i.isEmpty()) {
            this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
            return true;
        }
        return false;
    }

    private boolean f() {
        boolean bl2 = this.o;
        if (bl2 && this.j != null) {
            this.o = false;
            this.h.clear();
            List list = this.b.getPackageManager().queryIntentActivities(this.j, 0);
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ResolveInfo resolveInfo = (ResolveInfo)list.get(i2);
                this.h.add(new a(resolveInfo));
            }
            return true;
        }
        return false;
    }

    private boolean g() {
        if (this.d && this.n && !TextUtils.isEmpty((CharSequence)this.c)) {
            this.d = false;
            this.m = true;
            this.i();
            return true;
        }
        return false;
    }

    private void h() {
        int n2 = this.i.size() - this.l;
        if (n2 <= 0) {
            return;
        }
        this.n = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            c c2 = this.i.remove(0);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void i() {
        Throwable throwable222;
        FileInputStream fileInputStream;
        block16 : {
            Object object;
            fileInputStream = this.b.openFileInput(this.c);
            try {
                int n2;
                XmlPullParser xmlPullParser;
                block17 : {
                    xmlPullParser = Xml.newPullParser();
                    xmlPullParser.setInput((InputStream)fileInputStream, "UTF-8");
                    n2 = 0;
                    while (n2 != 1 && n2 != 2) {
                        n2 = xmlPullParser.next();
                    }
                    break block17;
                    catch (FileNotFoundException fileNotFoundException) {
                        return;
                    }
                }
                if (!"historical-records".equals(xmlPullParser.getName())) throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                object = this.i;
                object.clear();
                do {
                    if ((n2 = xmlPullParser.next()) == 1) {
                        if (fileInputStream == null) return;
                        break;
                    }
                    if (n2 == 3 || n2 == 4) continue;
                    if (!"historical-record".equals(xmlPullParser.getName())) throw new XmlPullParserException("Share records file not well-formed.");
                    object.add(new c(xmlPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParser.getAttributeValue(null, "weight"))));
                    continue;
                    break;
                } while (true);
            }
            catch (Throwable throwable222) {
                break block16;
            }
            catch (IOException iOException) {
                object = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error reading historical recrod file: ");
                stringBuilder.append(this.c);
                Log.e((String)object, (String)stringBuilder.toString(), (Throwable)iOException);
                if (fileInputStream == null) return;
            }
            catch (XmlPullParserException xmlPullParserException) {
                object = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error reading historical recrod file: ");
                stringBuilder.append(this.c);
                Log.e((String)object, (String)stringBuilder.toString(), (Throwable)xmlPullParserException);
                if (fileInputStream == null) return;
            }
            try {
                fileInputStream.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
        if (fileInputStream == null) throw throwable222;
        try {
            fileInputStream.close();
        }
        catch (IOException iOException) {
            throw throwable222;
        }
        throw throwable222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a() {
        Object object = this.g;
        synchronized (object) {
            this.d();
            return this.h.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(ResolveInfo resolveInfo) {
        Object object = this.g;
        synchronized (object) {
            this.d();
            List<a> list = this.h;
            int n2 = list.size();
            int n3 = 0;
            while (n3 < n2) {
                if (list.get((int)n3).a == resolveInfo) {
                    return n3;
                }
                ++n3;
            }
            return -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ResolveInfo a(int n2) {
        Object object = this.g;
        synchronized (object) {
            this.d();
            return this.h.get((int)n2).a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent b(int n2) {
        Object object = this.g;
        synchronized (object) {
            Intent intent;
            if (this.j == null) {
                return null;
            }
            this.d();
            a a2 = this.h.get(n2);
            a2 = new ComponentName(a2.a.activityInfo.packageName, a2.a.activityInfo.name);
            Intent intent2 = new Intent(this.j);
            intent2.setComponent((ComponentName)a2);
            if (this.p != null && this.p.a(this, intent = new Intent(intent2))) {
                return null;
            }
            this.a(new c((ComponentName)a2, System.currentTimeMillis(), 1.0f));
            return intent2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ResolveInfo b() {
        Object object = this.g;
        synchronized (object) {
            this.d();
            if (this.h.isEmpty()) return null;
            return this.h.get((int)0).a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(int n2) {
        Object object = this.g;
        synchronized (object) {
            this.d();
            a a2 = this.h.get(n2);
            a a3 = this.h.get(0);
            float f2 = a3 != null ? a3.b - a2.b + 5.0f : 1.0f;
            this.a(new c(new ComponentName(a2.a.activityInfo.packageName, a2.a.activityInfo.name), System.currentTimeMillis(), f2));
            return;
        }
    }

    public static final class a
    implements Comparable<a> {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.a = resolveInfo;
        }

        public int a(a a2) {
            return Float.floatToIntBits(a2.b) - Float.floatToIntBits(this.b);
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this.a((a)object);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (a)object;
            return Float.floatToIntBits(this.b) == Float.floatToIntBits(((a)object).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:");
            stringBuilder.append(this.a.toString());
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal(this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static interface b {
        public void a(Intent var1, List<a> var2, List<c> var3);
    }

    public static final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(ComponentName componentName, long l2, float f2) {
            this.a = componentName;
            this.b = l2;
            this.c = f2;
        }

        public c(String string2, long l2, float f2) {
            this(ComponentName.unflattenFromString((String)string2), l2, f2);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (c)object;
            if (this.a == null ? ((c)object).a != null : !this.a.equals((Object)((c)object).a)) {
                return false;
            }
            if (this.b != ((c)object).b) {
                return false;
            }
            return Float.floatToIntBits(this.c) == Float.floatToIntBits(((c)object).c);
        }

        public int hashCode() {
            int n2 = this.a == null ? 0 : this.a.hashCode();
            return ((n2 + 31) * 31 + (int)(this.b ^ this.b >>> 32)) * 31 + Float.floatToIntBits(this.c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:");
            stringBuilder.append((Object)this.a);
            stringBuilder.append("; time:");
            stringBuilder.append(this.b);
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal(this.c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static interface d {
        public boolean a(d var1, Intent var2);
    }

    private final class e
    extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /*
         * Exception decompiling
         */
        public /* varargs */ Void a(Object ... var1_1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
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

        public /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a(arrobject);
        }
    }

}

