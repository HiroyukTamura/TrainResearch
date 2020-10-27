package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import p043jp.reifrontier.gym.RFGDef;

public final class zzbfe extends zzxk {
    private final Object lock = new Object();
    private boolean zzacz;
    private boolean zzada;
    private int zzaec;
    private zzxm zzdgn;
    private final zzbbx zzebj;
    private final boolean zzekv;
    private final boolean zzekw;
    private boolean zzekx;
    private boolean zzeky = true;
    private float zzekz;
    private float zzela;
    private float zzelb;
    private zzaee zzelc;

    public zzbfe(zzbbx zzbbx, float f, boolean z, boolean z2) {
        this.zzebj = zzbbx;
        this.zzekz = f;
        this.zzekv = z;
        this.zzekw = z2;
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbab.zzdzv.execute(new zzbfg(this, i, i2, z, z2));
    }

    private final void zzf(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbab.zzdzv.execute(new zzbfd(this, hashMap));
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzelb;
        }
        return f;
    }

    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzela;
        }
        return f;
    }

    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzekz;
        }
        return f;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzaec;
        }
        return i;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzada && this.zzekw) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzekv && this.zzacz;
        }
        return z;
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeky;
        }
        return z;
    }

    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void pause() {
        zzf("pause", (Map<String, String>) null);
    }

    public final void play() {
        zzf("play", (Map<String, String>) null);
    }

    public final void stop() {
        zzf("stop", (Map<String, String>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzekz     // Catch:{ all -> 0x004f }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.zzelb     // Catch:{ all -> 0x004f }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.zzekz = r5     // Catch:{ all -> 0x004f }
            r3.zzela = r4     // Catch:{ all -> 0x004f }
            boolean r4 = r3.zzeky     // Catch:{ all -> 0x004f }
            r3.zzeky = r7     // Catch:{ all -> 0x004f }
            int r5 = r3.zzaec     // Catch:{ all -> 0x004f }
            r3.zzaec = r6     // Catch:{ all -> 0x004f }
            float r2 = r3.zzelb     // Catch:{ all -> 0x004f }
            r3.zzelb = r8     // Catch:{ all -> 0x004f }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x004f }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbbx r8 = r3.zzebj     // Catch:{ all -> 0x004f }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x004f }
            r8.invalidate()     // Catch:{ all -> 0x004f }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzaee r8 = r3.zzelc     // Catch:{ RemoteException -> 0x0045 }
            if (r8 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzaee r8 = r3.zzelc     // Catch:{ RemoteException -> 0x0045 }
            r8.zzsj()     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x004b
        L_0x0045:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzazw.zze(r0, r8)
        L_0x004b:
            r3.zza(r5, r6, r4, r7)
            return
        L_0x004f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfe.zza(float, float, int, boolean, float):void");
    }

    public final void zza(zzaee zzaee) {
        synchronized (this.lock) {
            this.zzelc = zzaee;
        }
    }

    public final void zza(zzxm zzxm) {
        synchronized (this.lock) {
            this.zzdgn = zzxm;
        }
    }

    public final void zzacj() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzeky;
            i = this.zzaec;
            this.zzaec = 3;
        }
        zza(i, 3, z, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzekx && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzekx || z5) {
                z3 = true;
            }
            this.zzekx = z3;
            if (z5) {
                try {
                    if (this.zzdgn != null) {
                        this.zzdgn.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzdgn != null) {
                this.zzdgn.onVideoPlay();
            }
            if (z7 && this.zzdgn != null) {
                this.zzdgn.onVideoPause();
            }
            if (z8) {
                if (this.zzdgn != null) {
                    this.zzdgn.onVideoEnd();
                }
                this.zzebj.zzzn();
            }
            if (z9 && this.zzdgn != null) {
                this.zzdgn.onVideoMute(z2);
            }
        }
    }

    public final void zzb(zzze zzze) {
        boolean z = zzze.zzacy;
        boolean z2 = zzze.zzacz;
        boolean z3 = zzze.zzada;
        synchronized (this.lock) {
            this.zzacz = z2;
            this.zzada = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : RFGDef.DEFAULT_GYM_ID, "customControlsRequested", z2 ? "1" : RFGDef.DEFAULT_GYM_ID, "clickToExpandRequested", z3 ? "1" : RFGDef.DEFAULT_GYM_ID));
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzela = f;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Map map) {
        this.zzebj.zza("pubVideoCmd", map);
    }

    public final zzxm zzqg() throws RemoteException {
        zzxm zzxm;
        synchronized (this.lock) {
            zzxm = this.zzdgn;
        }
        return zzxm;
    }
}
