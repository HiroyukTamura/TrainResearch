// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

final class zzb implements zza
{
    private /* synthetic */ Batch zzaAG;
    
    zzb(final Batch zzaAG) {
        this.zzaAG = zzaAG;
    }
    
    @Override
    public final void zzo(Status zzaBm) {
        while (true) {
        Label_0101:
            while (true) {
                synchronized (this.zzaAG.mLock) {
                    if (this.zzaAG.isCanceled()) {
                        return;
                    }
                    if (zzaBm.isCanceled()) {
                        Batch.zza(this.zzaAG, true);
                        this.zzaAG.zzaAC--;
                        if (this.zzaAG.zzaAC == 0) {
                            if (!this.zzaAG.zzaAE) {
                                break Label_0101;
                            }
                            this.zzaAG.cancel();
                        }
                        return;
                    }
                }
                final Status status;
                if (!status.isSuccess()) {
                    Batch.zzb(this.zzaAG, true);
                    continue;
                }
                continue;
            }
            if (this.zzaAG.zzaAD) {
                zzaBm = new Status(13);
            }
            else {
                zzaBm = Status.zzaBm;
            }
            this.zzaAG.setResult(new BatchResult(zzaBm, this.zzaAG.zzaAF));
        }
    }
}
