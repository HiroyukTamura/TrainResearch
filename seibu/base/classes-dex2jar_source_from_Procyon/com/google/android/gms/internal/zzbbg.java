// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ResultCallback;
import android.util.Pair;
import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import com.google.android.gms.common.api.Result;

public final class zzbbg<R extends Result> extends Handler
{
    public zzbbg() {
        this(Looper.getMainLooper());
    }
    
    public zzbbg(final Looper looper) {
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), (Throwable)new Exception());
            }
            case 1: {
                final Pair pair = (Pair)message.obj;
                final ResultCallback resultCallback = (ResultCallback)pair.first;
                final Result result = (Result)pair.second;
                try {
                    resultCallback.onResult(result);
                }
                catch (RuntimeException ex) {
                    zzbbe.zzc(result);
                    throw ex;
                }
            }
            case 2: {
                ((zzbbe)message.obj).zzs(Status.zzaBp);
            }
        }
    }
    
    public final void zza(final ResultCallback<? super R> resultCallback, final R r) {
        this.sendMessage(this.obtainMessage(1, (Object)new Pair((Object)resultCallback, (Object)r)));
    }
}
