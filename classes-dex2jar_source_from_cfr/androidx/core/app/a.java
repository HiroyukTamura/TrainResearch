/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class a
extends androidx.core.a.a {
    private static b a;

    public static b a() {
        return a;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
            return;
        }
        activity.finish();
    }

    public static void a(Activity activity, Intent intent, int n2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, n2, bundle);
            return;
        }
        activity.startActivityForResult(intent, n2);
    }

    public static void a(final Activity activity, final String[] arrstring, final int n2) {
        if (a != null && a.a(activity, arrstring, n2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c)activity).a(n2);
            }
            activity.requestPermissions(arrstring, n2);
            return;
        }
        if (activity instanceof a) {
            new Handler(Looper.getMainLooper()).post(new Runnable(){

                @Override
                public void run() {
                    int[] arrn = new int[arrstring.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String string2 = activity.getPackageName();
                    int n22 = arrstring.length;
                    for (int i2 = 0; i2 < n22; ++i2) {
                        arrn[i2] = packageManager.checkPermission(arrstring[i2], string2);
                    }
                    ((a)activity).onRequestPermissionsResult(n2, arrstring, arrn);
                }
            });
        }
    }

    public static boolean a(Activity activity, String string2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(string2);
        }
        return false;
    }

    public static interface a {
        public void onRequestPermissionsResult(int var1, String[] var2, int[] var3);
    }

    public static interface b {
        public boolean a(Activity var1, int var2, int var3, Intent var4);

        public boolean a(Activity var1, String[] var2, int var3);
    }

    public static interface c {
        public void a(int var1);
    }

}

