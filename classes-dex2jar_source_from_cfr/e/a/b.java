/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package e.a;

import android.content.Context;
import android.os.Build;
import androidx.c.g;
import androidx.f.a.d;

public final class b {
    private static final g<String, Integer> a = new g(8);

    static {
        a.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        a.put("android.permission.BODY_SENSORS", 20);
        a.put("android.permission.READ_CALL_LOG", 16);
        a.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        a.put("android.permission.USE_SIP", 9);
        a.put("android.permission.WRITE_CALL_LOG", 16);
        a.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        a.put("android.permission.WRITE_SETTINGS", 23);
    }

    private static boolean a(Context context, String string2) {
        boolean bl2 = false;
        try {
            int n2 = androidx.core.a.b.a(context, string2);
            if (n2 == 0) {
                bl2 = true;
            }
            return bl2;
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
    }

    public static /* varargs */ boolean a(Context context, String ... arrstring) {
        for (String string2 : arrstring) {
            if (!b.a(string2) || b.a(context, string2)) continue;
            return false;
        }
        return true;
    }

    public static /* varargs */ boolean a(d d2, String ... arrstring) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!d2.a(arrstring[i2])) continue;
            return true;
        }
        return false;
    }

    private static boolean a(String object) {
        return (object = a.get(object)) == null || Build.VERSION.SDK_INT >= (Integer)object;
        {
        }
    }

    public static /* varargs */ boolean a(int ... arrn) {
        if (arrn.length == 0) {
            return false;
        }
        int n2 = arrn.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }
}

