// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import java.io.IOException;
import android.util.Log;
import android.os.ConditionVariable;
import android.content.Intent;

final class zzo implements zzp
{
    private Intent intent;
    private final ConditionVariable zzckK;
    private String zzckL;
    
    private zzo() {
        this.zzckK = new ConditionVariable();
    }
    
    @Override
    public final void onError(final String zzckL) {
        this.zzckL = zzckL;
        this.zzckK.open();
    }
    
    public final Intent zzJW() throws IOException {
        if (!this.zzckK.block(30000L)) {
            Log.w("InstanceID/Rpc", "No response");
            throw new IOException("TIMEOUT");
        }
        if (this.zzckL != null) {
            throw new IOException(this.zzckL);
        }
        return this.intent;
    }
    
    @Override
    public final void zzq(final Intent intent) {
        this.intent = intent;
        this.zzckK.open();
    }
}
