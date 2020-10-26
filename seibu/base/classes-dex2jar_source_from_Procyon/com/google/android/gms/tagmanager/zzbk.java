// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.util.Base64;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzbk extends zzbr
{
    private static final String ID;
    private static final String zzbEH;
    private static final String zzbEI;
    private static final String zzbEJ;
    private static final String zzbEK;
    
    static {
        ID = zzbf.zzdV.toString();
        zzbEH = zzbg.zzfR.toString();
        zzbEI = zzbg.zziy.toString();
        zzbEJ = zzbg.zzhR.toString();
        zzbEK = zzbg.zziI.toString();
    }
    
    public zzbk() {
        super(zzbk.ID, new String[] { zzbk.zzbEH });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzbk.zzbEH);
        if (zzbr == null || zzbr == zzgk.zzCh()) {
            return zzgk.zzCh();
        }
        final String zzb = zzgk.zzb(zzbr);
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzbk.zzbEJ);
    Label_0165_Outer:
        while (true) {
            Label_0084: {
                while (true) {
                    Label_0061: {
                        if (zzbr2 == null) {
                            final String zzb2 = "text";
                            break Label_0061;
                        }
                        String zzb3 = null;
                        Label_0155: {
                            break Label_0155;
                            while (true) {
                                while (true) {
                                    byte[] array = null;
                                    final int n;
                                    Label_0288: {
                                        try {
                                            final String zzb2;
                                            if ("text".equals(zzb2)) {
                                                array = zzb.getBytes();
                                            }
                                            else if ("base16".equals(zzb2)) {
                                                array = zzo.decode(zzb);
                                            }
                                            else if ("base64".equals(zzb2)) {
                                                array = Base64.decode(zzb, n);
                                            }
                                            else {
                                                if (!"base64url".equals(zzb2)) {
                                                    final String value = String.valueOf(zzb2);
                                                    String concat;
                                                    if (value.length() != 0) {
                                                        concat = "Encode: unknown input format: ".concat(value);
                                                    }
                                                    else {
                                                        concat = new String("Encode: unknown input format: ");
                                                    }
                                                    zzdj.e(concat);
                                                    return zzgk.zzCh();
                                                }
                                                array = Base64.decode(zzb, n | 0x8);
                                            }
                                            if ("base16".equals(zzb3)) {
                                                final String s = zzo.encode(array);
                                                return zzgk.zzI(s);
                                            }
                                            break Label_0288;
                                            final com.google.android.gms.internal.zzbr zzbr3;
                                            zzb3 = zzgk.zzb(zzbr3);
                                            break Label_0084;
                                            zzb2 = zzgk.zzb(zzbr2);
                                            break Label_0061;
                                        }
                                        catch (IllegalArgumentException ex) {
                                            zzdj.e("Encode: invalid input:");
                                            return zzgk.zzCh();
                                        }
                                    }
                                    if ("base64".equals(zzb3)) {
                                        final String s = Base64.encodeToString(array, n);
                                        continue Label_0165_Outer;
                                    }
                                    if ("base64url".equals(zzb3)) {
                                        final String s = Base64.encodeToString(array, n | 0x8);
                                        continue Label_0165_Outer;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        final String value2 = String.valueOf(zzb3);
                        String concat2;
                        if (value2.length() != 0) {
                            concat2 = "Encode: unknown output format: ".concat(value2);
                        }
                        else {
                            concat2 = new String("Encode: unknown output format: ");
                        }
                        zzdj.e(concat2);
                        return zzgk.zzCh();
                    }
                    final com.google.android.gms.internal.zzbr zzbr3 = map.get(zzbk.zzbEK);
                    if (zzbr3 != null) {
                        continue;
                    }
                    break;
                }
                String zzb3 = "base16";
            }
            final int n2 = 2;
            final com.google.android.gms.internal.zzbr zzbr4 = map.get(zzbk.zzbEI);
            int n = n2;
            if (zzbr4 == null) {
                continue Label_0165_Outer;
            }
            n = n2;
            if (zzgk.zzf(zzbr4)) {
                n = 3;
            }
            continue Label_0165_Outer;
        }
    }
}
