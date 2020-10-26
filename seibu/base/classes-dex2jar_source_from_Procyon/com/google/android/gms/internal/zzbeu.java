// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.PendingResult;
import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzbeu extends Handler
{
    private /* synthetic */ zzbes zzaFi;
    
    public zzbeu(final zzbes zzaFi, final Looper looper) {
        this.zzaFi = zzaFi;
        super(looper);
    }
    
    public final void handleMessage(Message zzf) {
        switch (zzf.what) {
            default: {
                Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(zzf.what).toString());
            }
            case 0: {
                final PendingResult pendingResult = (PendingResult)zzf.obj;
                zzf = (Message)this.zzaFi.zzaBW;
                // monitorenter(zzf)
                Label_0112: {
                    if (pendingResult != null) {
                        break Label_0112;
                    }
                    try {
                        this.zzaFi.zzaFb.zzv(new Status(13, "Transform returned null"));
                        return;
                    }
                    finally {
                    }
                    // monitorexit(zzf)
                }
                if (pendingResult instanceof zzbeh) {
                    this.zzaFi.zzaFb.zzv(((zzbeh<?>)pendingResult).getStatus());
                    return;
                }
                this.zzaFi.zzaFb.zza(pendingResult);
            }
            case 1: {
                final RuntimeException ex = (RuntimeException)zzf.obj;
                final String value = String.valueOf(ex.getMessage());
                String concat;
                if (value.length() != 0) {
                    concat = "Runtime exception on the transformation worker thread: ".concat(value);
                }
                else {
                    concat = new String("Runtime exception on the transformation worker thread: ");
                }
                Log.e("TransformedResultImpl", concat);
                throw ex;
            }
        }
    }
}
