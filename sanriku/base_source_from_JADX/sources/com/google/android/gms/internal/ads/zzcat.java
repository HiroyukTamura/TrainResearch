package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcat {
    private final Executor executor;
    private final zzaci zzdhc;
    private final zzawt zzduw;
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzbzx zzfqb;
    private final zzcab zzfrc;
    private final zzbzs zzfrk;
    @Nullable
    private final zzcbb zzftp;

    public zzcat(zzawt zzawt, zzdhe zzdhe, zzcab zzcab, zzbzx zzbzx, @Nullable zzcbb zzcbb, Executor executor2, Executor executor3, zzbzs zzbzs) {
        this.zzduw = zzawt;
        this.zzfll = zzdhe;
        this.zzdhc = zzdhe.zzdhc;
        this.zzfrc = zzcab;
        this.zzfqb = zzbzx;
        this.zzftp = zzcbb;
        this.zzfhi = executor2;
        this.executor = executor3;
        this.zzfrk = zzbzs;
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcbj zzcbj, String[] strArr) {
        Map<String, WeakReference<View>> zzalz = zzcbj.zzalz();
        if (zzalz == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzalz.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final void zza(zzcbj zzcbj) {
        this.zzfhi.execute(new zzcas(this, zzcbj));
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        View zzala = this.zzfqb.zzala();
        if (zzala == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzala.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzala.getParent()).removeView(zzala);
        }
        viewGroup.addView(zzala, ((Boolean) zzvj.zzpv().zzd(zzzz.zzcpa)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfqb.zzala() == null) {
            return;
        }
        if (2 == this.zzfqb.zzakw() || 1 == this.zzfqb.zzakw()) {
            this.zzduw.zza(this.zzfll.zzgux, String.valueOf(this.zzfqb.zzakw()), z);
        } else if (6 == this.zzfqb.zzakw()) {
            this.zzduw.zza(this.zzfll.zzgux, ExifInterface.GPS_MEASUREMENT_2D, z);
            this.zzduw.zza(this.zzfll.zzgux, "1", z);
        }
    }

    public final void zzc(@Nullable zzcbj zzcbj) {
        if (zzcbj != null && this.zzftp != null && zzcbj.zzalw() != null && this.zzfrc.zzali()) {
            try {
                zzcbj.zzalw().addView(this.zzftp.zzamh());
            } catch (zzbew e) {
                zzawr.zza("web view can not be obtained", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00f5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzd(com.google.android.gms.internal.ads.zzcbj r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzcab r0 = r9.zzfrc
            boolean r0 = r0.zzalk()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcab r0 = r9.zzfrc
            boolean r0 = r0.zzalj()
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            r3 = 0
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "1098"
            java.lang.String r4 = "3011"
            java.lang.String[] r0 = new java.lang.String[]{r0, r4}
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r4 >= r5) goto L_0x0037
            r5 = r0[r4]
            android.view.View r5 = r10.zzgd(r5)
            if (r5 == 0) goto L_0x0034
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0034
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto L_0x0038
        L_0x0034:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            android.view.View r4 = r10.zzahe()
            android.content.Context r4 = r4.getContext()
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            com.google.android.gms.internal.ads.zzbzx r7 = r9.zzfqb
            android.view.View r7 = r7.zzakx()
            if (r7 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbzx r4 = r9.zzfqb
            android.view.View r4 = r4.zzakx()
            com.google.android.gms.internal.ads.zzaci r7 = r9.zzdhc
            if (r7 != 0) goto L_0x005e
            goto L_0x009b
        L_0x005e:
            if (r0 != 0) goto L_0x009b
            int r7 = r7.zzbla
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r7)
            r4.setLayoutParams(r6)
            goto L_0x009b
        L_0x0069:
            com.google.android.gms.internal.ads.zzbzx r7 = r9.zzfqb
            com.google.android.gms.internal.ads.zzack r7 = r7.zzsb()
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzacd
            if (r7 != 0) goto L_0x0075
            r4 = r3
            goto L_0x009b
        L_0x0075:
            com.google.android.gms.internal.ads.zzbzx r7 = r9.zzfqb
            com.google.android.gms.internal.ads.zzack r7 = r7.zzsb()
            com.google.android.gms.internal.ads.zzacd r7 = (com.google.android.gms.internal.ads.zzacd) r7
            if (r0 != 0) goto L_0x0086
            int r8 = r7.zzru()
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r8)
        L_0x0086:
            com.google.android.gms.internal.ads.zzacc r8 = new com.google.android.gms.internal.ads.zzacc
            r8.<init>(r4, r7, r6)
            com.google.android.gms.internal.ads.zzzk<java.lang.String> r4 = com.google.android.gms.internal.ads.zzzz.zzcox
            com.google.android.gms.internal.ads.zzzv r6 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8.setContentDescription(r4)
            r4 = r8
        L_0x009b:
            r6 = -1
            if (r4 == 0) goto L_0x00e0
            android.view.ViewParent r7 = r4.getParent()
            boolean r7 = r7 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00af
            android.view.ViewParent r7 = r4.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r4)
        L_0x00af:
            if (r0 == 0) goto L_0x00b8
            r5.removeAllViews()
            r5.addView(r4)
            goto L_0x00d9
        L_0x00b8:
            com.google.android.gms.ads.formats.AdChoicesView r0 = new com.google.android.gms.ads.formats.AdChoicesView
            android.view.View r5 = r10.zzahe()
            android.content.Context r5 = r5.getContext()
            r0.<init>(r5)
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r6, r6)
            r0.setLayoutParams(r5)
            r0.addView(r4)
            android.widget.FrameLayout r5 = r10.zzalw()
            if (r5 == 0) goto L_0x00d9
            r5.addView(r0)
        L_0x00d9:
            java.lang.String r0 = r10.zzamb()
            r10.zza(r0, r4, r2)
        L_0x00e0:
            java.lang.String[] r0 = com.google.android.gms.internal.ads.zzcar.zzfth
            int r2 = r0.length
        L_0x00e3:
            if (r1 >= r2) goto L_0x00f5
            r4 = r0[r1]
            android.view.View r4 = r10.zzgd(r4)
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00f2
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            goto L_0x00f6
        L_0x00f2:
            int r1 = r1 + 1
            goto L_0x00e3
        L_0x00f5:
            r4 = r3
        L_0x00f6:
            java.util.concurrent.Executor r0 = r9.executor
            com.google.android.gms.internal.ads.zzcav r1 = new com.google.android.gms.internal.ads.zzcav
            r1.<init>(r9, r4)
            r0.execute(r1)
            if (r4 == 0) goto L_0x01a7
            boolean r0 = r9.zza((android.view.ViewGroup) r4)
            if (r0 == 0) goto L_0x011f
            com.google.android.gms.internal.ads.zzbzx r0 = r9.zzfqb
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzalb()
            if (r0 == 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzbzx r0 = r9.zzfqb
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzalb()
            com.google.android.gms.internal.ads.zzcau r1 = new com.google.android.gms.internal.ads.zzcau
            r1.<init>(r9, r10, r4)
            r0.zza((com.google.android.gms.internal.ads.zzacg) r1)
            return
        L_0x011f:
            r4.removeAllViews()
            android.view.View r0 = r10.zzahe()
            if (r0 == 0) goto L_0x012c
            android.content.Context r3 = r0.getContext()
        L_0x012c:
            if (r3 == 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcow
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzbzs r0 = r9.zzfrk
            com.google.android.gms.internal.ads.zzacr r0 = r0.zzsl()
            if (r0 == 0) goto L_0x01a7
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzry()     // Catch:{ RemoteException -> 0x014d }
            goto L_0x015f
        L_0x014d:
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.internal.ads.zzazw.zzfc(r10)
            return
        L_0x0153:
            com.google.android.gms.internal.ads.zzbzx r0 = r9.zzfqb
            com.google.android.gms.internal.ads.zzacs r0 = r0.zzaky()
            if (r0 == 0) goto L_0x01a7
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzrv()     // Catch:{ RemoteException -> 0x01a2 }
        L_0x015f:
            if (r0 == 0) goto L_0x01a7
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            if (r0 == 0) goto L_0x01a7
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r3)
            r1.setImageDrawable(r0)
            com.google.android.gms.dynamic.IObjectWrapper r10 = r10.zzamc()
            if (r10 == 0) goto L_0x0191
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcsy
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x018a
            goto L_0x0191
        L_0x018a:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            goto L_0x0193
        L_0x0191:
            android.widget.ImageView$ScaleType r10 = android.widget.ImageView.ScaleType.CENTER_INSIDE
        L_0x0193:
            r1.setScaleType(r10)
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r6, r6)
            r1.setLayoutParams(r10)
            r4.addView(r1)
            goto L_0x01a7
        L_0x01a2:
            java.lang.String r10 = "Could not get drawable from image"
            com.google.android.gms.internal.ads.zzazw.zzfc(r10)
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcat.zzd(com.google.android.gms.internal.ads.zzcbj):void");
    }
}
