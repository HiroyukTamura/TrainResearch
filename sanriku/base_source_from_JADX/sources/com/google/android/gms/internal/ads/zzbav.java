package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResult;

@TargetApi(14)
public final class zzbav extends zzbbi implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeaj = new HashMap();
    private final zzbca zzeak;
    private final boolean zzeal;
    private int zzeam = 0;
    private int zzean = 0;
    private MediaPlayer zzeao;
    private Uri zzeap;
    private int zzeaq;
    private int zzear;
    private int zzeas;
    private int zzeat;
    private int zzeau;
    private zzbbv zzeav;
    private boolean zzeaw;
    private int zzeax;
    /* access modifiers changed from: private */
    public zzbbf zzeay;

    static {
        zzeaj.put(-1004, "MEDIA_ERROR_IO");
        zzeaj.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzeaj.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzeaj.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzeaj.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzeaj.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeaj.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeaj.put(1, "MEDIA_INFO_UNKNOWN");
        zzeaj.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeaj.put(701, "MEDIA_INFO_BUFFERING_START");
        zzeaj.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeaj.put(Integer.valueOf(RFLAdResult.SUCCESS), "MEDIA_INFO_BAD_INTERLEAVING");
        zzeaj.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeaj.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzeaj.put(Integer.valueOf(RFLAdResult.ERROR_NOT_FOUND), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzeaj.put(Integer.valueOf(RFLAdResult.ERROR_PUSH), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzbav(Context context, boolean z, boolean z2, zzbby zzbby, zzbca zzbca) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzeak = zzbca;
        this.zzeaw = z;
        this.zzeal = z2;
        zzbca.zzb(this);
    }

    private final void zzat(boolean z) {
        zzawr.zzeg("AdMediaPlayerView release");
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzzb();
            this.zzeav = null;
        }
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzeao.release();
            this.zzeao = null;
            zzdc(0);
            if (z) {
                this.zzean = 0;
                this.zzean = 0;
            }
        }
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzazw.zzfc("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzdc(int i) {
        if (i == 3) {
            this.zzeak.zzzp();
            this.zzebh.zzzp();
        } else if (this.zzeam == 3) {
            this.zzeak.zzzq();
            this.zzebh.zzzq();
        }
        this.zzeam = i;
    }

    private final void zzyl() {
        zzawr.zzeg("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzeap != null && surfaceTexture != null) {
            zzat(false);
            try {
                zzq.zzlm();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzeao = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzeao.setOnCompletionListener(this);
                this.zzeao.setOnErrorListener(this);
                this.zzeao.setOnInfoListener(this);
                this.zzeao.setOnPreparedListener(this);
                this.zzeao.setOnVideoSizeChangedListener(this);
                this.zzeas = 0;
                if (this.zzeaw) {
                    zzbbv zzbbv = new zzbbv(getContext());
                    this.zzeav = zzbbv;
                    zzbbv.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzeav.start();
                    SurfaceTexture zzzc = this.zzeav.zzzc();
                    if (zzzc != null) {
                        surfaceTexture = zzzc;
                    } else {
                        this.zzeav.zzzb();
                        this.zzeav = null;
                    }
                }
                this.zzeao.setDataSource(getContext(), this.zzeap);
                zzq.zzln();
                this.zzeao.setSurface(new Surface(surfaceTexture));
                this.zzeao.setAudioStreamType(3);
                this.zzeao.setScreenOnWhilePlaying(true);
                this.zzeao.prepareAsync();
                zzdc(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzeap);
                StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzazw.zzd(sb.toString(), e);
                onError(this.zzeao, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzym() {
        /*
            r8 = this;
            boolean r0 = r8.zzeal
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzyn()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzeao
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzean
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.ads.zzawr.zzeg(r0)
            r0 = 0
            r8.zzd(r0)
            android.media.MediaPlayer r0 = r8.zzeao
            r0.start()
            android.media.MediaPlayer r0 = r8.zzeao
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzyn()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzeao
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzld()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzeao
            r0.pause()
            r8.zzyo()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbav.zzym():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzeam;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzyn() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzeao
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzeam
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbav.zzyn():boolean");
    }

    public final int getCurrentPosition() {
        if (zzyn()) {
            return this.zzeao.getCurrentPosition();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzyn()) {
            return this.zzeao.getDuration();
        }
        return -1;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeas = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzawr.zzeg("AdMediaPlayerView completion");
        zzdc(5);
        this.zzean = 5;
        zzaxa.zzdwf.post(new zzbba(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeaj.get(Integer.valueOf(i));
        String str2 = zzeaj.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(C0681a.m336b(str2, C0681a.m336b(str, 38)));
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzazw.zzfc(sb.toString());
        zzdc(-1);
        this.zzean = -1;
        zzaxa.zzdwf.post(new zzbaz(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeaj.get(Integer.valueOf(i));
        String str2 = zzeaj.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(C0681a.m336b(str2, C0681a.m336b(str, 37)));
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzawr.zzeg(sb.toString());
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = TextureView.getDefaultSize(this.zzeaq, i);
        int defaultSize2 = TextureView.getDefaultSize(this.zzear, i2);
        if (this.zzeaq > 0 && this.zzear > 0 && this.zzeav == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.zzeaq;
                int i5 = i4 * size2;
                int i6 = this.zzear;
                if (i5 < size * i6) {
                    defaultSize = (i4 * size2) / i6;
                    defaultSize2 = size2;
                } else {
                    if (i4 * size2 > size * i6) {
                        i3 = (i6 * size) / i4;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.zzear * size) / this.zzeaq;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    i3 = i7;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (this.zzeaq * size2) / this.zzear;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i9 = this.zzeaq;
                int i10 = this.zzear;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size2) / i10;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                } else {
                    i3 = (this.zzear * size) / this.zzeaq;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzm(defaultSize, defaultSize2);
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzawr.zzeg("AdMediaPlayerView prepared");
        zzdc(2);
        this.zzeak.zzfa();
        zzaxa.zzdwf.post(new zzbax(this));
        this.zzeaq = mediaPlayer.getVideoWidth();
        this.zzear = mediaPlayer.getVideoHeight();
        int i = this.zzeax;
        if (i != 0) {
            seekTo(i);
        }
        zzym();
        int i2 = this.zzeaq;
        int i3 = this.zzear;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzazw.zzfb(sb.toString());
        if (this.zzean == 3) {
            play();
        }
        zzyo();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawr.zzeg("AdMediaPlayerView surface created");
        zzyl();
        zzaxa.zzdwf.post(new zzbbc(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawr.zzeg("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null && this.zzeax == 0) {
            this.zzeax = mediaPlayer.getCurrentPosition();
        }
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzzb();
        }
        zzaxa.zzdwf.post(new zzbbe(this));
        zzat(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawr.zzeg("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzean == 3;
        if (!(this.zzeaq == i && this.zzear == i2)) {
            z = false;
        }
        if (this.zzeao != null && z2 && z) {
            int i3 = this.zzeax;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzm(i, i2);
        }
        zzaxa.zzdwf.post(new zzbbb(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeak.zzc(this);
        this.zzebg.zza(surfaceTexture, this.zzeay);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzawr.zzeg(sb.toString());
        this.zzeaq = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzear = videoHeight;
        if (this.zzeaq != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzawr.zzeg(sb.toString());
        zzaxa.zzdwf.post(new zzbay(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        zzawr.zzeg("AdMediaPlayerView pause");
        if (zzyn() && this.zzeao.isPlaying()) {
            this.zzeao.pause();
            zzdc(4);
            zzaxa.zzdwf.post(new zzbbg(this));
        }
        this.zzean = 4;
    }

    public final void play() {
        zzawr.zzeg("AdMediaPlayerView play");
        if (zzyn()) {
            this.zzeao.start();
            zzdc(3);
            this.zzebg.zzyq();
            zzaxa.zzdwf.post(new zzbbd(this));
        }
        this.zzean = 3;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzawr.zzeg(sb.toString());
        if (zzyn()) {
            this.zzeao.seekTo(i);
            this.zzeax = 0;
            return;
        }
        this.zzeax = i;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzsf zzd = zzsf.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzeap = parse;
            this.zzeax = 0;
            zzyl();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzawr.zzeg("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzeao;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzeao.release();
            this.zzeao = null;
            zzdc(0);
            this.zzean = 0;
        }
        this.zzeak.onStop();
    }

    public final String toString() {
        String name = zzbav.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return C0681a.m313a(C0681a.m336b(hexString, name.length() + 1), name, "@", hexString);
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

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdd(int i) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.onWindowVisibilityChanged(i);
        }
    }

    public final String zzyk() {
        String str = this.zzeaw ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    public final void zzyo() {
        zzd(this.zzebh.getVolume());
    }
}
