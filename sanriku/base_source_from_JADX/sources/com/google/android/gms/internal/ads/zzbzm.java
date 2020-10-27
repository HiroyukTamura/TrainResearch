package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbzm extends zzbns {
    private final zzazz zzbmo;
    private final zzdt zzejl;
    private final Executor zzfhi;
    private final zzcae zzfjb;
    private final zzaur zzfkp;
    private final zzbzx zzfqb;
    private final zzcaf zzfra;
    private final zzcat zzfrb;
    private final zzcab zzfrc;
    private final zzegt<zzcdl> zzfrd;
    private final zzegt<zzcdj> zzfre;
    private final zzegt<zzcdo> zzfrf;
    private final zzegt<zzcdf> zzfrg;
    private final zzegt<zzcdn> zzfrh;
    private zzcbj zzfri;
    private boolean zzfrj;
    private final zzbzs zzfrk;
    private final zzctk zzfrl;
    private final Context zzvf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbzm(zzbnv zzbnv, Executor executor, zzbzx zzbzx, zzcaf zzcaf, zzcat zzcat, zzcab zzcab, zzcae zzcae, zzegt<zzcdl> zzegt, zzegt<zzcdj> zzegt2, zzegt<zzcdo> zzegt3, zzegt<zzcdf> zzegt4, zzegt<zzcdn> zzegt5, zzaur zzaur, zzdt zzdt, zzazz zzazz, Context context, zzbzs zzbzs, zzctk zzctk) {
        super(zzbnv);
        this.zzfhi = executor;
        this.zzfqb = zzbzx;
        this.zzfra = zzcaf;
        this.zzfrb = zzcat;
        this.zzfrc = zzcab;
        this.zzfjb = zzcae;
        this.zzfrd = zzegt;
        this.zzfre = zzegt2;
        this.zzfrf = zzegt3;
        this.zzfrg = zzegt4;
        this.zzfrh = zzegt5;
        this.zzfkp = zzaur;
        this.zzejl = zzdt;
        this.zzbmo = zzazz;
        this.zzvf = context;
        this.zzfrk = zzbzs;
        this.zzfrl = zzctk;
    }

    public static boolean zzy(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfra.cancelUnconfirmedClick();
    }

    public final synchronized void destroy() {
        this.zzfhi.execute(new zzbzr(this));
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzfra.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzfri == null) {
            zzazw.zzed("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzfhi.execute(new zzbzq(this, this.zzfri instanceof zzcao));
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfra.setClickConfirmingView(view);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfra.zza(view, motionEvent, view2);
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzfrb.zzc(this.zzfri);
        this.zzfra.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(zzaer zzaer) {
        this.zzfra.zza(zzaer);
    }

    public final synchronized void zza(zzcbj zzcbj) {
        zzdj zzcb;
        this.zzfri = zzcbj;
        this.zzfrb.zza(zzcbj);
        this.zzfra.zza(zzcbj.zzahe(), zzcbj.zzalz(), zzcbj.zzama(), (View.OnTouchListener) zzcbj, (View.OnClickListener) zzcbj);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnt)).booleanValue() && (zzcb = this.zzejl.zzcb()) != null) {
            zzcb.zzb(zzcbj.zzahe());
        }
        if (zzcbj.zzalx() != null) {
            zzcbj.zzalx().zza((zzpz) this.zzfkp);
        }
    }

    public final synchronized void zza(zzws zzws) {
        this.zzfra.zza(zzws);
    }

    public final synchronized void zza(@Nullable zzww zzww) {
        this.zzfra.zza(zzww);
    }

    public final synchronized void zza(zzxf zzxf) {
        this.zzfrl.zzb(zzxf);
    }

    public final void zzaa(View view) {
        IObjectWrapper zzald = this.zzfqb.zzald();
        if (this.zzfrc.zzaks() && zzald != null && view != null) {
            zzq.zzll().zzb(zzald, view);
        }
    }

    @AnyThread
    public final void zzahk() {
        this.zzfhi.execute(new zzbzp(this));
        if (this.zzfqb.zzakw() != 7) {
            Executor executor = this.zzfhi;
            zzcaf zzcaf = this.zzfra;
            zzcaf.getClass();
            executor.execute(zzbzo.zza(zzcaf));
        }
        super.zzahk();
    }

    public final synchronized void zzakl() {
        if (!this.zzfrj) {
            this.zzfra.zzakl();
        }
    }

    public final boolean zzakr() {
        return this.zzfrc.zzalj();
    }

    public final boolean zzaks() {
        return this.zzfrc.zzaks();
    }

    public final zzbzs zzakt() {
        return this.zzfrk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaku() {
        this.zzfra.destroy();
        this.zzfqb.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakv() {
        try {
            int zzakw = this.zzfqb.zzakw();
            if (zzakw != 1) {
                if (zzakw != 2) {
                    if (zzakw != 3) {
                        if (zzakw != 6) {
                            if (zzakw != 7) {
                                zzazw.zzfa("Wrong native template id!");
                            } else if (this.zzfjb.zzalp() != null) {
                                this.zzfjb.zzalp().zza(this.zzfrg.get());
                            }
                        } else if (this.zzfjb.zzaln() != null) {
                            zzg("Google", true);
                            this.zzfjb.zzaln().zza(this.zzfrf.get());
                        }
                    } else if (this.zzfjb.zzgb(this.zzfqb.getCustomTemplateId()) != null) {
                        if (this.zzfqb.zzalb() != null) {
                            zzg("Google", true);
                        }
                        this.zzfjb.zzgb(this.zzfqb.getCustomTemplateId()).zzb(this.zzfrh.get());
                    }
                } else if (this.zzfjb.zzalm() != null) {
                    zzg("Google", true);
                    this.zzfjb.zzalm().zza(this.zzfre.get());
                }
            } else if (this.zzfjb.zzall() != null) {
                zzg("Google", true);
                this.zzfjb.zzall().zza(this.zzfrd.get());
            }
        } catch (RemoteException e) {
            zzazw.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzfrj     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x0013
            com.google.android.gms.internal.ads.zzcaf r6 = r2.zzfra     // Catch:{ all -> 0x005c }
            r6.zza((android.view.View) r3, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5)     // Catch:{ all -> 0x005c }
            r2.zzfrj = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x0013:
            if (r6 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzzz.zzcpb     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x005c }
            java.lang.Object r6 = r1.zzd(r6)     // Catch:{ all -> 0x005c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x005c }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x005a
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x005c }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x005c }
        L_0x0031:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x005c }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x005c }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            boolean r1 = zzy(r1)     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzcaf r6 = r2.zzfra     // Catch:{ all -> 0x005c }
            r6.zza((android.view.View) r3, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5)     // Catch:{ all -> 0x005c }
            r2.zzfrj = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x005a:
            monitor-exit(r2)
            return
        L_0x005c:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0060
        L_0x005f:
            throw r3
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzm.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzb(zzcbj zzcbj) {
        this.zzfra.zza(zzcbj.zzahe(), zzcbj.zzaly());
        if (zzcbj.zzalw() != null) {
            zzcbj.zzalw().setClickable(false);
            zzcbj.zzalw().removeAllViews();
        }
        if (zzcbj.zzalx() != null) {
            zzcbj.zzalx().zzb(this.zzfkp);
        }
        this.zzfri = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzbj(boolean z) {
        this.zzfra.zza(this.zzfri.zzahe(), this.zzfri.zzaly(), this.zzfri.zzalz(), z);
    }

    public final synchronized void zzfx(String str) {
        this.zzfra.zzfx(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfra.zzg(bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzcab r0 = r10.zzfrc
            boolean r0 = r0.zzaks()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbzx r0 = r10.zzfqb
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzalc()
            com.google.android.gms.internal.ads.zzbzx r1 = r10.zzfqb
            com.google.android.gms.internal.ads.zzbek r1 = r1.zzalb()
            if (r0 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r3 = 0
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            r8 = r3
            goto L_0x0032
        L_0x002a:
            if (r2 == 0) goto L_0x0030
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L_0x0028
        L_0x0030:
            r0 = r3
            r8 = r0
        L_0x0032:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzapd r3 = com.google.android.gms.ads.internal.zzq.zzll()
            android.content.Context r4 = r10.zzvf
            boolean r3 = r3.zzo(r4)
            if (r3 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzazz r3 = r10.zzbmo
            int r4 = r3.zzdzn
            int r3 = r3.zzdzo
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r4)
            java.lang.String r4 = "."
            r6.append(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzapd r3 = com.google.android.gms.ads.internal.zzq.zzll()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0075
            return
        L_0x0075:
            com.google.android.gms.internal.ads.zzbzx r3 = r10.zzfqb
            r3.zzas(r11)
            r0.zzap(r11)
            if (r2 == 0) goto L_0x008c
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzapd r1 = com.google.android.gms.ads.internal.zzq.zzll()
            r1.zza(r11, r0)
        L_0x008c:
            if (r12 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzapd r12 = com.google.android.gms.ads.internal.zzq.zzll()
            r12.zzab(r11)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzm.zzg(java.lang.String, boolean):void");
    }

    public final synchronized void zzh(Bundle bundle) {
        this.zzfra.zzh(bundle);
    }

    public final synchronized boolean zzi(Bundle bundle) {
        if (this.zzfrj) {
            return true;
        }
        boolean zzi = this.zzfra.zzi(bundle);
        this.zzfrj = zzi;
        return zzi;
    }

    public final synchronized void zzsk() {
        this.zzfra.zzsk();
    }

    public final void zzz(View view) {
        IObjectWrapper zzald = this.zzfqb.zzald();
        boolean z = this.zzfqb.zzalc() != null;
        if (this.zzfrc.zzaks() && zzald != null && z && view != null) {
            zzq.zzll().zza(zzald, view);
        }
    }
}
