package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzqj {
    private final Object lock = new Object();
    private int score;
    private final int zzbpm;
    private final int zzbpn;
    private final int zzbpo;
    private final boolean zzbpp;
    private final zzqy zzbpq;
    private final zzrf zzbpr;
    private ArrayList<String> zzbps = new ArrayList<>();
    private ArrayList<String> zzbpt = new ArrayList<>();
    private ArrayList<zzqw> zzbpu = new ArrayList<>();
    private int zzbpv = 0;
    private int zzbpw = 0;
    private int zzbpx = 0;
    private String zzbpy = "";
    private String zzbpz = "";
    private String zzbqa = "";

    public zzqj(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzbpm = i;
        this.zzbpn = i2;
        this.zzbpo = i3;
        this.zzbpp = z;
        this.zzbpq = new zzqy(i4);
        this.zzbpr = new zzrf(i5, i6, i7);
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzbpo) {
            synchronized (this.lock) {
                this.zzbps.add(str);
                this.zzbpv += str.length();
                if (z) {
                    this.zzbpt.add(str);
                    this.zzbpu.add(new zzqw(f, f2, f3, f4, this.zzbpt.size() - 1));
                }
            }
        }
    }

    @VisibleForTesting
    private final int zzh(int i, int i2) {
        if (this.zzbpp) {
            return this.zzbpn;
        }
        return (i2 * this.zzbpn) + (i * this.zzbpm);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqj)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzqj) obj).zzbpy;
        return str != null && str.equals(this.zzbpy);
    }

    public final int getScore() {
        return this.score;
    }

    public final int hashCode() {
        return this.zzbpy.hashCode();
    }

    public final String toString() {
        int i = this.zzbpw;
        int i2 = this.score;
        int i3 = this.zzbpv;
        String zza = zza(this.zzbps, 100);
        String zza2 = zza(this.zzbpt, 100);
        String str = this.zzbpy;
        String str2 = this.zzbpz;
        String str3 = this.zzbqa;
        StringBuilder sb = new StringBuilder(C0681a.m336b(str3, C0681a.m336b(str2, C0681a.m336b(str, C0681a.m336b(zza2, C0681a.m336b(zza, 165))))));
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        C0681a.m335a(sb, "\n viewableText", zza2, "\n signture: ", str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbpx < 0) {
                zzazw.zzed("ActivityContent: negative number of WebViews.");
            }
            zzmf();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final void zzbq(int i) {
        this.zzbpw = i;
    }

    public final boolean zzlx() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbpx == 0;
        }
        return z;
    }

    public final String zzly() {
        return this.zzbpy;
    }

    public final String zzlz() {
        return this.zzbpz;
    }

    public final String zzma() {
        return this.zzbqa;
    }

    public final void zzmb() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmc() {
        synchronized (this.lock) {
            this.zzbpx--;
        }
    }

    public final void zzmd() {
        synchronized (this.lock) {
            this.zzbpx++;
        }
    }

    public final void zzme() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbpv, this.zzbpw);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzmf() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbpv, this.zzbpw);
            if (zzh > this.score) {
                this.score = zzh;
                if (!zzq.zzla().zzwb().zzwq()) {
                    this.zzbpy = this.zzbpq.zza(this.zzbps);
                    this.zzbpz = this.zzbpq.zza(this.zzbpt);
                }
                if (!zzq.zzla().zzwb().zzws()) {
                    this.zzbqa = this.zzbpr.zza(this.zzbpt, this.zzbpu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzmg() {
        return this.zzbpv;
    }
}
