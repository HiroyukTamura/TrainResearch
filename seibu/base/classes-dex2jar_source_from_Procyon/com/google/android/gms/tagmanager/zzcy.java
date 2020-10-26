// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzcy extends zzbr
{
    private static final String ID;
    private static final String zzbEH;
    private static final String zzbEZ;
    private static final String zzbFa;
    private static final String zzbFb;
    
    static {
        ID = zzbf.zzdZ.toString();
        zzbEH = zzbg.zzfR.toString();
        zzbEZ = zzbg.zzhW.toString();
        zzbFa = zzbg.zzia.toString();
        zzbFb = zzbg.zzhq.toString();
    }
    
    public zzcy() {
        super(zzcy.ID, new String[] { zzcy.zzbEH });
    }
    
    private static String zza(String s, final Integer n, final Set<Character> set) {
        switch (zzcz.zzbFc[n - 1]) {
            default: {
                return s;
            }
            case 1: {
                try {
                    return zzgo.zzfC(s);
                }
                catch (UnsupportedEncodingException ex) {
                    zzdj.zzb("Joiner: unsupported encoding", ex);
                    return s;
                }
            }
            case 2: {
                s = s.replace("\\", "\\\\");
                final Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    final String string = iterator.next().toString();
                    final String value = String.valueOf(string);
                    String concat;
                    if (value.length() != 0) {
                        concat = "\\".concat(value);
                    }
                    else {
                        concat = new String("\\");
                    }
                    s = s.replace(string, concat);
                }
                return s;
            }
        }
    }
    
    private static void zza(final StringBuilder sb, final String s, final Integer n, final Set<Character> set) {
        sb.append(zza(s, (int)n, (Set)set));
    }
    
    private static void zza(final Set<Character> set, final String s) {
        for (int i = 0; i < s.length(); ++i) {
            set.add(s.charAt(i));
        }
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzcy.zzbEH);
        if (zzbr == null) {
            return zzgk.zzCh();
        }
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzcy.zzbEZ);
        String zzb;
        if (zzbr2 != null) {
            zzb = zzgk.zzb(zzbr2);
        }
        else {
            zzb = "";
        }
        final com.google.android.gms.internal.zzbr zzbr3 = map.get(zzcy.zzbFa);
        String zzb2;
        if (zzbr3 != null) {
            zzb2 = zzgk.zzb(zzbr3);
        }
        else {
            zzb2 = "=";
        }
        int n = zzda.zzbFd;
        final com.google.android.gms.internal.zzbr zzbr4 = map.get(zzcy.zzbFb);
        Set<Character> set;
        if (zzbr4 != null) {
            final String zzb3 = zzgk.zzb(zzbr4);
            if ("url".equals(zzb3)) {
                n = zzda.zzbFe;
                set = null;
            }
            else {
                if (!"backslash".equals(zzb3)) {
                    final String value = String.valueOf(zzb3);
                    String concat;
                    if (value.length() != 0) {
                        concat = "Joiner: unsupported escape type: ".concat(value);
                    }
                    else {
                        concat = new String("Joiner: unsupported escape type: ");
                    }
                    zzdj.e(concat);
                    return zzgk.zzCh();
                }
                n = zzda.zzbFf;
                set = new HashSet<Character>();
                zza(set, zzb);
                zza(set, zzb2);
                set.remove('\\');
            }
        }
        else {
            set = null;
        }
        final StringBuilder sb = new StringBuilder();
        switch (zzbr.type) {
            default: {
                zza(sb, zzgk.zzb(zzbr), n, (Set)set);
                break;
            }
            case 2: {
                int n2 = 1;
                final com.google.android.gms.internal.zzbr[] zzlE = zzbr.zzlE;
                for (int length = zzlE.length, i = 0; i < length; ++i, n2 = 0) {
                    final com.google.android.gms.internal.zzbr zzbr5 = zzlE[i];
                    if (n2 == 0) {
                        sb.append(zzb);
                    }
                    zza(sb, zzgk.zzb(zzbr5), n, (Set)set);
                }
                break;
            }
            case 3: {
                for (int j = 0; j < zzbr.zzlF.length; ++j) {
                    if (j > 0) {
                        sb.append(zzb);
                    }
                    final String zzb4 = zzgk.zzb(zzbr.zzlF[j]);
                    final String zzb5 = zzgk.zzb(zzbr.zzlG[j]);
                    zza(sb, zzb4, n, (Set)set);
                    sb.append(zzb2);
                    zza(sb, zzb5, n, (Set)set);
                }
                break;
            }
        }
        return zzgk.zzI(sb.toString());
    }
}
