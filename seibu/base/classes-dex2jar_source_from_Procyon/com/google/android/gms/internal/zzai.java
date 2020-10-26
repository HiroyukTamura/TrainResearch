// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

final class zzai
{
    public String key;
    public long size;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf;
    
    private zzai() {
    }
    
    public zzai(final String key, final zzc zzc) {
        this.key = key;
        this.size = zzc.data.length;
        this.zza = zzc.zza;
        this.zzb = zzc.zzb;
        this.zzc = zzc.zzc;
        this.zzd = zzc.zzd;
        this.zze = zzc.zze;
        this.zzf = zzc.zzf;
    }
    
    public static zzai zzf(final InputStream inputStream) throws IOException {
        final zzai zzai = new zzai();
        if (zzag.zzb(inputStream) != 538247942) {
            throw new IOException();
        }
        zzai.key = zzag.zzd(inputStream);
        zzai.zza = zzag.zzd(inputStream);
        if (zzai.zza.equals("")) {
            zzai.zza = null;
        }
        zzai.zzb = zzag.zzc(inputStream);
        zzai.zzc = zzag.zzc(inputStream);
        zzai.zzd = zzag.zzc(inputStream);
        zzai.zze = zzag.zzc(inputStream);
        zzai.zzf = zzag.zze(inputStream);
        return zzai;
    }
    
    public final boolean zza(final OutputStream outputStream) {
        while (true) {
        Label_0167:
            while (true) {
                try {
                    zzag.zza(outputStream, 538247942);
                    zzag.zza(outputStream, this.key);
                    if (this.zza == null) {
                        final String zza = "";
                        zzag.zza(outputStream, zza);
                        zzag.zza(outputStream, this.zzb);
                        zzag.zza(outputStream, this.zzc);
                        zzag.zza(outputStream, this.zzd);
                        zzag.zza(outputStream, this.zze);
                        final Map<String, String> zzf = this.zzf;
                        if (zzf != null) {
                            zzag.zza(outputStream, zzf.size());
                            for (final Map.Entry<String, String> entry : zzf.entrySet()) {
                                zzag.zza(outputStream, entry.getKey());
                                zzag.zza(outputStream, entry.getValue());
                            }
                            break;
                        }
                        break Label_0167;
                    }
                }
                catch (IOException ex) {
                    zzab.zzb("%s", ex.toString());
                    return false;
                }
                final String zza = this.zza;
                continue;
            }
            zzag.zza(outputStream, 0);
            break;
        }
        outputStream.flush();
        return true;
    }
}
