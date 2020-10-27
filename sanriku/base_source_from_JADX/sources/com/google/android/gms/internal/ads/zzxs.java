package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class zzxs {
    /* access modifiers changed from: private */
    public int zzacq = -1;
    /* access modifiers changed from: private */
    public int zzacr = -1;
    /* access modifiers changed from: private */
    public String zzacs;
    /* access modifiers changed from: private */
    public boolean zzbli = false;
    /* access modifiers changed from: private */
    public int zzceh = -1;
    /* access modifiers changed from: private */
    public String zzcek;
    /* access modifiers changed from: private */
    public String zzcem;
    /* access modifiers changed from: private */
    public final Bundle zzceo = new Bundle();
    /* access modifiers changed from: private */
    public String zzceq;
    /* access modifiers changed from: private */
    public boolean zzces;
    /* access modifiers changed from: private */
    public final List<String> zzcet = new ArrayList();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcgm = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzcgn = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcgo = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcgp = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcgq = new HashSet<>();
    /* access modifiers changed from: private */
    public AdInfo zzcgr;
    /* access modifiers changed from: private */
    public Date zzml;
    /* access modifiers changed from: private */
    public Location zzmp;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbli = z;
    }

    public final void zza(Location location) {
        this.zzmp = location;
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcgo.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(AdInfo adInfo) {
        this.zzcgr = adInfo;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcgn.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzml = date;
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzces = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcgn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcgn.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcgn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzb(List<String> list) {
        this.zzcet.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzazw.zzfc("neighboring content URL should not be null or empty");
            } else {
                this.zzcet.add(next);
            }
        }
    }

    public final void zzch(String str) {
        this.zzcgm.add(str);
    }

    public final void zzci(String str) {
        this.zzcgp.add(str);
    }

    public final void zzcj(String str) {
        this.zzcgp.remove(str);
    }

    public final void zzck(String str) {
        this.zzcem = str;
    }

    public final void zzcl(String str) {
        this.zzcek = str;
    }

    public final void zzcm(String str) {
        this.zzceq = str;
    }

    public final void zzcn(String str) {
        this.zzcgq.add(str);
    }

    @Deprecated
    public final void zzco(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzacs = str;
        }
    }

    @Deprecated
    public final void zzct(int i) {
        this.zzceh = i;
    }

    @Deprecated
    public final void zzcu(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzacr = i;
        }
    }

    public final void zze(String str, String str2) {
        this.zzceo.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzacq = z ? 1 : 0;
    }
}
