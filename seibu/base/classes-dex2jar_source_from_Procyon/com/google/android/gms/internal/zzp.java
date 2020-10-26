// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Map;
import android.net.Uri;
import android.text.TextUtils;

public abstract class zzp<T> implements Comparable<zzp<T>>
{
    private final zzab.zza zzB;
    private final int zzC;
    private final String zzD;
    private final int zzE;
    private final zzu zzF;
    private Integer zzG;
    private zzs zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private zzx zzM;
    private zzc zzN;
    
    public zzp(int hashCode, String host, final zzu zzF) {
        zzab.zza zzB;
        if (zzab.zza.zzai) {
            zzB = new zzab.zza();
        }
        else {
            zzB = null;
        }
        this.zzB = zzB;
        this.zzI = true;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = false;
        this.zzN = null;
        this.zzC = hashCode;
        this.zzD = host;
        this.zzF = zzF;
        this.zzM = new zzg();
        while (true) {
            Label_0118: {
                if (TextUtils.isEmpty((CharSequence)host)) {
                    break Label_0118;
                }
                final Uri parse = Uri.parse(host);
                if (parse == null) {
                    break Label_0118;
                }
                host = parse.getHost();
                if (host == null) {
                    break Label_0118;
                }
                hashCode = host.hashCode();
                this.zzE = hashCode;
                return;
            }
            hashCode = 0;
            continue;
        }
    }
    
    public static String zzf() {
        final String value = String.valueOf("UTF-8");
        if (value.length() != 0) {
            return "application/x-www-form-urlencoded; charset=".concat(value);
        }
        return new String("application/x-www-form-urlencoded; charset=");
    }
    
    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }
    
    public final int getMethod() {
        return this.zzC;
    }
    
    public final String getUrl() {
        return this.zzD;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(Integer.toHexString(this.zzE));
        String concat;
        if (value.length() != 0) {
            concat = "0x".concat(value);
        }
        else {
            concat = new String("0x");
        }
        final String value2 = String.valueOf(this.zzD);
        final String value3 = String.valueOf(zzr.zzS);
        final String value4 = String.valueOf(this.zzG);
        return new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(value2).length() + String.valueOf(concat).length() + String.valueOf(value3).length() + String.valueOf(value4).length()).append("[ ] ").append(value2).append(" ").append(concat).append(" ").append(value3).append(" ").append(value4).toString();
    }
    
    public final zzp<?> zza(final int i) {
        this.zzG = i;
        return this;
    }
    
    public final zzp<?> zza(final zzc zzN) {
        this.zzN = zzN;
        return this;
    }
    
    public final zzp<?> zza(final zzs zzH) {
        this.zzH = zzH;
        return this;
    }
    
    protected abstract zzt<T> zza(final zzn p0);
    
    protected abstract void zza(final T p0);
    
    public final void zzb(final zzaa zzaa) {
        if (this.zzF != null) {
            this.zzF.zzd(zzaa);
        }
    }
    
    public final void zzb(final String s) {
        if (zzab.zza.zzai) {
            this.zzB.zza(s, Thread.currentThread().getId());
        }
    }
    
    public final int zzc() {
        return this.zzE;
    }
    
    final void zzc(final String s) {
        if (this.zzH != null) {
            this.zzH.zzd((zzp<Object>)this);
        }
        if (zzab.zza.zzai) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzB.zza(s, id);
                this.zzB.zzc(this.toString());
                return;
            }
            new Handler(Looper.getMainLooper()).post((Runnable)new zzq(this, s, id));
        }
    }
    
    public final String zzd() {
        return this.zzD;
    }
    
    public final zzc zze() {
        return this.zzN;
    }
    
    public byte[] zzg() throws zza {
        return null;
    }
    
    public final boolean zzh() {
        return this.zzI;
    }
    
    public final int zzi() {
        return this.zzM.zza();
    }
    
    public final zzx zzj() {
        return this.zzM;
    }
    
    public final void zzk() {
        this.zzK = true;
    }
    
    public final boolean zzl() {
        return this.zzK;
    }
}
