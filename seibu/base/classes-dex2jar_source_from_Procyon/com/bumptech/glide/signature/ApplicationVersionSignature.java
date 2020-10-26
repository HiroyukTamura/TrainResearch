// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.signature;

import android.content.pm.PackageInfo;
import java.util.UUID;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;
import com.bumptech.glide.load.Key;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationVersionSignature
{
    private static final ConcurrentHashMap<String, Key> PACKAGE_NAME_TO_KEY;
    
    static {
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap<String, Key>();
    }
    
    private ApplicationVersionSignature() {
    }
    
    public static Key obtain(final Context context) {
        final String packageName = context.getPackageName();
        Key key;
        if ((key = ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.get(packageName)) == null) {
            final Key obtainVersionSignature = obtainVersionSignature(context);
            if ((key = ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.putIfAbsent(packageName, obtainVersionSignature)) == null) {
                key = obtainVersionSignature;
            }
        }
        return key;
    }
    
    private static Key obtainVersionSignature(final Context context) {
    Label_0027_Outer:
        while (true) {
            final PackageInfo packageInfo = null;
            while (true) {
                while (true) {
                    try {
                        final PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        if (packageInfo2 != null) {
                            final String s = String.valueOf(packageInfo2.versionCode);
                            return new StringSignature(s);
                        }
                    }
                    catch (PackageManager$NameNotFoundException ex) {
                        ex.printStackTrace();
                        final PackageInfo packageInfo2 = packageInfo;
                        continue Label_0027_Outer;
                    }
                    break;
                }
                final String s = UUID.randomUUID().toString();
                continue;
            }
        }
    }
    
    static void reset() {
        ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.clear();
    }
}
