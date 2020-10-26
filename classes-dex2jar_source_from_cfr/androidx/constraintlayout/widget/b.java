/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Xml
 *  android.view.View
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class b {
    String a;
    boolean b;
    private a c;
    private int d;
    private float e;
    private String f;
    private int g;

    public b(b b2, Object object) {
        this.a = b2.a;
        this.c = b2.c;
        this.a(object);
    }

    public b(String string2, a a2, Object object) {
        this.a = string2;
        this.c = a2;
        this.a(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HashMap<String, b> a(HashMap<String, b> hashMap, View view) {
        HashMap<String, b> hashMap2 = new HashMap<String, b>();
        Class<?> class_ = view.getClass();
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = iterator.next();
            b b2 = hashMap.get(string2);
            try {
                if (string2.equals("BackgroundColor")) {
                    b2 = new b(b2, ((ColorDrawable)view.getBackground()).getColor());
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getMap");
                    stringBuilder.append(string2);
                    b2 = new b(b2, class_.getMethod(stringBuilder.toString(), new Class[0]).invoke((Object)view, new Object[0]));
                }
                hashMap2.put(string2, b2);
                continue;
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
                continue;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
                continue;
            }
            break;
        }
        return hashMap2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Context object, XmlPullParser object2, HashMap<String, b> hashMap) {
        TypedArray typedArray = object.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)object2), j.b.CustomAttribute);
        int n2 = typedArray.getIndexCount();
        String string2 = null;
        Object object3 = object = string2;
        Object object4 = object;
        for (int i2 = 0; i2 < n2; ++i2) {
            void var7_22;
            void var1_12;
            block9 : {
                block18 : {
                    int n3;
                    block19 : {
                        block14 : {
                            block17 : {
                                float f2;
                                block16 : {
                                    block15 : {
                                        block13 : {
                                            block12 : {
                                                block11 : {
                                                    block10 : {
                                                        block8 : {
                                                            n3 = typedArray.getIndex(i2);
                                                            if (n3 != j.b.CustomAttribute_attributeName) break block8;
                                                            string2 = typedArray.getString(n3);
                                                            object = string2;
                                                            Object object5 = object4;
                                                            Object object6 = object3;
                                                            if (string2 != null) {
                                                                object = string2;
                                                                Object object7 = object4;
                                                                Object object8 = object3;
                                                                if (string2.length() > 0) {
                                                                    object = new StringBuilder();
                                                                    ((StringBuilder)object).append(Character.toUpperCase(string2.charAt(0)));
                                                                    ((StringBuilder)object).append(string2.substring(1));
                                                                    object = ((StringBuilder)object).toString();
                                                                    Object object9 = object4;
                                                                    Object object10 = object3;
                                                                }
                                                            }
                                                            break block9;
                                                        }
                                                        if (n3 != j.b.CustomAttribute_customBoolean) break block10;
                                                        Boolean bl2 = typedArray.getBoolean(n3, false);
                                                        a a2 = a.f;
                                                        object = string2;
                                                        break block9;
                                                    }
                                                    if (n3 != j.b.CustomAttribute_customColorValue) break block11;
                                                    object = a.c;
                                                    break block12;
                                                }
                                                if (n3 != j.b.CustomAttribute_customColorDrawableValue) break block13;
                                                object = a.d;
                                            }
                                            n3 = typedArray.getColor(n3, 0);
                                            break block14;
                                        }
                                        if (n3 != j.b.CustomAttribute_customDimension) break block15;
                                        object = a.g;
                                        f2 = typedArray.getDimension(n3, 0.0f);
                                        break block16;
                                    }
                                    if (n3 != j.b.CustomAttribute_customFloatValue) break block17;
                                    object = a.b;
                                    f2 = typedArray.getFloat(n3, Float.NaN);
                                }
                                Float f3 = Float.valueOf(f2);
                                break block18;
                            }
                            if (n3 != j.b.CustomAttribute_customIntegerValue) break block19;
                            object = a.a;
                            n3 = typedArray.getInteger(n3, -1);
                        }
                        Integer n4 = n3;
                        break block18;
                    }
                    object = string2;
                    Object object11 = object4;
                    Object object12 = object3;
                    if (n3 != j.b.CustomAttribute_customStringValue) break block9;
                    object = a.e;
                    String string3 = typedArray.getString(n3);
                }
                Object object13 = object;
                object = string2;
            }
            string2 = object;
            object4 = var1_12;
            object3 = var7_22;
        }
        if (string2 != null && object4 != null) {
            void var2_13;
            var2_13.put(string2, new b(string2, (a)((Object)object3), object4));
        }
        typedArray.recycle();
    }

    /*
     * Exception decompiling
     */
    public static void a(View var0, HashMap<String, b> var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:478)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

    public void a(Object object) {
        switch (1.a[this.c.ordinal()]) {
            default: {
                return;
            }
            case 6: {
                this.b = (Boolean)object;
                return;
            }
            case 5: {
                this.f = (String)object;
                return;
            }
            case 4: 
            case 7: {
                this.e = ((Float)object).floatValue();
                return;
            }
            case 3: {
                this.d = (Integer)object;
                return;
            }
            case 1: 
            case 2: 
        }
        this.g = (Integer)object;
    }

    public static enum a {
        a,
        b,
        c,
        d,
        e,
        f,
        g;
        
    }

}

