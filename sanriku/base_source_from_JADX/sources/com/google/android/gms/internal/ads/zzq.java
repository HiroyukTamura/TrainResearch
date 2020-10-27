package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzag;
import java.util.Collections;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzq<T> implements Comparable<zzq<T>> {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zzag.zza zzae;
    private final int zzaf;
    private final String zzag;
    private final int zzah;
    @GuardedBy("mLock")
    @Nullable
    private zzy zzai;
    private Integer zzaj;
    private zzu zzak;
    private boolean zzal;
    @GuardedBy("mLock")
    private boolean zzam;
    @GuardedBy("mLock")
    private boolean zzan;
    private boolean zzao;
    private zzad zzap;
    private zzd zzaq;
    @GuardedBy("mLock")
    private zzs zzar;

    public zzq(int i, String str, @Nullable zzy zzy) {
        Uri parse;
        String host;
        this.zzae = zzag.zza.zzbl ? new zzag.zza() : null;
        this.mLock = new Object();
        this.zzal = true;
        int i2 = 0;
        this.zzam = false;
        this.zzan = false;
        this.zzao = false;
        this.zzaq = null;
        this.zzaf = i;
        this.zzag = str;
        this.zzai = zzy;
        this.zzap = new zzg();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzah = i2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzq zzq = (zzq) obj;
        zzv zzv = zzv.NORMAL;
        if (zzv == zzv) {
            return this.zzaj.intValue() - zzq.zzaj.intValue();
        }
        return 0;
    }

    public Map<String, String> getHeaders() throws zzb {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzaf;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzah));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzag;
        String valueOf2 = String.valueOf(zzv.NORMAL);
        String valueOf3 = String.valueOf(this.zzaj);
        StringBuilder b = C0681a.m337b(valueOf3.length() + valueOf2.length() + C0681a.m336b(concat, C0681a.m336b(str, "[ ] ".length() + 3)), "[ ] ", str, " ", concat);
        b.append(" ");
        b.append(valueOf2);
        b.append(" ");
        b.append(valueOf3);
        return b.toString();
    }

    public final zzq<?> zza(zzd zzd) {
        this.zzaq = zzd;
        return this;
    }

    public final zzq<?> zza(zzu zzu) {
        this.zzak = zzu;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzz<T> zza(zzo zzo);

    /* access modifiers changed from: package-private */
    public final void zza(int i) {
        zzu zzu = this.zzak;
        if (zzu != null) {
            zzu.zza(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzs zzs) {
        synchronized (this.mLock) {
            this.zzar = zzs;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz<?> zzz) {
        zzs zzs;
        synchronized (this.mLock) {
            zzs = this.zzar;
        }
        if (zzs != null) {
            zzs.zza(this, zzz);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    public final zzq<?> zzb(int i) {
        this.zzaj = Integer.valueOf(i);
        return this;
    }

    public final void zzb(zzae zzae2) {
        zzy zzy;
        synchronized (this.mLock) {
            zzy = this.zzai;
        }
        if (zzy != null) {
            zzy.zzc(zzae2);
        }
    }

    public final void zzb(String str) {
        if (zzag.zza.zzbl) {
            this.zzae.zza(str, Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzu zzu = this.zzak;
        if (zzu != null) {
            zzu.zzf(this);
        }
        if (zzag.zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzt(this, str, id));
                return;
            }
            this.zzae.zza(str, id);
            this.zzae.zzc(toString());
        }
    }

    public final int zzd() {
        return this.zzah;
    }

    public final String zze() {
        String str = this.zzag;
        int i = this.zzaf;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, C0681a.m336b(num, 1)));
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzd zzf() {
        return this.zzaq;
    }

    public byte[] zzg() throws zzb {
        return null;
    }

    public final boolean zzh() {
        return this.zzal;
    }

    public final int zzi() {
        return this.zzap.zzb();
    }

    public final zzad zzj() {
        return this.zzap;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzan = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzan;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void zzm() {
        zzs zzs;
        synchronized (this.mLock) {
            zzs = this.zzar;
        }
        if (zzs != null) {
            zzs.zza(this);
        }
    }
}
