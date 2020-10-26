/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Process
 */
package androidx.core.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

public final class b {
    public static int a(Context context, String string2) {
        return b.a(context, string2, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int a(Context context, String object, int n2, int n3, String string2) {
        if (context.checkPermission((String)object, n2, n3) == -1) {
            return -1;
        }
        String string3 = androidx.core.app.b.a((String)object);
        if (string3 == null) {
            return 0;
        }
        object = string2;
        if (string2 == null) {
            object = context.getPackageManager().getPackagesForUid(n3);
            if (object != null) {
                if (((String[])object).length <= 0) {
                    return -1;
                }
                object = object[0];
            } else {
                return -1;
            }
        }
        if (androidx.core.app.b.a(context, string3, (String)object) != 0) {
            return -2;
        }
        return 0;
    }
}

