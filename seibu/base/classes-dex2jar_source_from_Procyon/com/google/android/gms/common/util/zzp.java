// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.Iterator;
import java.util.HashMap;

public final class zzp
{
    public static void zza(final StringBuilder sb, final HashMap<String, String> hashMap) {
        sb.append("{");
        final Iterator<String> iterator = hashMap.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (n == 0) {
                sb.append(",");
            }
            else {
                n = 0;
            }
            final String str = hashMap.get(s);
            sb.append("\"").append(s).append("\":");
            if (str == null) {
                sb.append("null");
            }
            else {
                sb.append("\"").append(str).append("\"");
            }
        }
        sb.append("}");
    }
}
