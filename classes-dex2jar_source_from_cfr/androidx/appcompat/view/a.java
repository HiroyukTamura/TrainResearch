/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import androidx.appcompat.a;

public class a {
    private Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int a() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int n2 = configuration.screenWidthDp;
        int n3 = configuration.screenHeightDp;
        if (!(configuration.smallestScreenWidthDp > 600 || n2 > 600 || n2 > 960 && n3 > 720 || n2 > 720 && n3 > 960)) {
            if (!(n2 >= 500 || n2 > 640 && n3 > 480 || n2 > 480 && n3 > 640)) {
                if (n2 >= 360) {
                    return 3;
                }
                return 2;
            }
            return 4;
        }
        return 5;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return ViewConfiguration.get((Context)this.a).hasPermanentMenuKey() ^ true;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray typedArray = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
        int n2 = typedArray.getLayoutDimension(a.j.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        int n3 = n2;
        if (!this.d()) {
            n3 = Math.min(n2, resources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
        }
        typedArray.recycle();
        return n3;
    }

    public boolean f() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    }
}

