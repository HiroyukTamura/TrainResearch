/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.i;
import java.lang.ref.WeakReference;

public class at
extends Resources {
    private static boolean a = false;
    private final WeakReference<Context> b;

    public at(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.b = new WeakReference<Context>(context);
    }

    public static void a(boolean bl2) {
        a = bl2;
    }

    public static boolean a() {
        return at.b() && Build.VERSION.SDK_INT <= 20;
    }

    public static boolean b() {
        return a;
    }

    final Drawable a(int n2) {
        return super.getDrawable(n2);
    }

    public Drawable getDrawable(int n2) {
        Context context = (Context)this.b.get();
        if (context != null) {
            return i.a().a(context, this, n2);
        }
        return super.getDrawable(n2);
    }
}

