// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzbw extends zzbr
{
    private static final String ID;
    private static final String zzbEH;
    private static final String zzbEJ;
    private static final String zzbEN;
    
    static {
        ID = zzbf.zzdX.toString();
        zzbEH = zzbg.zzfR.toString();
        zzbEN = zzbg.zzfH.toString();
        zzbEJ = zzbg.zzhR.toString();
    }
    
    public zzbw() {
        super(zzbw.ID, new String[] { zzbw.zzbEH });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzbw.zzbEH);
        if (zzbr == null || zzbr == zzgk.zzCh()) {
            return zzgk.zzCh();
        }
        final String zzb = zzgk.zzb(zzbr);
        Object zzb2 = map.get(zzbw.zzbEN);
        Label_0110: {
            if (zzb2 != null) {
                break Label_0110;
            }
            zzb2 = "MD5";
        Label_0073_Outer:
            while (true) {
                final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzbw.zzbEJ);
                Label_0118: {
                    if (zzbr2 != null) {
                        break Label_0118;
                    }
                    String zzb3 = "text";
                    byte[] input;
                    MessageDigest instance;
                    String concat;
                    String value;
                    String value2;
                    String concat2;
                    Label_0087_Outer:Label_0162_Outer:Block_6_Outer:
                    while (true) {
                        Label_0126: {
                            if (!"text".equals(zzb3)) {
                                break Label_0126;
                            }
                            input = zzb.getBytes();
                            try {
                                // iftrue(Label_0170:, value.length() == 0)
                                // iftrue(Label_0143:, !"base16".equals((Object)zzb3))
                                while (true) {
                                    while (true) {
                                        while (true) {
                                            instance = MessageDigest.getInstance((String)zzb2);
                                            instance.update(input);
                                            return zzgk.zzI(zzo.encode(instance.digest()));
                                            zzdj.e(concat);
                                            return zzgk.zzCh();
                                            zzb2 = zzgk.zzb((com.google.android.gms.internal.zzbr)zzb2);
                                            continue Label_0073_Outer;
                                            input = zzo.decode(zzb);
                                            continue Label_0162_Outer;
                                        }
                                        Label_0143: {
                                            value = String.valueOf(zzb3);
                                        }
                                        concat = "Hash: unknown input format: ".concat(value);
                                        continue Block_6_Outer;
                                        Label_0170:
                                        concat = new String("Hash: unknown input format: ");
                                        continue Block_6_Outer;
                                    }
                                    continue;
                                }
                                zzb3 = zzgk.zzb(zzbr2);
                                continue Label_0087_Outer;
                            }
                            catch (NoSuchAlgorithmException ex) {
                                value2 = String.valueOf(zzb2);
                                if (value2.length() != 0) {
                                    concat2 = "Hash: unknown algorithm: ".concat(value2);
                                }
                                else {
                                    concat2 = new String("Hash: unknown algorithm: ");
                                }
                                zzdj.e(concat2);
                                return zzgk.zzCh();
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}
