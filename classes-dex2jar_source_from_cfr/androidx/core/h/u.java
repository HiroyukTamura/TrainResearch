/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ViewConfiguration
 */
package androidx.core.h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class u {
    private static Method a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
                return;
            }
            catch (Exception exception) {}
            Log.i((String)"ViewConfigCompat", (String)"Could not find method getScaledScrollFactor() on ViewConfiguration");
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return u.d(viewConfiguration, context);
    }

    public static int a(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return u.d(viewConfiguration, context);
    }

    public static boolean c(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        viewConfiguration = context.getResources();
        int n2 = viewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return n2 != 0 && viewConfiguration.getBoolean(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static float d(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 25 && a != null) {
            int n2;
            try {
                n2 = (Integer)a.invoke((Object)viewConfiguration, new Object[0]);
            }
            catch (Exception exception) {}
            return n2;
            Log.i((String)"ViewConfigCompat", (String)"Could not find method getScaledScrollFactor() on ViewConfiguration");
        }
        viewConfiguration = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, (TypedValue)viewConfiguration, true)) {
            return viewConfiguration.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }
}

