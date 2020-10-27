package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
public final class zzpc extends Surface {
    private static boolean zzbic;
    private static boolean zzbid;
    private final boolean zzbab;
    private final zzpe zzbie;
    private boolean zzbif;

    private zzpc(zzpe zzpe, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbie = zzpe;
        this.zzbab = z;
    }

    public static zzpc zzc(Context context, boolean z) {
        if (zzov.SDK_INT >= 17) {
            zzoh.checkState(!z || zzc(context));
            return new zzpe().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzpc.class) {
            if (!zzbid) {
                if (zzov.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzov.SDK_INT == 24 && (zzov.MODEL.startsWith("SM-G950") || zzov.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zzbic = z2;
                }
                zzbid = true;
            }
            z = zzbic;
        }
        return z;
    }

    public final void release() {
        super.release();
        synchronized (this.zzbie) {
            if (!this.zzbif) {
                this.zzbie.release();
                this.zzbif = true;
            }
        }
    }
}
