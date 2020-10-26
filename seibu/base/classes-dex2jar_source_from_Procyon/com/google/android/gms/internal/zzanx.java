// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Collections;
import com.google.android.gms.common.internal.zzbo;
import java.util.List;
import java.util.Map;

public final class zzanx
{
    private final Map<String, String> zzHa;
    private final List<zzane> zzaib;
    private final long zzaic;
    private final long zzaid;
    private final int zzaie;
    private final boolean zzaif;
    private final String zzaig;
    
    public zzanx(final zzamg zzamg, final Map<String, String> map, final long n, final boolean b) {
        this(zzamg, map, n, b, 0L, 0, null);
    }
    
    public zzanx(final zzamg zzamg, final Map<String, String> map, final long n, final boolean b, final long n2, final int n3) {
        this(zzamg, map, n, b, n2, n3, null);
    }
    
    public zzanx(final zzamg zzamg, final Map<String, String> map, final long zzaid, final boolean zzaif, final long zzaic, final int zzaie, final List<zzane> list) {
        zzbo.zzu(zzamg);
        zzbo.zzu(map);
        this.zzaid = zzaid;
        this.zzaif = zzaif;
        this.zzaic = zzaic;
        this.zzaie = zzaie;
        List<zzane> emptyList;
        if (list != null) {
            emptyList = list;
        }
        else {
            emptyList = Collections.emptyList();
        }
        this.zzaib = emptyList;
        this.zzaig = zzt(list);
        final HashMap<String, String> m = new HashMap<String, String>();
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            if (zzj(entry.getKey())) {
                final String zza = zza(zzamg, entry.getKey());
                if (zza == null) {
                    continue;
                }
                m.put(zza, zzb(zzamg, entry.getValue()));
            }
        }
        for (final Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey())) {
                final String zza2 = zza(zzamg, entry2.getKey());
                if (zza2 == null) {
                    continue;
                }
                m.put(zza2, zzb(zzamg, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.zzaig)) {
            zzaos.zzb(m, "_v", this.zzaig);
            if (this.zzaig.equals("ma4.0.0") || this.zzaig.equals("ma4.0.1")) {
                m.remove("adid");
            }
        }
        this.zzHa = (Map<String, String>)Collections.unmodifiableMap((Map<?, ?>)m);
    }
    
    private static String zza(final zzamg zzamg, final Object o) {
        String s;
        if (o == null) {
            s = null;
        }
        else {
            String s3;
            final String s2 = s3 = o.toString();
            if (s2.startsWith("&")) {
                s3 = s2.substring(1);
            }
            final int length = s3.length();
            String substring = s3;
            if (length > 256) {
                substring = s3.substring(0, 256);
                zzamg.zzc("Hit param name is too long and will be trimmed", length, substring);
            }
            s = substring;
            if (TextUtils.isEmpty((CharSequence)substring)) {
                return null;
            }
        }
        return s;
    }
    
    private static String zzb(final zzamg zzamg, final Object o) {
        String string;
        if (o == null) {
            string = "";
        }
        else {
            string = o.toString();
        }
        final int length = string.length();
        String substring = string;
        if (length > 8192) {
            substring = string.substring(0, 8192);
            zzamg.zzc("Hit param value is too long and will be trimmed", length, substring);
        }
        return substring;
    }
    
    private static boolean zzj(final Object o) {
        return o != null && o.toString().startsWith("&");
    }
    
    private final String zzn(String s, final String s2) {
        zzbo.zzcF(s);
        zzbo.zzb(!s.startsWith("&"), (Object)"Short param name required");
        s = this.zzHa.get(s);
        if (s != null) {
            return s;
        }
        return s2;
    }
    
    private static String zzt(final List<zzane> list) {
    Label_0047:
        while (true) {
            if (list != null) {
                for (final zzane zzane : list) {
                    if ("appendVersion".equals(zzane.getId())) {
                        final String value = zzane.getValue();
                        break Label_0047;
                    }
                }
            }
            Label_0058: {
                break Label_0058;
                final String value;
                if (TextUtils.isEmpty((CharSequence)value)) {
                    return null;
                }
                return value;
            }
            final String value = null;
            continue Label_0047;
        }
    }
    
    @Override
    public final String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("ht=").append(this.zzaid);
        if (this.zzaic != 0L) {
            sb.append(", dbId=").append(this.zzaic);
        }
        if (this.zzaie != 0) {
            sb.append(", appUID=").append(this.zzaie);
        }
        final ArrayList<Comparable> list = new ArrayList<Comparable>(this.zzHa.keySet());
        Collections.sort(list);
        final ArrayList<Comparable> list2 = list;
        final int size = list2.size();
        int i = 0;
        while (i < size) {
            final String value = list2.get(i);
            ++i;
            final String str = value;
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append(this.zzHa.get(str));
        }
        return sb.toString();
    }
    
    public final Map<String, String> zzdV() {
        return this.zzHa;
    }
    
    public final int zzlE() {
        return this.zzaie;
    }
    
    public final long zzlF() {
        return this.zzaic;
    }
    
    public final long zzlG() {
        return this.zzaid;
    }
    
    public final List<zzane> zzlH() {
        return this.zzaib;
    }
    
    public final boolean zzlI() {
        return this.zzaif;
    }
    
    public final long zzlJ() {
        return zzaos.zzbC(this.zzn("_s", "0"));
    }
    
    public final String zzlK() {
        return this.zzn("_m", "");
    }
}
