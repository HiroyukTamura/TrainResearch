// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.util.Log;
import android.annotation.TargetApi;
import java.io.File;
import android.content.Context;

public final class zzu
{
    @TargetApi(21)
    public static File getNoBackupFilesDir(final Context context) {
        if (zzq.zzse()) {
            return context.getNoBackupFilesDir();
        }
        return zzd(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
    
    private static File zzd(final File file) {
        // monitorenter(zzu.class)
        File file2 = file;
        try {
            if (!file.exists()) {
                file2 = file;
                if (!file.mkdirs()) {
                    if (file.exists()) {
                        file2 = file;
                    }
                    else {
                        final String value = String.valueOf(file.getPath());
                        String concat;
                        if (value.length() != 0) {
                            concat = "Unable to create no-backup dir ".concat(value);
                        }
                        else {
                            concat = new String("Unable to create no-backup dir ");
                        }
                        Log.w("SupportV4Utils", concat);
                        file2 = null;
                    }
                }
            }
            return file2;
        }
        finally {
        }
        // monitorexit(zzu.class)
    }
}
