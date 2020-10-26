// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import android.support.annotation.RawRes;
import java.util.Iterator;
import android.support.annotation.RequiresPermission;
import android.content.ComponentCallbacks;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import android.content.Context;

public class TagManager
{
    private static TagManager zzbGW;
    private final Context mContext;
    private final DataLayer zzbDx;
    private final zzal zzbFW;
    private final zza zzbGT;
    private final zzfn zzbGU;
    private final ConcurrentMap<String, zzv> zzbGV;
    
    private TagManager(final Context context, final zza zzbGT, final DataLayer zzbDx, final zzfn zzbGU) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzbGU = zzbGU;
        this.zzbGT = zzbGT;
        this.zzbGV = new ConcurrentHashMap<String, zzv>();
        (this.zzbDx = zzbDx).zza((DataLayer.zzb)new zzgb(this));
        this.zzbDx.zza((DataLayer.zzb)new zzg(this.mContext));
        this.zzbFW = new zzal();
        this.mContext.registerComponentCallbacks((ComponentCallbacks)new zzgd(this));
        com.google.android.gms.tagmanager.zza.zzbl(this.mContext);
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public static TagManager getInstance(final Context context) {
        Label_0068: {
            synchronized (TagManager.class) {
                if (TagManager.zzbGW != null) {
                    break Label_0068;
                }
                if (context == null) {
                    zzdj.e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
            }
            final Context context2;
            TagManager.zzbGW = new TagManager(context2, (zza)new zzgc(), new DataLayer((DataLayer.zzc)new zzat(context2)), zzfo.zzBV());
        }
        // monitorexit(TagManager.class)
        return TagManager.zzbGW;
    }
    
    private final void zzfu(final String s) {
        final Iterator<zzv> iterator = this.zzbGV.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().zzeZ(s);
        }
    }
    
    public void dispatch() {
        this.zzbGU.dispatch();
    }
    
    public DataLayer getDataLayer() {
        return this.zzbDx;
    }
    
    public PendingResult<ContainerHolder> loadContainerDefaultOnly(final String s, @RawRes final int n) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, null, s, n, this.zzbFW);
        zza.zzAN();
        return zza;
    }
    
    public PendingResult<ContainerHolder> loadContainerDefaultOnly(final String s, @RawRes final int n, final Handler handler) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, handler.getLooper(), s, n, this.zzbFW);
        zza.zzAN();
        return zza;
    }
    
    public PendingResult<ContainerHolder> loadContainerPreferFresh(final String s, @RawRes final int n) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, null, s, n, this.zzbFW);
        zza.zzAP();
        return zza;
    }
    
    public PendingResult<ContainerHolder> loadContainerPreferFresh(final String s, @RawRes final int n, final Handler handler) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, handler.getLooper(), s, n, this.zzbFW);
        zza.zzAP();
        return zza;
    }
    
    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(final String s, @RawRes final int n) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, null, s, n, this.zzbFW);
        zza.zzAO();
        return zza;
    }
    
    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(final String s, @RawRes final int n, final Handler handler) {
        final zzy zza = this.zzbGT.zza(this.mContext, this, handler.getLooper(), s, n, this.zzbFW);
        zza.zzAO();
        return zza;
    }
    
    public void setVerboseLoggingEnabled(final boolean b) {
        int logLevel;
        if (b) {
            logLevel = 2;
        }
        else {
            logLevel = 5;
        }
        zzdj.setLogLevel(logLevel);
    }
    
    public final int zza(final zzv zzv) {
        this.zzbGV.put(zzv.getContainerId(), zzv);
        return this.zzbGV.size();
    }
    
    public final boolean zzb(final zzv zzv) {
        return this.zzbGV.remove(zzv.getContainerId()) != null;
    }
    
    final boolean zzr(final Uri uri) {
    Label_0064_Outer:
        while (true) {
            while (true) {
                final zzei zzBD;
                String containerId = null;
                Label_0105: {
                    synchronized (this) {
                        zzBD = zzei.zzBD();
                        if (zzBD.zzr(uri)) {
                            containerId = zzBD.getContainerId();
                            switch (zzge.zzbGY[zzBD.zzBE().ordinal()]) {
                                case 1: {
                                    final zzv zzv = this.zzbGV.get(containerId);
                                    if (zzv != null) {
                                        zzv.zzfa(null);
                                        zzv.refresh();
                                        break;
                                    }
                                    break;
                                }
                                case 2:
                                case 3: {
                                    break Label_0105;
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                }
                for (final String s : this.zzbGV.keySet()) {
                    final zzv zzv2 = this.zzbGV.get(s);
                    if (s.equals(containerId)) {
                        zzv2.zzfa(zzBD.zzBF());
                        zzv2.refresh();
                    }
                    else {
                        if (zzv2.zzAK() == null) {
                            continue Label_0064_Outer;
                        }
                        zzv2.zzfa(null);
                        zzv2.refresh();
                    }
                }
                continue;
            }
            return false;
        }
    }
    
    public interface zza
    {
        zzy zza(final Context p0, final TagManager p1, final Looper p2, final String p3, final int p4, final zzal p5);
    }
}
