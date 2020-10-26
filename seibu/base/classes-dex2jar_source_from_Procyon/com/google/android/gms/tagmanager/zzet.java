// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import com.google.android.gms.internal.zzbq;
import android.content.Context;

final class zzet implements zzag
{
    private boolean mClosed;
    private final Context mContext;
    private String zzbDU;
    private final String zzbDw;
    private zzdi<zzbq> zzbFV;
    private zzal zzbFW;
    private final ScheduledExecutorService zzbFY;
    private final zzew zzbFZ;
    private ScheduledFuture<?> zzbGa;
    
    public zzet(final Context context, final String s, final zzal zzal) {
        this(context, s, zzal, null, null);
    }
    
    private zzet(final Context mContext, final String zzbDw, final zzal zzbFW, final zzex zzex, final zzew zzew) {
        this.zzbFW = zzbFW;
        this.mContext = mContext;
        this.zzbDw = zzbDw;
        this.zzbFY = new zzeu(this).zzBH();
        this.zzbFZ = new zzev(this);
    }
    
    private final void zzBG() {
        synchronized (this) {
            if (this.mClosed) {
                throw new IllegalStateException("called method after closed");
            }
        }
    }
    // monitorexit(this)
    
    @Override
    public final void release() {
        synchronized (this) {
            this.zzBG();
            if (this.zzbGa != null) {
                this.zzbGa.cancel(false);
            }
            this.zzbFY.shutdown();
            this.mClosed = true;
        }
    }
    
    @Override
    public final void zza(final long lng, final String s) {
        synchronized (this) {
            final String zzbDw = this.zzbDw;
            zzdj.v(new StringBuilder(String.valueOf(zzbDw).length() + 55).append("loadAfterDelay: containerId=").append(zzbDw).append(" delay=").append(lng).toString());
            this.zzBG();
            if (this.zzbFV == null) {
                throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
            }
        }
        if (this.zzbGa != null) {
            this.zzbGa.cancel(false);
        }
        final ScheduledExecutorService zzbFY = this.zzbFY;
        final zzes zza = this.zzbFZ.zza(this.zzbFW);
        zza.zza(this.zzbFV);
        zza.zzfb(this.zzbDU);
        final String s2;
        zza.zzfr(s2);
        this.zzbGa = zzbFY.schedule(zza, lng, TimeUnit.MILLISECONDS);
    }
    // monitorexit(this)
    
    @Override
    public final void zza(final zzdi<zzbq> zzbFV) {
        synchronized (this) {
            this.zzBG();
            this.zzbFV = zzbFV;
        }
    }
    
    @Override
    public final void zzfb(final String zzbDU) {
        synchronized (this) {
            this.zzBG();
            this.zzbDU = zzbDU;
        }
    }
}
