// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

final class zzv implements ContainerHolder
{
    private Status mStatus;
    private boolean zzaNd;
    private Container zzbDE;
    private Container zzbDF;
    private zzx zzbDG;
    private zzw zzbDH;
    private TagManager zzbDI;
    private final Looper zzrM;
    
    public zzv(final Status mStatus) {
        this.mStatus = mStatus;
        this.zzrM = null;
    }
    
    public zzv(final TagManager zzbDI, Looper mainLooper, final Container zzbDE, final zzw zzbDH) {
        this.zzbDI = zzbDI;
        if (mainLooper == null) {
            mainLooper = Looper.getMainLooper();
        }
        this.zzrM = mainLooper;
        this.zzbDE = zzbDE;
        this.zzbDH = zzbDH;
        this.mStatus = Status.zzaBm;
        zzbDI.zza(this);
    }
    
    private final void zzAL() {
        if (this.zzbDG != null) {
            final zzx zzbDG = this.zzbDG;
            zzbDG.sendMessage(zzbDG.obtainMessage(1, (Object)this.zzbDF.zzAI()));
        }
    }
    
    @Override
    public final Container getContainer() {
        Container zzbDE = null;
        synchronized (this) {
            if (this.zzaNd) {
                zzdj.e("ContainerHolder is released.");
            }
            else {
                if (this.zzbDF != null) {
                    this.zzbDE = this.zzbDF;
                    this.zzbDF = null;
                }
                zzbDE = this.zzbDE;
            }
            return zzbDE;
        }
    }
    
    final String getContainerId() {
        if (this.zzaNd) {
            zzdj.e("getContainerId called on a released ContainerHolder.");
            return "";
        }
        return this.zzbDE.getContainerId();
    }
    
    @Override
    public final Status getStatus() {
        return this.mStatus;
    }
    
    @Override
    public final void refresh() {
        synchronized (this) {
            if (this.zzaNd) {
                zzdj.e("Refreshing a released ContainerHolder.");
            }
            else {
                this.zzbDH.zzAM();
            }
        }
    }
    
    @Override
    public final void release() {
        synchronized (this) {
            if (this.zzaNd) {
                zzdj.e("Releasing a released ContainerHolder.");
            }
            else {
                this.zzaNd = true;
                this.zzbDI.zzb(this);
                this.zzbDE.release();
                this.zzbDE = null;
                this.zzbDF = null;
                this.zzbDH = null;
                this.zzbDG = null;
            }
        }
    }
    
    @Override
    public final void setContainerAvailableListener(final ContainerAvailableListener containerAvailableListener) {
        while (true) {
            Label_0034: {
                synchronized (this) {
                    if (this.zzaNd) {
                        zzdj.e("ContainerHolder is released.");
                    }
                    else {
                        if (containerAvailableListener != null) {
                            break Label_0034;
                        }
                        this.zzbDG = null;
                    }
                    return;
                }
            }
            final ContainerAvailableListener containerAvailableListener2;
            this.zzbDG = new zzx(this, containerAvailableListener2, this.zzrM);
            if (this.zzbDF != null) {
                this.zzAL();
            }
        }
    }
    
    final String zzAK() {
        if (this.zzaNd) {
            zzdj.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        }
        return this.zzbDH.zzAK();
    }
    
    public final void zza(final Container zzbDF) {
        synchronized (this) {
            if (!this.zzaNd) {
                this.zzbDF = zzbDF;
                this.zzAL();
            }
        }
    }
    
    public final void zzeZ(final String s) {
        synchronized (this) {
            if (!this.zzaNd) {
                this.zzbDE.zzeZ(s);
            }
        }
    }
    
    final void zzfa(final String s) {
        if (this.zzaNd) {
            zzdj.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return;
        }
        this.zzbDH.zzfa(s);
    }
}
