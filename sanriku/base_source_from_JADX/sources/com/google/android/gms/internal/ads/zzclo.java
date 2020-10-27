package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzclo extends zzaqz {
    private final Executor zzfhi;
    private final zzasa zzgci;
    private final zzarx zzgcj;
    private final zzbjv zzgck;
    private final HashMap<String, zzcmd> zzgcl;
    private final Context zzvf;

    public zzclo(Context context, Executor executor, zzasa zzasa, zzbjv zzbjv, zzarx zzarx, HashMap<String, zzcmd> hashMap) {
        zzzz.initialize(context);
        this.zzvf = context;
        this.zzfhi = executor;
        this.zzgci = zzasa;
        this.zzgcj = zzarx;
        this.zzgck = zzbjv;
        this.zzgcl = hashMap;
    }

    private static zzdri<JSONObject> zza(zzarj zzarj, zzdku zzdku, zzdbc zzdbc) {
        zzcls zzcls = new zzcls(zzdbc);
        return zzdku.zza(zzdkr.GMS_SIGNALS, zzdqw.zzag(zzarj.zzdpe)).zza(zzcls).zzb(zzclv.zzgaz).zzaud();
    }

    private static zzdri<zzarp> zza(zzdri<JSONObject> zzdri, zzdku zzdku, zzakp zzakp) {
        return zzdku.zza(zzdkr.BUILD_URL, zzdri).zza(zzakp.zza("AFMA_getAdDictionary", zzakk.zzddu, zzclu.zzddw)).zzaud();
    }

    private final void zza(zzdri<InputStream> zzdri, zzard zzard) {
        zzdqw.zza(zzdqw.zzb(zzdri, new zzcly(this), (Executor) zzbab.zzdzr), new zzcma(this, zzard), zzbab.zzdzw);
    }

    public final zzaqw zza(zzaqu zzaqu) throws RemoteException {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzdri zzdri, zzdri zzdri2) throws Exception {
        String zzva = ((zzarp) zzdri.get()).zzva();
        this.zzgcl.put(zzva, new zzcmd((zzarp) zzdri.get(), (JSONObject) zzdri2.get()));
        return new ByteArrayInputStream(zzva.getBytes(zzdnv.UTF_8));
    }

    public final void zza(zzaqu zzaqu, zzarb zzarb) throws RemoteException {
    }

    public final void zza(zzarj zzarj, zzard zzard) {
        zzdri<InputStream> zzb = zzb(zzarj, Binder.getCallingUid());
        zza(zzb, zzard);
        zzb.addListener(new zzclx(this), this.zzfhi);
    }

    public final void zza(String str, zzard zzard) {
        zza(zzgl(str), zzard);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaou() {
        zzbaf.zza(this.zzgcj.zzvc(), "persistFlags");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdri<java.io.InputStream> zzb(com.google.android.gms.internal.ads.zzarj r9, int r10) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzakg r0 = com.google.android.gms.ads.internal.zzq.zzlj()
            android.content.Context r1 = r8.zzvf
            com.google.android.gms.internal.ads.zzazz r2 = com.google.android.gms.internal.ads.zzazz.zzyi()
            com.google.android.gms.internal.ads.zzakp r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzbjv r1 = r8.zzgck
            com.google.android.gms.internal.ads.zzdbc r10 = r1.zza(r9, r10)
            com.google.android.gms.internal.ads.zzaki<com.google.android.gms.internal.ads.zzcmc> r1 = com.google.android.gms.internal.ads.zzcmc.zzgct
            com.google.android.gms.internal.ads.zzakj<java.io.InputStream> r2 = com.google.android.gms.internal.ads.zzakk.zzddv
            java.lang.String r3 = "google.afma.response.normalize"
            com.google.android.gms.internal.ads.zzakh r1 = r0.zza(r3, r1, r2)
            com.google.android.gms.internal.ads.zzcmh r2 = new com.google.android.gms.internal.ads.zzcmh
            android.content.Context r3 = r8.zzvf
            com.google.android.gms.internal.ads.zzazz r4 = r9.zzdls
            java.lang.String r4 = r4.zzbnd
            com.google.android.gms.internal.ads.zzasa r5 = r8.zzgci
            java.lang.String r6 = r9.zzdms
            r2.<init>(r3, r4, r5, r6)
            com.google.android.gms.internal.ads.zzdku r3 = r10.zzaex()
            com.google.android.gms.internal.ads.zzaaz<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzabo.zzcxc
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = 0
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = r9.zzdpi
            if (r4 == 0) goto L_0x006a
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x006a
            java.lang.String r4 = "Request contained a PoolKey but split request is disabled."
        L_0x004c:
            com.google.android.gms.internal.ads.zzawr.zzeg(r4)
            goto L_0x006a
        L_0x0050:
            java.lang.String r4 = r9.zzdpi
            if (r4 == 0) goto L_0x006a
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x006a
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzcmd> r4 = r8.zzgcl
            java.lang.String r5 = r9.zzdpi
            java.lang.Object r4 = r4.remove(r5)
            r5 = r4
            com.google.android.gms.internal.ads.zzcmd r5 = (com.google.android.gms.internal.ads.zzcmd) r5
            if (r5 != 0) goto L_0x006a
            java.lang.String r4 = "Request contained a PoolKey but no matching parameters were found."
            goto L_0x004c
        L_0x006a:
            r4 = 1
            r6 = 0
            r7 = 2
            if (r5 != 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzdri r9 = zza((com.google.android.gms.internal.ads.zzarj) r9, (com.google.android.gms.internal.ads.zzdku) r3, (com.google.android.gms.internal.ads.zzdbc) r10)
            com.google.android.gms.internal.ads.zzdri r10 = zza((com.google.android.gms.internal.ads.zzdri<org.json.JSONObject>) r9, (com.google.android.gms.internal.ads.zzdku) r3, (com.google.android.gms.internal.ads.zzakp) r0)
            com.google.android.gms.internal.ads.zzdkr r0 = com.google.android.gms.internal.ads.zzdkr.HTTP
            com.google.android.gms.internal.ads.zzdri[] r5 = new com.google.android.gms.internal.ads.zzdri[r7]
            r5[r6] = r10
            r5[r4] = r9
            com.google.android.gms.internal.ads.zzdki r0 = r3.zza(r0, (com.google.android.gms.internal.ads.zzdri<?>[]) r5)
            com.google.android.gms.internal.ads.zzclr r5 = new com.google.android.gms.internal.ads.zzclr
            r5.<init>(r9, r10)
            com.google.android.gms.internal.ads.zzdkm r0 = r0.zzb(r5)
            com.google.android.gms.internal.ads.zzdkm r0 = r0.zzb(r2)
            com.google.android.gms.internal.ads.zzdkd r0 = r0.zzaud()
            com.google.android.gms.internal.ads.zzdkr r2 = com.google.android.gms.internal.ads.zzdkr.PRE_PROCESS
            r5 = 3
            com.google.android.gms.internal.ads.zzdri[] r5 = new com.google.android.gms.internal.ads.zzdri[r5]
            r5[r6] = r9
            r5[r4] = r10
            r5[r7] = r0
            com.google.android.gms.internal.ads.zzdki r2 = r3.zza(r2, (com.google.android.gms.internal.ads.zzdri<?>[]) r5)
            com.google.android.gms.internal.ads.zzclq r3 = new com.google.android.gms.internal.ads.zzclq
            r3.<init>(r0, r9, r10)
            com.google.android.gms.internal.ads.zzdkm r9 = r2.zzb(r3)
        L_0x00ac:
            com.google.android.gms.internal.ads.zzdkm r9 = r9.zza(r1)
            com.google.android.gms.internal.ads.zzdkd r9 = r9.zzaud()
            return r9
        L_0x00b5:
            com.google.android.gms.internal.ads.zzcmg r9 = new com.google.android.gms.internal.ads.zzcmg
            org.json.JSONObject r10 = r5.zzgcr
            com.google.android.gms.internal.ads.zzarp r0 = r5.zzgcs
            r9.<init>(r10, r0)
            com.google.android.gms.internal.ads.zzdkr r10 = com.google.android.gms.internal.ads.zzdkr.HTTP
            com.google.android.gms.internal.ads.zzdri r9 = com.google.android.gms.internal.ads.zzdqw.zzag(r9)
            com.google.android.gms.internal.ads.zzdkm r9 = r3.zza(r10, r9)
            com.google.android.gms.internal.ads.zzdkm r9 = r9.zzb(r2)
            com.google.android.gms.internal.ads.zzdkd r9 = r9.zzaud()
            com.google.android.gms.internal.ads.zzdri r10 = com.google.android.gms.internal.ads.zzdqw.zzag(r5)
            com.google.android.gms.internal.ads.zzdkr r0 = com.google.android.gms.internal.ads.zzdkr.PRE_PROCESS
            com.google.android.gms.internal.ads.zzdri[] r2 = new com.google.android.gms.internal.ads.zzdri[r7]
            r2[r6] = r9
            r2[r4] = r10
            com.google.android.gms.internal.ads.zzdki r0 = r3.zza(r0, (com.google.android.gms.internal.ads.zzdri<?>[]) r2)
            com.google.android.gms.internal.ads.zzclt r2 = new com.google.android.gms.internal.ads.zzclt
            r2.<init>(r9, r10)
            com.google.android.gms.internal.ads.zzdkm r9 = r0.zzb(r2)
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclo.zzb(com.google.android.gms.internal.ads.zzarj, int):com.google.android.gms.internal.ads.zzdri");
    }

    public final void zzb(zzarj zzarj, zzard zzard) {
        zzdri zzdri;
        int callingUid = Binder.getCallingUid();
        zzakp zza = zzq.zzlj().zza(this.zzvf, zzazz.zzyi());
        if (!zzabu.zzcxu.get().booleanValue()) {
            zzdri = zzdqw.immediateFailedFuture(new Exception("Signal collection disabled."));
        } else {
            zzdbc zza2 = this.zzgck.zza(zzarj, callingUid);
            zzdaj<JSONObject> zzaew = zza2.zzaew();
            zzdri = zza2.zzaex().zza(zzdkr.GET_SIGNALS, zzdqw.zzag(zzarj.zzdpe)).zza(new zzclz(zzaew)).zzw(zzdkr.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzakk.zzddu, zzakk.zzddv)).zzaud();
        }
        zza((zzdri<InputStream>) zzdri, zzard);
    }

    public final zzdri<InputStream> zzc(zzarj zzarj, int i) {
        if (!zzabo.zzcxc.get().booleanValue()) {
            return zzdqw.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdir zzdir = zzarj.zzdph;
        if (zzdir == null) {
            return zzdqw.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdir.zzgwv == 0 || zzdir.zzgww == 0) {
            return zzdqw.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzakp zza = zzq.zzlj().zza(this.zzvf, zzazz.zzyi());
        zzdbc zza2 = this.zzgck.zza(zzarj, i);
        zzdku zzaex = zza2.zzaex();
        zzdri<JSONObject> zza3 = zza(zzarj, zzaex, zza2);
        zzdri<zzarp> zza4 = zza(zza3, zzaex, zza);
        return zzaex.zza(zzdkr.GET_URL_AND_CACHE_KEY, (zzdri<?>[]) new zzdri[]{zza3, zza4}).zzb(new zzclw(this, zza4, zza3)).zzaud();
    }

    public final void zzc(zzarj zzarj, zzard zzard) {
        zza(zzc(zzarj, Binder.getCallingUid()), zzard);
    }

    public final zzdri<InputStream> zzgl(String str) {
        if (!zzabo.zzcxc.get().booleanValue()) {
            return zzdqw.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcmb zzcmb = new zzcmb(this);
        if (this.zzgcl.remove(str) != null) {
            return zzdqw.zzag(zzcmb);
        }
        String valueOf = String.valueOf(str);
        return zzdqw.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }
}
