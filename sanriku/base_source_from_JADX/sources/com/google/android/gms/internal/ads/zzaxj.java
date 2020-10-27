package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.support.p001v4.media.session.PlaybackStateCompat;
import android.view.View;

@TargetApi(18)
public class zzaxj extends zzaxk {
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    public final int zzxk() {
        return 14;
    }

    public final long zzxo() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcom)).booleanValue()) {
            return -1;
        }
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }
}
