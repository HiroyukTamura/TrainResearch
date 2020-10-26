// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzalk;
import com.google.android.gms.internal.zzalx;
import com.google.android.gms.internal.zzamm;
import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.internal.zzamg;
import com.google.android.gms.internal.zzanx;
import com.google.android.gms.internal.zzami;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.common.internal.zzbo;
import java.util.Map;

final class zzp implements Runnable
{
    private /* synthetic */ String zzaeA;
    private /* synthetic */ Tracker zzaeB;
    private /* synthetic */ Map zzaeu;
    private /* synthetic */ boolean zzaev;
    private /* synthetic */ String zzaew;
    private /* synthetic */ long zzaex;
    private /* synthetic */ boolean zzaey;
    private /* synthetic */ boolean zzaez;
    
    zzp(final Tracker zzaeB, final Map zzaeu, final boolean zzaev, final String zzaew, final long zzaex, final boolean zzaey, final boolean zzaez, final String zzaeA) {
        this.zzaeB = zzaeB;
        this.zzaeu = zzaeu;
        this.zzaev = zzaev;
        this.zzaew = zzaew;
        this.zzaex = zzaex;
        this.zzaey = zzaey;
        this.zzaez = zzaez;
        this.zzaeA = zzaeA;
    }
    
    @Override
    public final void run() {
        boolean b = true;
        if (this.zzaeB.zzaer.zzjE()) {
            this.zzaeu.put("sc", "start");
        }
        final Map zzaeu = this.zzaeu;
        final GoogleAnalytics zzku = this.zzaeB.zzku();
        zzbo.zzcG("getClientId can not be called from the main thread");
        zzaos.zzc(zzaeu, "cid", zzku.zzji().zzkJ().zzli());
        final String s = this.zzaeu.get("sf");
        if (s != null) {
            final double zza = zzaos.zza(s, 100.0);
            if (zzaos.zza(zza, this.zzaeu.get("cid"))) {
                this.zzaeB.zzb("Sampling enabled. Hit sampled out. sample rate", zza);
                return;
            }
        }
        final zzalx zzb = this.zzaeB.zzkA();
        if (this.zzaev) {
            zzaos.zzb(this.zzaeu, "ate", zzb.zzjZ());
            zzaos.zzb(this.zzaeu, "adid", zzb.zzkg());
        }
        else {
            this.zzaeu.remove("ate");
            this.zzaeu.remove("adid");
        }
        final zzalk zzkW = this.zzaeB.zzkB().zzkW();
        zzaos.zzb(this.zzaeu, "an", zzkW.zzjG());
        zzaos.zzb(this.zzaeu, "av", zzkW.zzjH());
        zzaos.zzb(this.zzaeu, "aid", zzkW.zzhl());
        zzaos.zzb(this.zzaeu, "aiid", zzkW.zzjI());
        this.zzaeu.put("v", "1");
        this.zzaeu.put("_v", zzami.zzafL);
        zzaos.zzb(this.zzaeu, "ul", this.zzaeB.zzkC().zzlA().getLanguage());
        zzaos.zzb(this.zzaeu, "sr", this.zzaeB.zzkC().zzlB());
        boolean b2;
        if (this.zzaew.equals("transaction") || this.zzaew.equals("item")) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (!b2 && !this.zzaeB.zzaeq.zzlL()) {
            this.zzaeB.zzkr().zze(this.zzaeu, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long n;
        if ((n = zzaos.zzbC(this.zzaeu.get("ht"))) == 0L) {
            n = this.zzaex;
        }
        if (this.zzaey) {
            this.zzaeB.zzkr().zzc("Dry run enabled. Would have sent hit", new zzanx(this.zzaeB, this.zzaeu, n, this.zzaez));
            return;
        }
        final String s2 = this.zzaeu.get("cid");
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        zzaos.zza(hashMap, "uid", this.zzaeu);
        zzaos.zza(hashMap, "an", this.zzaeu);
        zzaos.zza(hashMap, "aid", this.zzaeu);
        zzaos.zza(hashMap, "av", this.zzaeu);
        zzaos.zza(hashMap, "aiid", this.zzaeu);
        final String zzaeA = this.zzaeA;
        if (TextUtils.isEmpty((CharSequence)this.zzaeu.get("adid"))) {
            b = false;
        }
        this.zzaeu.put("_s", String.valueOf(this.zzaeB.zzkv().zza(new zzamm(0L, s2, zzaeA, b, 0L, hashMap))));
        this.zzaeB.zzkv().zza(new zzanx(this.zzaeB, this.zzaeu, n, this.zzaez));
    }
}
