// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import java.io.File;
import android.os.Build$VERSION;

final class zzbs
{
    private static int version() {
        try {
            return Integer.parseInt(Build$VERSION.SDK);
        }
        catch (NumberFormatException ex) {
            final String value = String.valueOf(Build$VERSION.SDK);
            String concat;
            if (value.length() != 0) {
                concat = "Invalid version number: ".concat(value);
            }
            else {
                concat = new String("Invalid version number: ");
            }
            zzdj.e(concat);
            return 0;
        }
    }
    
    @TargetApi(9)
    static boolean zzfk(final String pathname) {
        if (version() < 9) {
            return false;
        }
        final File file = new File(pathname);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
