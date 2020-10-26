// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class zzk
{
    private static final Object zzuF;
    private final zzr zzckH;
    
    static {
        zzuF = new Object();
    }
    
    zzk(final zzr zzckH) {
        this.zzckH = zzckH;
    }
    
    @Nullable
    final String zzJV() {
        synchronized (zzk.zzuF) {
            final String string = this.zzckH.zzbho.getString("topic_operaion_queue", (String)null);
            if (string != null) {
                final String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty((CharSequence)split[1])) {
                    return split[1];
                }
            }
            return null;
        }
    }
    
    final void zzhf(String string) {
        synchronized (zzk.zzuF) {
            final String string2 = this.zzckH.zzbho.getString("topic_operaion_queue", "");
            final String value = String.valueOf(",");
            string = new StringBuilder(String.valueOf(string2).length() + String.valueOf(value).length() + String.valueOf(string).length()).append(string2).append(value).append(string).toString();
            this.zzckH.zzbho.edit().putString("topic_operaion_queue", string).apply();
        }
    }
    
    final boolean zzhj(String str) {
        while (true) {
            while (true) {
                String original;
                synchronized (zzk.zzuF) {
                    final String string = this.zzckH.zzbho.getString("topic_operaion_queue", "");
                    original = String.valueOf(",");
                    final String value = String.valueOf(str);
                    if (value.length() != 0) {
                        original = original.concat(value);
                    }
                    else {
                        original = new String(original);
                    }
                    if (!string.startsWith(original)) {
                        break;
                    }
                    original = String.valueOf(",");
                    str = String.valueOf(str);
                    if (str.length() != 0) {
                        str = original.concat(str);
                        str = string.substring(str.length());
                        this.zzckH.zzbho.edit().putString("topic_operaion_queue", str).apply();
                        return true;
                    }
                }
                str = new String(original);
                continue;
            }
        }
        // monitorexit(o)
        return false;
    }
}
