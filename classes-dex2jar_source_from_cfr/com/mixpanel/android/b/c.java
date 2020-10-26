/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.mixpanel.android.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.mixpanel.android.c.f;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import java.util.List;

class c {
    public static String a = "MixpanelAPI.ConfigurationChecker";
    private static Boolean b;

    public static boolean a(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        if (packageManager != null && object != null) {
            if (packageManager.checkPermission("android.permission.INTERNET", (String)object) != 0) {
                f.d(a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
                f.c(a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                return false;
            }
            return true;
        }
        f.d(a, "Can't check configuration when using a Context with null packageManager or packageName");
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean b(Context var0) {
        if (c.b != null) return c.b;
        if (Build.VERSION.SDK_INT < 16) ** GOTO lbl13
        var1_6 = new Intent(var0 /* !! */ , TakeoverInAppActivity.class);
        var1_6.addFlags(268435456);
        var1_6.addFlags(131072);
        if (var0 /* !! */ .getPackageManager().queryIntentActivities((Intent)var1_6, 0).size() == 0) {
            var0_4 = c.a;
            var1_6 = new StringBuilder();
            var1_6.append(TakeoverInAppActivity.class.getName());
            var1_6.append(" is not registered as an activity in your application, so takeover in-apps can't be shown.");
            f.d(var0_4, var1_6.toString());
            f.c(c.a, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag.");
lbl13: // 2 sources:
            var0_2 = false;
        } else {
            var0_5 = true;
        }
        c.b = var0_3;
        return c.b;
    }
}

