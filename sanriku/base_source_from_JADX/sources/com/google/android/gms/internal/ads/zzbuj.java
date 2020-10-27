package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbuj {
    @Nullable
    private final zzder zzfks;
    private final Set<zzbvt<zzub>> zzfnu;
    private final Set<zzbvt<zzbqx>> zzfnv;
    private final Set<zzbvt<zzbrp>> zzfnw;
    private final Set<zzbvt<zzbsr>> zzfnx;
    private final Set<zzbvt<zzbsm>> zzfny;
    private final Set<zzbvt<zzbrc>> zzfnz;
    private final Set<zzbvt<zzbrl>> zzfoa;
    private final Set<zzbvt<AdMetadataListener>> zzfob;
    private final Set<zzbvt<AppEventListener>> zzfoc;
    private final Set<zzbvt<zzbtb>> zzfod;
    private zzbra zzfoe;
    private zzcqi zzfof;

    public static class zza {
        /* access modifiers changed from: private */
        public zzder zzfks;
        /* access modifiers changed from: private */
        public Set<zzbvt<zzub>> zzfnu = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbqx>> zzfnv = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbrp>> zzfnw = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbsr>> zzfnx = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbsm>> zzfny = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbrc>> zzfnz = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbrl>> zzfoa = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<AdMetadataListener>> zzfob = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<AppEventListener>> zzfoc = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbvt<zzbtb>> zzfog = new HashSet();

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfoc.add(new zzbvt(appEventListener, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfob.add(new zzbvt(adMetadataListener, executor));
            return this;
        }

        public final zza zza(zzbqx zzbqx, Executor executor) {
            this.zzfnv.add(new zzbvt(zzbqx, executor));
            return this;
        }

        public final zza zza(zzbrc zzbrc, Executor executor) {
            this.zzfnz.add(new zzbvt(zzbrc, executor));
            return this;
        }

        public final zza zza(zzbrl zzbrl, Executor executor) {
            this.zzfoa.add(new zzbvt(zzbrl, executor));
            return this;
        }

        public final zza zza(zzbrp zzbrp, Executor executor) {
            this.zzfnw.add(new zzbvt(zzbrp, executor));
            return this;
        }

        public final zza zza(zzbsm zzbsm, Executor executor) {
            this.zzfny.add(new zzbvt(zzbsm, executor));
            return this;
        }

        public final zza zza(zzbsr zzbsr, Executor executor) {
            this.zzfnx.add(new zzbvt(zzbsr, executor));
            return this;
        }

        public final zza zza(zzbtb zzbtb, Executor executor) {
            this.zzfog.add(new zzbvt(zzbtb, executor));
            return this;
        }

        public final zza zza(zzder zzder) {
            this.zzfks = zzder;
            return this;
        }

        public final zza zza(zzub zzub, Executor executor) {
            this.zzfnu.add(new zzbvt(zzub, executor));
            return this;
        }

        public final zza zza(@Nullable zzwh zzwh, Executor executor) {
            if (this.zzfoc != null) {
                zzcto zzcto = new zzcto();
                zzcto.zzb(zzwh);
                this.zzfoc.add(new zzbvt(zzcto, executor));
            }
            return this;
        }

        public final zzbuj zzajm() {
            return new zzbuj(this);
        }
    }

    private zzbuj(zza zza2) {
        this.zzfnu = zza2.zzfnu;
        this.zzfnw = zza2.zzfnw;
        this.zzfnx = zza2.zzfnx;
        this.zzfnv = zza2.zzfnv;
        this.zzfny = zza2.zzfny;
        this.zzfnz = zza2.zzfnz;
        this.zzfoa = zza2.zzfoa;
        this.zzfob = zza2.zzfob;
        this.zzfoc = zza2.zzfoc;
        this.zzfod = zza2.zzfog;
        this.zzfks = zza2.zzfks;
    }

    public final zzcqi zza(Clock clock, zzcqk zzcqk) {
        if (this.zzfof == null) {
            this.zzfof = new zzcqi(clock, zzcqk);
        }
        return this.zzfof;
    }

    public final Set<zzbvt<zzbqx>> zzajb() {
        return this.zzfnv;
    }

    public final Set<zzbvt<zzbsm>> zzajc() {
        return this.zzfny;
    }

    public final Set<zzbvt<zzbrc>> zzajd() {
        return this.zzfnz;
    }

    public final Set<zzbvt<zzbrl>> zzaje() {
        return this.zzfoa;
    }

    public final Set<zzbvt<AdMetadataListener>> zzajf() {
        return this.zzfob;
    }

    public final Set<zzbvt<AppEventListener>> zzajg() {
        return this.zzfoc;
    }

    public final Set<zzbvt<zzub>> zzajh() {
        return this.zzfnu;
    }

    public final Set<zzbvt<zzbrp>> zzaji() {
        return this.zzfnw;
    }

    public final Set<zzbvt<zzbsr>> zzajj() {
        return this.zzfnx;
    }

    public final Set<zzbvt<zzbtb>> zzajk() {
        return this.zzfod;
    }

    @Nullable
    public final zzder zzajl() {
        return this.zzfks;
    }

    public final zzbra zzc(Set<zzbvt<zzbrc>> set) {
        if (this.zzfoe == null) {
            this.zzfoe = new zzbra(set);
        }
        return this.zzfoe;
    }
}
