package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzq;
import java.nio.ByteBuffer;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

@TargetApi(16)
public final class zzbce extends zzbbi implements TextureView.SurfaceTextureListener, zzbdc {
    private Surface zzbiu;
    private final zzbca zzeak;
    private final boolean zzeal;
    private int zzeaq;
    private int zzear;
    private int zzeat;
    private int zzeau;
    private zzbbv zzeav;
    private final boolean zzeaw;
    private zzbbf zzeay;
    private final zzbbx zzebj;
    private String[] zzebw;
    private final zzbby zzeet;
    private zzbcu zzeeu;
    private String zzeev;
    private boolean zzeew;
    private int zzeex = 1;
    private boolean zzeey;
    private boolean zzeez;
    private float zzefa;

    public zzbce(Context context, zzbca zzbca, zzbbx zzbbx, boolean z, boolean z2, zzbby zzbby) {
        super(context);
        this.zzeal = z2;
        this.zzebj = zzbbx;
        this.zzeak = zzbca;
        this.zzeaw = z;
        this.zzeet = zzbby;
        setSurfaceTextureListener(this);
        this.zzeak.zzb(this);
    }

    private final void zza(float f, boolean z) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzb(f, z);
        } else {
            zzazw.zzfc("Trying to set volume before player is initalized.");
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zza(surface, z);
        } else {
            zzazw.zzfc("Trying to set surface before player is initalized.");
        }
    }

    private final void zzaaa() {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaw(false);
        }
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzefa != f) {
            this.zzefa = f;
            requestLayout();
        }
    }

    private final zzbcu zzzs() {
        return new zzbcu(this.zzebj.getContext(), this.zzeet);
    }

    private final String zzzt() {
        return zzq.zzkw().zzr(this.zzebj.getContext(), this.zzebj.zzzk().zzbnd);
    }

    private final boolean zzzu() {
        return this.zzeeu != null && !this.zzeew;
    }

    private final boolean zzzv() {
        return zzzu() && this.zzeex != 1;
    }

    private final void zzzw() {
        String str;
        String str2;
        if (this.zzeeu == null && (str = this.zzeev) != null && this.zzbiu != null) {
            if (str.startsWith("cache:")) {
                zzbdl zzfh = this.zzebj.zzfh(this.zzeev);
                if (zzfh instanceof zzbea) {
                    zzbcu zzaan = ((zzbea) zzfh).zzaan();
                    this.zzeeu = zzaan;
                    if (zzaan.zzaah() == null) {
                        str2 = "Precached video player has been released.";
                    }
                } else if (zzfh instanceof zzbdx) {
                    zzbdx zzbdx = (zzbdx) zzfh;
                    String zzzt = zzzt();
                    ByteBuffer byteBuffer = zzbdx.getByteBuffer();
                    boolean zzaal = zzbdx.zzaal();
                    String url = zzbdx.getUrl();
                    if (url == null) {
                        str2 = "Stream cache URL is null.";
                    } else {
                        zzbcu zzzs = zzzs();
                        this.zzeeu = zzzs;
                        zzzs.zza(new Uri[]{Uri.parse(url)}, zzzt, byteBuffer, zzaal);
                    }
                } else {
                    String valueOf = String.valueOf(this.zzeev);
                    zzazw.zzfc(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
                zzazw.zzfc(str2);
                return;
            }
            this.zzeeu = zzzs();
            String zzzt2 = zzzt();
            Uri[] uriArr = new Uri[this.zzebw.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzebw;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzeeu.zza(uriArr, zzzt2);
            this.zzeeu.zza((zzbdc) this);
            zza(this.zzbiu, false);
            int playbackState = this.zzeeu.zzaah().getPlaybackState();
            this.zzeex = playbackState;
            if (playbackState == 3) {
                zzzx();
            }
        }
    }

    private final void zzzx() {
        if (!this.zzeey) {
            this.zzeey = true;
            zzaxa.zzdwf.post(new zzbcd(this));
            zzyo();
            this.zzeak.zzfa();
            if (this.zzeez) {
                play();
            }
        }
    }

    private final void zzzy() {
        zzo(this.zzeaq, this.zzear);
    }

    private final void zzzz() {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaw(true);
        }
    }

    public final int getCurrentPosition() {
        if (zzzv()) {
            return (int) this.zzeeu.zzaah().zzem();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzzv()) {
            return (int) this.zzeeu.zzaah().getDuration();
        }
        return 0;
    }

    public final int getVideoHeight() {
        return this.zzear;
    }

    public final int getVideoWidth() {
        return this.zzeaq;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzefa;
        if (f != 0.0f && this.zzeav == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            float f4 = this.zzefa;
            if (f4 < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzm(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeaw) {
            zzbbv zzbbv = new zzbbv(getContext());
            this.zzeav = zzbbv;
            zzbbv.zza(surfaceTexture, i, i2);
            this.zzeav.start();
            SurfaceTexture zzzc = this.zzeav.zzzc();
            if (zzzc != null) {
                surfaceTexture = zzzc;
            } else {
                this.zzeav.zzzb();
                this.zzeav = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzbiu = surface;
        if (this.zzeeu == null) {
            zzzw();
        } else {
            zza(surface, true);
            if (!this.zzeet.zzedr) {
                zzzz();
            }
        }
        if (this.zzeaq == 0 || this.zzear == 0) {
            zzo(i, i2);
        } else {
            zzzy();
        }
        zzaxa.zzdwf.post(new zzbck(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzzb();
            this.zzeav = null;
        }
        if (this.zzeeu != null) {
            zzaaa();
            Surface surface = this.zzbiu;
            if (surface != null) {
                surface.release();
            }
            this.zzbiu = null;
            zza((Surface) null, true);
        }
        zzaxa.zzdwf.post(new zzbcm(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzm(i, i2);
        }
        zzaxa.zzdwf.post(new zzbcj(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeak.zzc(this);
        this.zzebg.zza(surfaceTexture, this.zzeay);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzawr.zzeg(sb.toString());
        zzaxa.zzdwf.post(new zzbcl(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        if (zzzv()) {
            if (this.zzeet.zzedr) {
                zzaaa();
            }
            this.zzeeu.zzaah().zzg(false);
            this.zzeak.zzzq();
            this.zzebh.zzzq();
            zzaxa.zzdwf.post(new zzbch(this));
        }
    }

    public final void play() {
        if (zzzv()) {
            if (this.zzeet.zzedr) {
                zzzz();
            }
            this.zzeeu.zzaah().zzg(true);
            this.zzeak.zzzp();
            this.zzebh.zzzp();
            this.zzebg.zzyq();
            zzaxa.zzdwf.post(new zzbci(this));
            return;
        }
        this.zzeez = true;
    }

    public final void seekTo(int i) {
        if (zzzv()) {
            this.zzeeu.zzaah().seekTo((long) i);
        }
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeev = str;
            this.zzebw = new String[]{str};
            zzzw();
        }
    }

    public final void stop() {
        if (zzzu()) {
            this.zzeeu.zzaah().stop();
            if (this.zzeeu != null) {
                zza((Surface) null, true);
                zzbcu zzbcu = this.zzeeu;
                if (zzbcu != null) {
                    zzbcu.zza((zzbdc) null);
                    this.zzeeu.release();
                    this.zzeeu = null;
                }
                this.zzeex = 1;
                this.zzeew = false;
                this.zzeey = false;
                this.zzeez = false;
            }
        }
        this.zzeak.zzzq();
        this.zzebh.zzzq();
        this.zzeak.onStop();
    }

    public final void zza(float f, float f2) {
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzb(f, f2);
        }
    }

    public final void zza(zzbbf zzbbf) {
        this.zzeay = zzbbf;
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder b = C0681a.m337b(C0681a.m336b(message, C0681a.m336b(canonicalName, C0681a.m336b(str, 2))), str, "/", canonicalName, ":");
        b.append(message);
        String sb = b.toString();
        String valueOf = String.valueOf(sb);
        zzazw.zzfc(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeew = true;
        if (this.zzeet.zzedr) {
            zzaaa();
        }
        zzaxa.zzdwf.post(new zzbcf(this, sb));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaab() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzys();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaac() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyp();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaad() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaae() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyq();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaf() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyr();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaag() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzfa();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzeev = str;
            this.zzebw = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzzw();
        }
    }

    public final void zzb(boolean z, long j) {
        if (this.zzebj != null) {
            zzbab.zzdzv.execute(new zzbco(this, z, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzebj.zza(z, j);
    }

    public final void zzde(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdl(i);
        }
    }

    public final void zzdf(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdm(i);
        }
    }

    public final void zzdg(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdg(i);
        }
    }

    public final void zzdh(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdh(i);
        }
    }

    public final void zzdi(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzdi(i);
        }
    }

    public final void zzdj(int i) {
        if (this.zzeex != i) {
            this.zzeex = i;
            if (i == 3) {
                zzzx();
            } else if (i == 4) {
                if (this.zzeet.zzedr) {
                    zzaaa();
                }
                this.zzeak.zzzq();
                this.zzebh.zzzq();
                zzaxa.zzdwf.post(new zzbcg(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdk(int i) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfi(String str) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzm("ExoPlayerAdapter error", str);
        }
    }

    public final void zzn(int i, int i2) {
        this.zzeaq = i;
        this.zzear = i2;
        zzzy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzk(i, i2);
        }
    }

    public final String zzyk() {
        String str = this.zzeaw ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zzyo() {
        zza(this.zzebh.getVolume(), false);
    }
}
