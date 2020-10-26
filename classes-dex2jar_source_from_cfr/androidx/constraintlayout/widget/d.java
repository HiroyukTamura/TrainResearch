/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.g;
import androidx.constraintlayout.widget.j;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class d {
    e a;
    int b = -1;
    int c = -1;
    private final ConstraintLayout d;
    private SparseArray<a> e = new SparseArray();
    private SparseArray<e> f = new SparseArray();
    private g g = null;

    d(Context context, ConstraintLayout constraintLayout, int n2) {
        this.d = constraintLayout;
        this.a(context, n2);
    }

    /*
     * Exception decompiling
     */
    private void a(Context var1_1, int var2_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [0, 1, 8, 9] lbl51 : SwitchStatement: switch (var7_9.hashCode()) { // 1[SWITCH]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03Blocks.topologicalSort(Op03Blocks.java:983)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:456)
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

    private void a(Context context, XmlPullParser xmlPullParser) {
        e e2 = new e();
        int n2 = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!"mId".equals(xmlPullParser.getAttributeName(i2))) continue;
            String string2 = xmlPullParser.getAttributeValue(i2);
            if (string2.contains("/")) {
                String string3 = string2.substring(string2.indexOf(47) + 1);
                i2 = context.getResources().getIdentifier(string3, "mId", null);
            } else {
                i2 = -1;
            }
            n2 = i2;
            if (i2 == -1) {
                if (string2 != null && string2.length() > 1) {
                    n2 = Integer.parseInt(string2.substring(1));
                } else {
                    Log.e((String)"ConstraintLayoutStates", (String)"error in parsing mId");
                    n2 = i2;
                }
            }
            e2.a(context, xmlPullParser);
            this.f.put(n2, (Object)e2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, float f2, float f3) {
        if (this.b == n2) {
            Object object = n2 == -1 ? this.e.valueAt(0) : this.e.get(this.b);
            a a2 = (a)object;
            if (this.c != -1 && a2.b.get(this.c).a(f2, f3)) {
                return;
            }
            int n3 = a2.a(f2, f3);
            if (this.c == n3) {
                return;
            }
            object = n3 == -1 ? this.a : a2.b.get((int)n3).f;
            n2 = n3 == -1 ? a2.c : a2.b.get((int)n3).e;
            if (object == null) {
                return;
            }
            this.c = n3;
            if (this.g != null) {
                this.g.a(-1, n2);
            }
            ((e)object).b(this.d);
            if (this.g == null) return;
            {
                this.g.b(-1, n2);
                return;
            }
        } else {
            this.b = n2;
            a a3 = (a)this.e.get(this.b);
            int n4 = a3.a(f2, f3);
            Object object = n4 == -1 ? a3.d : a3.b.get((int)n4).f;
            int n5 = n4 == -1 ? a3.c : a3.b.get((int)n4).e;
            if (object == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("NO Constraint set found ! id=");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(", dim =");
                ((StringBuilder)object).append(f2);
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(f3);
                Log.v((String)"ConstraintLayoutStates", (String)((StringBuilder)object).toString());
                return;
            }
            this.c = n4;
            if (this.g != null) {
                this.g.a(n2, n5);
            }
            ((e)object).b(this.d);
            if (this.g == null) return;
            {
                this.g.b(n2, n5);
            }
        }
    }

    public void a(g g2) {
        this.g = g2;
    }

    static class a {
        int a;
        ArrayList<b> b = new ArrayList();
        int c = -1;
        e d;

        public a(Context context, XmlPullParser xmlPullParser) {
            xmlPullParser = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), j.b.State);
            int n2 = xmlPullParser.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = xmlPullParser.getIndex(i2);
                if (n3 == j.b.State_android_id) {
                    this.a = xmlPullParser.getResourceId(n3, this.a);
                    continue;
                }
                if (n3 != j.b.State_constraints) continue;
                this.c = xmlPullParser.getResourceId(n3, this.c);
                String string2 = context.getResources().getResourceTypeName(this.c);
                context.getResources().getResourceName(this.c);
                if (!"layout".equals(string2)) continue;
                this.d = new e();
                this.d.a(context, this.c);
            }
            xmlPullParser.recycle();
        }

        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                if (!this.b.get(i2).a(f2, f3)) continue;
                return i2;
            }
            return -1;
        }

        void a(b b2) {
            this.b.add(b2);
        }
    }

    static class b {
        float a = Float.NaN;
        float b = Float.NaN;
        float c = Float.NaN;
        float d = Float.NaN;
        int e = -1;
        e f;

        public b(Context context, XmlPullParser xmlPullParser) {
            xmlPullParser = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), j.b.Variant);
            int n2 = xmlPullParser.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = xmlPullParser.getIndex(i2);
                if (n3 == j.b.Variant_constraints) {
                    this.e = xmlPullParser.getResourceId(n3, this.e);
                    String string2 = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if (!"layout".equals(string2)) continue;
                    this.f = new e();
                    this.f.a(context, this.e);
                    continue;
                }
                if (n3 == j.b.Variant_region_heightLessThan) {
                    this.d = xmlPullParser.getDimension(n3, this.d);
                    continue;
                }
                if (n3 == j.b.Variant_region_heightMoreThan) {
                    this.b = xmlPullParser.getDimension(n3, this.b);
                    continue;
                }
                if (n3 == j.b.Variant_region_widthLessThan) {
                    this.c = xmlPullParser.getDimension(n3, this.c);
                    continue;
                }
                if (n3 == j.b.Variant_region_widthMoreThan) {
                    this.a = xmlPullParser.getDimension(n3, this.a);
                    continue;
                }
                Log.v((String)"ConstraintLayoutStates", (String)"Unknown tag");
            }
            xmlPullParser.recycle();
        }

        boolean a(float f2, float f3) {
            if (!Float.isNaN(this.a) && f2 < this.a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f3 < this.b) {
                return false;
            }
            if (!Float.isNaN(this.c) && f2 > this.c) {
                return false;
            }
            return Float.isNaN(this.d) || !(f3 > this.d);
        }
    }

}

