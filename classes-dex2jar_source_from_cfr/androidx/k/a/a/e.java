/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.Keyframe
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.InflateException
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.k.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.a.a.g;
import androidx.core.graphics.b;
import androidx.k.a.a.d;
import androidx.k.a.a.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {
    private static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = g.a(resources, theme, attributeSet, androidx.k.a.a.a.j);
        int n2 = 0;
        theme = g.b((TypedArray)resources, xmlPullParser, "value", 0);
        boolean bl2 = theme != null;
        int n3 = n2;
        if (bl2) {
            n3 = n2;
            if (e.a(theme.type)) {
                n3 = 3;
            }
        }
        resources.recycle();
        return n3;
    }

    private static int a(TypedArray typedArray, int n2, int n3) {
        block3 : {
            block2 : {
                TypedValue typedValue = typedArray.peekValue(n2);
                int n4 = 1;
                int n5 = 0;
                n2 = typedValue != null ? 1 : 0;
                int n6 = n2 != 0 ? typedValue.type : 0;
                typedArray = typedArray.peekValue(n3);
                n3 = typedArray != null ? n4 : 0;
                n4 = n3 != 0 ? typedArray.type : 0;
                if (n2 != 0 && e.a(n6)) break block2;
                n2 = n5;
                if (n3 == 0) break block3;
                n2 = n5;
                if (!e.a(n4)) break block3;
            }
            n2 = 3;
        }
        return n2;
    }

    public static Animator a(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator((Context)context, (int)n2);
        }
        return e.a(context, context.getResources(), context.getTheme(), n2);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int n2) {
        return e.a(context, resources, theme, n2, 1.0f);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Animator a(Context var0, Resources var1_4, Resources.Theme var2_11, int var3_12, float var4_13) {
        block9 : {
            var7_14 = null;
            var8_15 = null;
            var5_16 = null;
            var6_17 = var1_4.getAnimation(var3_12);
            try {
                var0 = e.a(var0, var1_4, (Resources.Theme)var2_11, (XmlPullParser)var6_17, var4_13);
                if (var6_17 == null) return var0;
            }
            catch (Throwable var0_1) {
                var5_16 = var6_17;
                ** GOTO lbl37
            }
            catch (IOException var1_5) {
                var0 = var6_17;
                break block9;
            }
            catch (XmlPullParserException var1_6) {
                var0 = var6_17;
                ** GOTO lbl42
            }
            var6_17.close();
            return var0;
            catch (Throwable var0_2) {
                ** GOTO lbl37
            }
            catch (IOException var1_7) {
                var0 = var7_14;
            }
        }
        var5_16 = var0;
        {
            var2_11 = new StringBuilder();
            var5_16 = var0;
            var2_11.append("Can't load animation resource ID #0x");
            var5_16 = var0;
            var2_11.append(Integer.toHexString(var3_12));
            var5_16 = var0;
            var2_11 = new Resources.NotFoundException(var2_11.toString());
            var5_16 = var0;
            var2_11.initCause((Throwable)var1_8);
            var5_16 = var0;
            throw var2_11;
lbl37: // 2 sources:
            if (var5_16 == null) throw var0_3;
            var5_16.close();
            throw var0_3;
            catch (XmlPullParserException var1_10) {
                var0 = var8_15;
            }
lbl42: // 2 sources:
            var5_16 = var0;
            var2_11 = new StringBuilder();
            var5_16 = var0;
            var2_11.append("Can't load animation resource ID #0x");
            var5_16 = var0;
            var2_11.append(Integer.toHexString(var3_12));
            var5_16 = var0;
            var2_11 = new Resources.NotFoundException(var2_11.toString());
            var5_16 = var0;
            var2_11.initCause((Throwable)var1_9);
            var5_16 = var0;
            throw var2_11;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) {
        return e.a(context, resources, theme, xmlPullParser, Xml.asAttributeSet((XmlPullParser)xmlPullParser), null, 0, f2);
    }

    private static Animator a(Context object, Resources object2, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int n2, float f2) {
        ArrayList<PropertyValuesHolder[]> arrayList;
        PropertyValuesHolder[] arrpropertyValuesHolder;
        int n3;
        int n4;
        block12 : {
            int n5 = xmlPullParser.getDepth();
            arrpropertyValuesHolder = null;
            arrayList = null;
            do {
                int n6 = xmlPullParser.next();
                n3 = 0;
                n4 = 0;
                if (n6 == 3 && xmlPullParser.getDepth() <= n5 || n6 == 1) break block12;
                if (n6 != 2) continue;
                PropertyValuesHolder[] arrpropertyValuesHolder2 = xmlPullParser.getName();
                if (arrpropertyValuesHolder2.equals("objectAnimator")) {
                    arrpropertyValuesHolder2 = e.a((Context)object, (Resources)object2, theme, attributeSet, f2, xmlPullParser);
                } else if (arrpropertyValuesHolder2.equals("animator")) {
                    arrpropertyValuesHolder2 = e.a((Context)object, (Resources)object2, theme, attributeSet, null, f2, xmlPullParser);
                } else if (arrpropertyValuesHolder2.equals("set")) {
                    arrpropertyValuesHolder2 = new AnimatorSet();
                    arrpropertyValuesHolder = g.a((Resources)object2, theme, attributeSet, androidx.k.a.a.a.h);
                    n3 = g.a((TypedArray)arrpropertyValuesHolder, xmlPullParser, "ordering", 0, 0);
                    e.a((Context)object, (Resources)object2, theme, xmlPullParser, attributeSet, (AnimatorSet)arrpropertyValuesHolder2, n3, f2);
                    arrpropertyValuesHolder.recycle();
                } else {
                    if (!arrpropertyValuesHolder2.equals("propertyValuesHolder")) break;
                    arrpropertyValuesHolder2 = e.a((Context)object, (Resources)object2, theme, xmlPullParser, Xml.asAttributeSet((XmlPullParser)xmlPullParser));
                    if (arrpropertyValuesHolder2 != null && arrpropertyValuesHolder != null && arrpropertyValuesHolder instanceof ValueAnimator) {
                        ((ValueAnimator)arrpropertyValuesHolder).setValues(arrpropertyValuesHolder2);
                    }
                    n4 = 1;
                    arrpropertyValuesHolder2 = arrpropertyValuesHolder;
                }
                arrpropertyValuesHolder = arrpropertyValuesHolder2;
                if (animatorSet == null) continue;
                arrpropertyValuesHolder = arrpropertyValuesHolder2;
                if (n4 != 0) continue;
                ArrayList<PropertyValuesHolder[]> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<PropertyValuesHolder[]>();
                }
                arrayList2.add(arrpropertyValuesHolder2);
                arrpropertyValuesHolder = arrpropertyValuesHolder2;
                arrayList = arrayList2;
            } while (true);
            object = new StringBuilder();
            ((StringBuilder)object).append("Unknown animator name: ");
            ((StringBuilder)object).append(xmlPullParser.getName());
            throw new RuntimeException(((StringBuilder)object).toString());
        }
        if (animatorSet != null && arrayList != null) {
            object = new Animator[arrayList.size()];
            object2 = arrayList.iterator();
            n4 = n3;
            while (object2.hasNext()) {
                object[n4] = (Animator)object2.next();
                ++n4;
            }
            if (n2 == 0) {
                animatorSet.playTogether((Animator[])object);
                return arrpropertyValuesHolder;
            }
            animatorSet.playSequentially((Animator[])object);
        }
        return arrpropertyValuesHolder;
    }

    private static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat((float)f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt((float)f2);
        }
        return Keyframe.ofObject((float)f2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static Keyframe a(Context var0, Resources var1_1, Resources.Theme var2_2, AttributeSet var3_3, int var4_4, XmlPullParser var5_5) {
        var2_2 = g.a(var1_1, var2_2, var3_3, androidx.k.a.a.a.j);
        var6_6 = g.a((TypedArray)var2_2, var5_5, "fraction", 3, -1.0f);
        var1_1 = g.b((TypedArray)var2_2, var5_5, "value", 0);
        var8_7 = var1_1 != null;
        var7_8 = var4_4;
        if (var4_4 == 4) {
            var7_8 = var8_7 != false && e.a(var1_1.type) != false ? 3 : 0;
        }
        if (var8_7) {
            if (var7_8 != 3) {
                switch (var7_8) {
                    default: {
                        var1_1 = null;
                        ** break;
                    }
                    case 0: {
                        var1_1 = Keyframe.ofFloat((float)var6_6, (float)g.a((TypedArray)var2_2, var5_5, "value", 0, 0.0f));
                        ** break;
                    }
                    case 1: 
                }
            }
            var1_1 = Keyframe.ofInt((float)var6_6, (int)g.a((TypedArray)var2_2, var5_5, "value", 0, 0));
            ** break;
lbl20: // 3 sources:
        } else {
            var1_1 = var7_8 == 0 ? Keyframe.ofFloat((float)var6_6) : Keyframe.ofInt((float)var6_6);
        }
        var4_4 = g.c((TypedArray)var2_2, var5_5, "interpolator", 1, 0);
        if (var4_4 > 0) {
            var1_1.setInterpolator((TimeInterpolator)d.a(var0, var4_4));
        }
        var2_2.recycle();
        return var1_1;
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        e.a(context, resources, theme, attributeSet, (ValueAnimator)objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder a(Context resources, Resources resources2, Resources.Theme theme, XmlPullParser xmlPullParser, String string2, int n2) {
        Object var14_6 = null;
        ArrayList<Keyframe> arrayList = null;
        int n3 = n2;
        while ((n2 = xmlPullParser.next()) != 3 && n2 != 1) {
            if (!xmlPullParser.getName().equals("keyframe")) continue;
            n2 = n3;
            if (n3 == 4) {
                n2 = e.a(resources2, theme, Xml.asAttributeSet((XmlPullParser)xmlPullParser), xmlPullParser);
            }
            Keyframe keyframe = e.a((Context)resources, resources2, theme, Xml.asAttributeSet((XmlPullParser)xmlPullParser), n2, xmlPullParser);
            ArrayList<Keyframe> arrayList2 = arrayList;
            if (keyframe != null) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<Keyframe>();
                }
                arrayList2.add(keyframe);
            }
            xmlPullParser.next();
            n3 = n2;
            arrayList = arrayList2;
        }
        resources = var14_6;
        if (arrayList != null) {
            int n4 = arrayList.size();
            resources = var14_6;
            if (n4 > 0) {
                int n5 = 0;
                resources = (Keyframe)arrayList.get(0);
                resources2 = (Keyframe)arrayList.get(n4 - 1);
                float f2 = resources2.getFraction();
                n2 = n4;
                if (f2 < 1.0f) {
                    if (f2 < 0.0f) {
                        resources2.setFraction(1.0f);
                        n2 = n4;
                    } else {
                        arrayList.add(arrayList.size(), e.a((Keyframe)resources2, 1.0f));
                        n2 = n4 + 1;
                    }
                }
                f2 = resources.getFraction();
                n4 = n2;
                if (f2 != 0.0f) {
                    if (f2 < 0.0f) {
                        resources.setFraction(0.0f);
                        n4 = n2;
                    } else {
                        arrayList.add(0, e.a((Keyframe)resources, 0.0f));
                        n4 = n2 + 1;
                    }
                }
                resources = new Keyframe[n4];
                arrayList.toArray((T[])resources);
                for (n2 = n5; n2 < n4; ++n2) {
                    resources2 = resources[n2];
                    if (!(resources2.getFraction() < 0.0f)) continue;
                    if (n2 == 0) {
                        resources2.setFraction(0.0f);
                        continue;
                    }
                    int n6 = n4 - 1;
                    if (n2 == n6) {
                        resources2.setFraction(1.0f);
                        continue;
                    }
                    n5 = n2 + 1;
                    int n7 = n2;
                    while (n5 < n6 && !(resources[n5].getFraction() >= 0.0f)) {
                        n7 = n5++;
                    }
                    e.a((Keyframe[])resources, resources[n7 + 1].getFraction() - resources[n2 - 1].getFraction(), n2, n7);
                }
                resources = resources2 = PropertyValuesHolder.ofKeyframe((String)string2, (Keyframe[])resources);
                if (n3 == 3) {
                    resources2.setEvaluator((TypeEvaluator)f.a());
                    resources = resources2;
                }
            }
        }
        return resources;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static PropertyValuesHolder a(TypedArray object, int n2, int n3, int n4, String string2) {
        b.b[] arrb = object.peekValue(n3);
        boolean bl2 = arrb != null;
        int n5 = bl2 ? arrb.type : 0;
        arrb = object.peekValue(n4);
        boolean bl3 = arrb != null;
        int n6 = bl3 ? arrb.type : 0;
        int n7 = n2;
        if (n2 == 4) {
            n7 = bl2 && e.a(n5) || bl3 && e.a(n6) ? 3 : 0;
        }
        n2 = n7 == 0 ? 1 : 0;
        arrb = null;
        b.b[] arrb2 = null;
        if (n7 == 2) {
            String string3 = object.getString(n3);
            String string4 = object.getString(n4);
            arrb2 = b.b(string3);
            b.b[] arrb3 = b.b(string4);
            if (arrb2 == null) {
                object = arrb;
                if (arrb3 == null) return object;
            }
            if (arrb2 == null) {
                object = arrb;
                if (arrb3 == null) return object;
                return PropertyValuesHolder.ofObject((String)string2, (TypeEvaluator)new a(), (Object[])new Object[]{arrb3});
            }
            arrb = new a();
            if (arrb3 == null) {
                object = new Object[]{arrb2};
                return PropertyValuesHolder.ofObject((String)string2, (TypeEvaluator)arrb, (Object[])object);
            }
            if (b.a(arrb2, arrb3)) {
                object = new Object[]{arrb2, arrb3};
                return PropertyValuesHolder.ofObject((String)string2, (TypeEvaluator)arrb, (Object[])object);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(" Can't morph from ");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(" to ");
            ((StringBuilder)object).append(string4);
            throw new InflateException(((StringBuilder)object).toString());
        }
        f f2 = n7 == 3 ? f.a() : null;
        if (n2 != 0) {
            if (bl2) {
                float f3 = n5 == 5 ? object.getDimension(n3, 0.0f) : object.getFloat(n3, 0.0f);
                if (bl3) {
                    float f4 = n6 == 5 ? object.getDimension(n4, 0.0f) : object.getFloat(n4, 0.0f);
                    object = PropertyValuesHolder.ofFloat((String)string2, (float[])new float[]{f3, f4});
                } else {
                    object = PropertyValuesHolder.ofFloat((String)string2, (float[])new float[]{f3});
                }
            } else {
                float f5 = n6 == 5 ? object.getDimension(n4, 0.0f) : object.getFloat(n4, 0.0f);
                object = PropertyValuesHolder.ofFloat((String)string2, (float[])new float[]{f5});
            }
            arrb = object;
        } else if (bl2) {
            n2 = n5 == 5 ? (int)object.getDimension(n3, 0.0f) : (e.a(n5) ? object.getColor(n3, 0) : object.getInt(n3, 0));
            if (bl3) {
                n3 = n6 == 5 ? (int)object.getDimension(n4, 0.0f) : (e.a(n6) ? object.getColor(n4, 0) : object.getInt(n4, 0));
                arrb = PropertyValuesHolder.ofInt((String)string2, (int[])new int[]{n2, n3});
            } else {
                arrb = PropertyValuesHolder.ofInt((String)string2, (int[])new int[]{n2});
            }
        } else {
            arrb = arrb2;
            if (bl3) {
                n2 = n6 == 5 ? (int)object.getDimension(n4, 0.0f) : (e.a(n6) ? object.getColor(n4, 0) : object.getInt(n4, 0));
                arrb = PropertyValuesHolder.ofInt((String)string2, (int[])new int[]{n2});
            }
        }
        object = arrb;
        if (arrb == null) return object;
        object = arrb;
        if (f2 == null) return object;
        arrb.setEvaluator((TypeEvaluator)f2);
        return arrb;
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray typedArray = g.a(resources, theme, attributeSet, androidx.k.a.a.a.g);
        theme = g.a(resources, theme, attributeSet, androidx.k.a.a.a.k);
        resources = valueAnimator;
        if (valueAnimator == null) {
            resources = new ValueAnimator();
        }
        e.a((ValueAnimator)resources, typedArray, (TypedArray)theme, f2, xmlPullParser);
        int n2 = g.c(typedArray, xmlPullParser, "interpolator", 0, 0);
        if (n2 > 0) {
            resources.setInterpolator((TimeInterpolator)d.a(context, n2));
        }
        typedArray.recycle();
        if (theme != null) {
            theme.recycle();
        }
        return resources;
    }

    private static void a(ValueAnimator object, TypedArray typedArray, int n2, float f2, XmlPullParser object2) {
        object = (ObjectAnimator)object;
        String string2 = g.a(typedArray, object2, "pathData", 1);
        if (string2 != null) {
            String string3 = g.a(typedArray, object2, "propertyXName", 2);
            object2 = g.a(typedArray, object2, "propertyYName", 3);
            if (n2 != 2) {
                // empty if block
            }
            if (string3 == null && object2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append(typedArray.getPositionDescription());
                ((StringBuilder)object).append(" propertyXName or propertyYName is needed for PathData");
                throw new InflateException(((StringBuilder)object).toString());
            }
            e.a(b.a(string2), (ObjectAnimator)object, f2 * 0.5f, string3, (String)object2);
            return;
        }
        object.setPropertyName(g.a(typedArray, object2, "propertyName", 0));
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        int n2;
        long l2 = g.a(typedArray, xmlPullParser, "duration", 1, 300);
        long l3 = g.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int n3 = n2 = g.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (g.a(xmlPullParser, "valueFrom")) {
            n3 = n2;
            if (g.a(xmlPullParser, "valueTo")) {
                int n4 = n2;
                if (n2 == 4) {
                    n4 = e.a(typedArray, 5, 6);
                }
                PropertyValuesHolder propertyValuesHolder = e.a(typedArray, n4, 5, 6, "");
                n3 = n4;
                if (propertyValuesHolder != null) {
                    valueAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
                    n3 = n4;
                }
            }
        }
        valueAnimator.setDuration(l2);
        valueAnimator.setStartDelay(l3);
        valueAnimator.setRepeatCount(g.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(g.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            e.a(valueAnimator, typedArray2, n3, f2, xmlPullParser);
        }
    }

    private static void a(Path object, ObjectAnimator objectAnimator, float f2, String string2, String string3) {
        float f3;
        PathMeasure pathMeasure = new PathMeasure(object, false);
        ArrayList<Float> arrayList = new ArrayList<Float>();
        arrayList.add(Float.valueOf(0.0f));
        float f4 = 0.0f;
        do {
            f3 = f4 + pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
            f4 = f3;
        } while (pathMeasure.nextContour());
        object = new PathMeasure(object, false);
        int n2 = Math.min(100, (int)(f3 / f2) + 1);
        float[] arrf = new float[n2];
        float[] arrf2 = new float[n2];
        float[] arrf3 = new float[2];
        f4 = f3 / (float)(n2 - 1);
        int n3 = 0;
        f2 = 0.0f;
        int n4 = 0;
        do {
            pathMeasure = null;
            if (n3 >= n2) break;
            object.getPosTan(f2 - ((Float)arrayList.get(n4)).floatValue(), arrf3, null);
            arrf[n3] = arrf3[0];
            arrf2[n3] = arrf3[1];
            f2 += f4;
            int n5 = n4 + 1;
            int n6 = n4;
            if (n5 < arrayList.size()) {
                n6 = n4;
                if (f2 > ((Float)arrayList.get(n5)).floatValue()) {
                    object.nextContour();
                    n6 = n5;
                }
            }
            ++n3;
            n4 = n6;
        } while (true);
        object = string2 != null ? PropertyValuesHolder.ofFloat((String)string2, (float[])arrf) : null;
        string2 = pathMeasure;
        if (string3 != null) {
            string2 = PropertyValuesHolder.ofFloat((String)string3, (float[])arrf2);
        }
        if (object == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{string2});
            return;
        }
        if (string2 == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{object});
            return;
        }
        objectAnimator.setValues(new PropertyValuesHolder[]{object, string2});
    }

    private static void a(Keyframe[] arrkeyframe, float f2, int n2, int n3) {
        f2 /= (float)(n3 - n2 + 2);
        while (n2 <= n3) {
            arrkeyframe[n2].setFraction(arrkeyframe[n2 - 1].getFraction() + f2);
            ++n2;
        }
    }

    private static boolean a(int n2) {
        return n2 >= 28 && n2 <= 31;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static PropertyValuesHolder[] a(Context arrpropertyValuesHolder, Resources arrpropertyValuesHolder2, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int n2;
        int n3;
        Object var10_5 = null;
        ArrayList arrayList = null;
        do {
            n3 = xmlPullParser.getEventType();
            n2 = 0;
            if (n3 == 3 || n3 == 1) break;
            if (n3 == 2 && xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray typedArray = g.a((Resources)arrpropertyValuesHolder2, theme, attributeSet, androidx.k.a.a.a.i);
                String string2 = g.a(typedArray, xmlPullParser, "propertyName", 3);
                n2 = g.a(typedArray, xmlPullParser, "valueType", 2, 4);
                Object object = e.a((Context)arrpropertyValuesHolder, (Resources)arrpropertyValuesHolder2, theme, xmlPullParser, string2, n2);
                PropertyValuesHolder propertyValuesHolder = object;
                if (object == null) {
                    propertyValuesHolder = e.a(typedArray, n2, 0, 1, string2);
                }
                object = arrayList;
                if (propertyValuesHolder != null) {
                    object = arrayList;
                    if (arrayList == null) {
                        object = new ArrayList();
                    }
                    ((ArrayList)object).add(propertyValuesHolder);
                }
                typedArray.recycle();
                arrayList = object;
            }
            xmlPullParser.next();
        } while (true);
        arrpropertyValuesHolder = var10_5;
        if (arrayList != null) {
            n3 = arrayList.size();
            arrpropertyValuesHolder2 = new PropertyValuesHolder[n3];
            do {
                arrpropertyValuesHolder = arrpropertyValuesHolder2;
                if (n2 >= n3) break;
                arrpropertyValuesHolder2[n2] = (PropertyValuesHolder)arrayList.get(n2);
                ++n2;
            } while (true);
        }
        return arrpropertyValuesHolder;
    }

    private static class a
    implements TypeEvaluator<b.b[]> {
        private b.b[] a;

        a() {
        }

        public b.b[] a(float f2, b.b[] arrb, b.b[] arrb2) {
            if (b.a(arrb, arrb2)) {
                if (this.a == null || !b.a(this.a, arrb)) {
                    this.a = b.a(arrb);
                }
                for (int i2 = 0; i2 < arrb.length; ++i2) {
                    this.a[i2].a(arrb[i2], arrb2[i2], f2);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
            return this.a(f2, (b.b[])object, (b.b[])object2);
        }
    }

}

