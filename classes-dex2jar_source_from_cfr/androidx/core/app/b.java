/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

public final class b {
    public static int a(Context context, String string2, String string3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager)context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(string2, string3);
        }
        return 1;
    }

    public static String a(String string2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp((String)string2);
        }
        return null;
    }
}

