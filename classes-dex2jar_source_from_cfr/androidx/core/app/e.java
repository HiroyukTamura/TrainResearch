/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public final class e {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Intent a(Activity activity) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 16 && (intent = activity.getParentActivityIntent()) != null) {
            return intent;
        }
        String string2 = e.b(activity);
        if (string2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName((Context)activity, string2);
        try {
            if (e.b((Context)activity, componentName) != null) return new Intent().setComponent(componentName);
            return Intent.makeMainActivity((ComponentName)componentName);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getParentActivityIntent: bad parentActivityName '");
        stringBuilder.append(string2);
        stringBuilder.append("' in manifest");
        Log.e((String)"NavUtils", (String)stringBuilder.toString());
        return null;
    }

    public static Intent a(Context context, ComponentName componentName) {
        String string2 = e.b(context, componentName);
        if (string2 == null) {
            return null;
        }
        if (e.b(context, componentName = new ComponentName(componentName.getPackageName(), string2)) == null) {
            return Intent.makeMainActivity((ComponentName)componentName);
        }
        return new Intent().setComponent(componentName);
    }

    public static boolean a(Activity object, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return object.shouldUpRecreateTask(intent);
        }
        return (object = object.getIntent().getAction()) != null && !((String)object).equals("android.intent.action.MAIN");
    }

    public static String b(Activity object) {
        try {
            object = e.b((Context)object, object.getComponentName());
            return object;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new IllegalArgumentException((Throwable)nameNotFoundException);
        }
    }

    public static String b(Context context, ComponentName object) {
        String string2;
        object = context.getPackageManager().getActivityInfo((ComponentName)object, 128);
        if (Build.VERSION.SDK_INT >= 16 && (string2 = ((ActivityInfo)object).parentActivityName) != null) {
            return string2;
        }
        if (((ActivityInfo)object).metaData == null) {
            return null;
        }
        string2 = ((ActivityInfo)object).metaData.getString("android.support.PARENT_ACTIVITY");
        if (string2 == null) {
            return null;
        }
        object = string2;
        if (string2.charAt(0) == '.') {
            object = new StringBuilder();
            ((StringBuilder)object).append(context.getPackageName());
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }

    public static void b(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }
}

