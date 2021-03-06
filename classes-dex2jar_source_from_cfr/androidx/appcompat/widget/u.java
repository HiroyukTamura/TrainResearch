/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class u {
    private static final RectF a = new RectF();
    private static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap();
    private int c = 0;
    private boolean d = false;
    private float e = -1.0f;
    private float f = -1.0f;
    private float g = -1.0f;
    private int[] h = new int[0];
    private boolean i = false;
    private TextPaint j;
    private final TextView k;
    private final Context l;

    u(TextView textView) {
        this.k = textView;
        this.l = this.k.getContext();
    }

    private int a(RectF rectF) {
        int n2 = this.h.length;
        if (n2 != 0) {
            int n3 = n2 - 1;
            n2 = 1;
            int n4 = 0;
            while (n2 <= n3) {
                int n5 = (n2 + n3) / 2;
                if (this.a(this.h[n5], rectF)) {
                    n4 = n2;
                    n2 = n5 + 1;
                    continue;
                }
                n3 = n4 = n5 - 1;
            }
            return this.h[n4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int n2) {
        float f2;
        boolean bl2;
        float f3;
        if (Build.VERSION.SDK_INT >= 16) {
            f2 = this.k.getLineSpacingMultiplier();
            f3 = this.k.getLineSpacingExtra();
            bl2 = this.k.getIncludeFontPadding();
        } else {
            f2 = this.a((Object)this.k, "getLineSpacingMultiplier", Float.valueOf(1.0f)).floatValue();
            f3 = this.a((Object)this.k, "getLineSpacingExtra", Float.valueOf(0.0f)).floatValue();
            bl2 = this.a((Object)this.k, "getIncludeFontPadding", true);
        }
        return new StaticLayout(charSequence, this.j, n2, alignment, f2, f3, bl2);
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int n2, int n3) {
        TextDirectionHeuristic textDirectionHeuristic = this.a((Object)this.k, "getTextDirectionHeuristic", (T)TextDirectionHeuristics.FIRSTSTRONG_LTR);
        charSequence = StaticLayout.Builder.obtain((CharSequence)charSequence, (int)0, (int)charSequence.length(), (TextPaint)this.j, (int)n2).setAlignment(alignment).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
        n2 = n3;
        if (n3 == -1) {
            n2 = Integer.MAX_VALUE;
        }
        return charSequence.setMaxLines(n2).setTextDirection(textDirectionHeuristic).build();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private <T> T a(Object object, String string2, T t2) {
        try {
            object = this.a(string2).invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke TextView#");
            stringBuilder.append(string2);
            stringBuilder.append("() method");
            Log.w((String)"ACTVAutoSizeHelper", (String)stringBuilder.toString(), (Throwable)exception);
            return t2;
        }
        return (T)object;
    }

    private Method a(String string2) {
        Object object;
        block4 : {
            Object object2;
            try {
                object = object2 = b.get(string2);
                if (object2 != null) break block4;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Failed to retrieve TextView#");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append("() method");
                Log.w((String)"ACTVAutoSizeHelper", (String)((StringBuilder)object2).toString(), (Throwable)exception);
                return null;
            }
            object = object2 = TextView.class.getDeclaredMethod(string2, new Class[0]);
            if (object2 == null) break block4;
            ((AccessibleObject)object2).setAccessible(true);
            b.put(string2, (Method)object2);
            object = object2;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(float f2) {
        if (f2 != this.k.getPaint().getTextSize()) {
            this.k.getPaint().setTextSize(f2);
            boolean bl2 = Build.VERSION.SDK_INT >= 18 ? this.k.isInLayout() : false;
            if (this.k.getLayout() != null) {
                this.d = false;
                try {
                    Method method = this.a("nullLayouts");
                    if (method != null) {
                        method.invoke((Object)this.k, new Object[0]);
                    }
                }
                catch (Exception exception) {
                    Log.w((String)"ACTVAutoSizeHelper", (String)"Failed to invoke TextView#nullLayouts() method", (Throwable)exception);
                }
                if (!bl2) {
                    this.k.requestLayout();
                } else {
                    this.k.forceLayout();
                }
                this.k.invalidate();
            }
        }
    }

    private void a(float f2, float f3, float f4) {
        if (!(f2 <= 0.0f)) {
            if (!(f3 <= f2)) {
                if (!(f4 <= 0.0f)) {
                    this.c = 1;
                    this.f = f2;
                    this.g = f3;
                    this.e = f4;
                    this.i = false;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The auto-size step granularity (");
                stringBuilder.append(f4);
                stringBuilder.append("px) is less or equal to (0px)");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Maximum auto-size text size (");
            stringBuilder.append(f3);
            stringBuilder.append("px) is less or equal to minimum auto-size ");
            stringBuilder.append("text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Minimum auto-size text size (");
        stringBuilder.append(f2);
        stringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void a(TypedArray typedArray) {
        int n2 = typedArray.length();
        int[] arrn = new int[n2];
        if (n2 > 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                arrn[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.h = this.a(arrn);
            this.h();
        }
    }

    private boolean a(int n2, RectF rectF) {
        CharSequence charSequence = this.k.getText();
        Object object = this.k.getTransformationMethod();
        CharSequence charSequence2 = charSequence;
        if (object != null) {
            object = object.getTransformation(charSequence, (View)this.k);
            charSequence2 = charSequence;
            if (object != null) {
                charSequence2 = object;
            }
        }
        int n3 = Build.VERSION.SDK_INT >= 16 ? this.k.getMaxLines() : -1;
        if (this.j == null) {
            this.j = new TextPaint();
        } else {
            this.j.reset();
        }
        this.j.set(this.k.getPaint());
        this.j.setTextSize((float)n2);
        charSequence = this.a((Object)this.k, "getLayoutAlignment", (T)Layout.Alignment.ALIGN_NORMAL);
        charSequence = Build.VERSION.SDK_INT >= 23 ? this.a(charSequence2, (Layout.Alignment)charSequence, Math.round(rectF.right), n3) : this.a(charSequence2, (Layout.Alignment)charSequence, Math.round(rectF.right));
        if (n3 != -1 && (charSequence.getLineCount() > n3 || charSequence.getLineEnd(charSequence.getLineCount() - 1) != charSequence2.length())) {
            return false;
        }
        return !((float)charSequence.getHeight() > rectF.bottom);
    }

    private int[] a(int[] arrn) {
        int n2;
        int n3 = arrn.length;
        if (n3 == 0) {
            return arrn;
        }
        Arrays.sort(arrn);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            int n5 = arrn[n2];
            if (n5 <= 0 || Collections.binarySearch(arrayList, n5) >= 0) continue;
            arrayList.add(n5);
        }
        if (n3 == arrayList.size()) {
            return arrn;
        }
        n3 = arrayList.size();
        arrn = new int[n3];
        for (n2 = n4; n2 < n3; ++n2) {
            arrn[n2] = (Integer)arrayList.get(n2);
        }
        return arrn;
    }

    private boolean h() {
        int n2 = this.h.length;
        boolean bl2 = n2 > 0;
        this.i = bl2;
        if (this.i) {
            this.c = 1;
            this.f = this.h[0];
            this.g = this.h[n2 - 1];
            this.e = -1.0f;
        }
        return this.i;
    }

    private boolean i() {
        boolean bl2 = this.k();
        int n2 = 0;
        if (bl2 && this.c == 1) {
            if (!this.i || this.h.length == 0) {
                float f2 = Math.round(this.f);
                int n3 = 1;
                while (Math.round(this.e + f2) <= Math.round(this.g)) {
                    ++n3;
                    f2 += this.e;
                }
                int[] arrn = new int[n3];
                f2 = this.f;
                while (n2 < n3) {
                    arrn[n2] = Math.round(f2);
                    f2 += this.e;
                    ++n2;
                }
                this.h = this.a(arrn);
            }
            this.d = true;
        } else {
            this.d = false;
        }
        return this.d;
    }

    private void j() {
        this.c = 0;
        this.f = -1.0f;
        this.g = -1.0f;
        this.e = -1.0f;
        this.h = new int[0];
        this.d = false;
    }

    private boolean k() {
        return !(this.k instanceof AppCompatEditText);
    }

    int a() {
        return this.c;
    }

    void a(int n2) {
        if (this.k()) {
            switch (n2) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown auto-size text type: ");
                    stringBuilder.append(n2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                case 1: {
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    this.a(TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)displayMetrics), 1.0f);
                    if (!this.i()) break;
                    this.f();
                    return;
                }
                case 0: {
                    this.j();
                }
            }
        }
    }

    void a(int n2, float f2) {
        Resources resources = this.l == null ? Resources.getSystem() : this.l.getResources();
        this.a(TypedValue.applyDimension((int)n2, (float)f2, (DisplayMetrics)resources.getDisplayMetrics()));
    }

    void a(int n2, int n3, int n4, int n5) {
        if (this.k()) {
            DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
            this.a(TypedValue.applyDimension((int)n5, (float)n2, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n5, (float)n3, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n5, (float)n4, (DisplayMetrics)displayMetrics));
            if (this.i()) {
                this.f();
            }
        }
    }

    void a(AttributeSet attributeSet, int n2) {
        if ((attributeSet = this.l.obtainStyledAttributes(attributeSet, a.j.AppCompatTextView, n2, 0)).hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
            this.c = attributeSet.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float f2 = attributeSet.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity) ? attributeSet.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float f3 = attributeSet.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize) ? attributeSet.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float f4 = attributeSet.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize) ? attributeSet.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (attributeSet.hasValue(a.j.AppCompatTextView_autoSizePresetSizes) && (n2 = attributeSet.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArray = attributeSet.getResources().obtainTypedArray(n2);
            this.a(typedArray);
            typedArray.recycle();
        }
        attributeSet.recycle();
        if (this.k()) {
            if (this.c == 1) {
                if (!this.i) {
                    attributeSet = this.l.getResources().getDisplayMetrics();
                    float f5 = f3;
                    if (f3 == -1.0f) {
                        f5 = TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)attributeSet);
                    }
                    f3 = f4;
                    if (f4 == -1.0f) {
                        f3 = TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)attributeSet);
                    }
                    f4 = f2;
                    if (f2 == -1.0f) {
                        f4 = 1.0f;
                    }
                    this.a(f5, f3, f4);
                }
                this.i();
                return;
            }
        } else {
            this.c = 0;
        }
    }

    void a(int[] arrn, int n2) {
        if (this.k()) {
            int n3 = arrn.length;
            int n4 = 0;
            if (n3 > 0) {
                Object object;
                int[] arrn2 = new int[n3];
                if (n2 == 0) {
                    object = Arrays.copyOf(arrn, n3);
                } else {
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    do {
                        object = arrn2;
                        if (n4 >= n3) break;
                        arrn2[n4] = Math.round(TypedValue.applyDimension((int)n2, (float)arrn[n4], (DisplayMetrics)displayMetrics));
                        ++n4;
                    } while (true);
                }
                this.h = this.a((int[])object);
                if (!this.h()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("None of the preset sizes is valid: ");
                    ((StringBuilder)object).append(Arrays.toString(arrn));
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
            } else {
                this.i = false;
            }
            if (this.i()) {
                this.f();
            }
        }
    }

    int b() {
        return Math.round(this.e);
    }

    int c() {
        return Math.round(this.f);
    }

    int d() {
        return Math.round(this.g);
    }

    int[] e() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void f() {
        if (!this.g()) {
            return;
        }
        if (this.d) {
            if (this.k.getMeasuredHeight() <= 0) return;
            if (this.k.getMeasuredWidth() <= 0) {
                return;
            }
            int n2 = this.a((Object)this.k, "getHorizontallyScrolling", false) != false ? 1048576 : this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft() - this.k.getTotalPaddingRight();
            int n3 = this.k.getHeight() - this.k.getCompoundPaddingBottom() - this.k.getCompoundPaddingTop();
            if (n2 <= 0) return;
            if (n3 <= 0) {
                return;
            }
            RectF rectF = a;
            // MONITORENTER : rectF
            a.setEmpty();
            u.a.right = n2;
            u.a.bottom = n3;
            float f2 = this.a(a);
            if (f2 != this.k.getTextSize()) {
                this.a(0, f2);
            }
            // MONITOREXIT : rectF
        }
        this.d = true;
    }

    boolean g() {
        return this.k() && this.c != 0;
    }
}

