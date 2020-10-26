// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import android.net.Uri$Builder;
import android.util.LogPrinter;
import android.net.Uri;

public final class zzg implements zzo
{
    private static final Uri zzadO;
    private final LogPrinter zzadP;
    
    static {
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme("uri");
        uri$Builder.authority("local");
        zzadO = uri$Builder.build();
    }
    
    public zzg() {
        this.zzadP = new LogPrinter(4, "GA/LogCatTransport");
    }
    
    @Override
    public final void zzb(final zzi zzi) {
        final ArrayList<Object> list = new ArrayList<Object>(zzi.zzjq());
        Collections.sort(list, (Comparator<? super Object>)new zzh(this));
        final StringBuilder sb = new StringBuilder();
        final ArrayList<Object> list2 = list;
        int n;
        for (int size = list2.size(), i = 0; i < size; i = n) {
            final zzj<?> value = list2.get(i);
            n = i + 1;
            final String string = value.toString();
            i = n;
            if (!TextUtils.isEmpty((CharSequence)string)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(string);
            }
        }
        this.zzadP.println(sb.toString());
    }
    
    @Override
    public final Uri zzjl() {
        return zzg.zzadO;
    }
}
