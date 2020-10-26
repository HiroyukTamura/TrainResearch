// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.content.Intent;

final class zzc implements Runnable
{
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ Intent zzckg;
    private /* synthetic */ zzb zzckh;
    
    zzc(final zzb zzckh, final Intent val$intent, final Intent zzckg) {
        this.zzckh = zzckh;
        this.val$intent = val$intent;
        this.zzckg = zzckg;
    }
    
    @Override
    public final void run() {
        this.zzckh.handleIntent(this.val$intent);
        this.zzckh.zzm(this.zzckg);
    }
}
