// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.List;

final class zzau implements Runnable
{
    private /* synthetic */ List zzbEr;
    private /* synthetic */ long zzbEs;
    private /* synthetic */ zzat zzbEt;
    
    zzau(final zzat zzbEt, final List zzbEr, final long zzbEs) {
        this.zzbEt = zzbEt;
        this.zzbEr = zzbEr;
        this.zzbEs = zzbEs;
    }
    
    @Override
    public final void run() {
        this.zzbEt.zzb(this.zzbEr, this.zzbEs);
    }
}
