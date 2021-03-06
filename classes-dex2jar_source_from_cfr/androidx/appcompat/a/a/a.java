/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.i;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
    private static final Object c = new Object();

    public static ColorStateList a(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(n2);
        }
        ColorStateList colorStateList = a.d(context, n2);
        if (colorStateList != null) {
            return colorStateList;
        }
        colorStateList = a.c(context, n2);
        if (colorStateList != null) {
            a.a(context, n2, colorStateList);
            return colorStateList;
        }
        return androidx.core.a.a.b(context, n2);
    }

    private static TypedValue a() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = a.get();
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            a.set(typedValue2);
        }
        return typedValue2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(Context context, int n2, ColorStateList colorStateList) {
        Object object = c;
        synchronized (object) {
            SparseArray sparseArray;
            SparseArray sparseArray2 = sparseArray = b.get((Object)context);
            if (sparseArray == null) {
                sparseArray2 = new SparseArray();
                b.put(context, (SparseArray<a>)sparseArray2);
            }
            sparseArray2.append(n2, (Object)new a(colorStateList, context.getResources().getConfiguration()));
            return;
        }
    }

    public static Drawable b(Context context, int n2) {
        return i.a().a(context, n2);
    }

    private static ColorStateList c(Context context, int n2) {
        if (a.e(context, n2)) {
            return null;
        }
        Resources resources = context.getResources();
        XmlResourceParser xmlResourceParser = resources.getXml(n2);
        try {
            context = androidx.core.a.a.a.a(resources, (XmlPullParser)xmlResourceParser, context.getTheme());
            return context;
        }
        catch (Exception exception) {
            Log.e((String)"AppCompatResources", (String)"Failed to inflate ColorStateList, leaving it to the framework", (Throwable)exception);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ColorStateList d(Context context, int n2) {
        Object object = c;
        synchronized (object) {
            SparseArray<a> sparseArray = b.get((Object)context);
            if (sparseArray == null) return null;
            if (sparseArray.size() <= 0) return null;
            a a2 = (a)sparseArray.get(n2);
            if (a2 == null) return null;
            if (a2.b.equals(context.getResources().getConfiguration())) {
                return a2.a;
            }
            sparseArray.remove(n2);
            return null;
        }
    }

    private static boolean e(Context context, int n2) {
        context = context.getResources();
        TypedValue typedValue = a.a();
        context.getValue(n2, typedValue, true);
        return typedValue.type >= 28 && typedValue.type <= 31;
    }

    private static class a {
        final ColorStateList a;
        final Configuration b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.b = configuration;
        }
    }

}

